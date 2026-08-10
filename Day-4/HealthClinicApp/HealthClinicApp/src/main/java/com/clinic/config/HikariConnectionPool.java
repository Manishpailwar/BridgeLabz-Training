package com.clinic.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * The single doorway every DAO uses to reach MySQL.
 *
 * This is the "hardened" Step 3 from the walkthrough: instead of opening a brand-new
 * TCP connection to MySQL on every single call (fine for learning, wasteful in real use),
 * we keep a small pool of already-open connections ready to hand out. DAOs still just call
 * getConnection() exactly like before — nothing above this class needed to change.
 */
public class HikariConnectionPool {

    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/health_clinic_db?useSSL=false&serverTimezone=UTC");
        config.setUsername("clinic_app_user");
        config.setPassword("StrongPassword123!");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        // Pool sizing - modest defaults, fine for a single-receptionist console app
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);
        config.setConnectionTimeout(30000);   // 30s wait for a free connection before giving up
        config.setIdleTimeout(600000);        // 10 min idle before a connection is retired
        config.setPoolName("ClinicPool");

        dataSource = new HikariDataSource(config);
    }

    private HikariConnectionPool() {}

    /** Hands back a live connection from the pool. Caller is responsible for closing it
     *  (which, with a pool, just returns it rather than actually disconnecting). */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /** Call once when the app is shutting down to release pooled connections cleanly. */
    public static void shutdown() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }
    }
}
