package com.clinic.service;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dao.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Floor 3 — the safety net.
 *
 * "Complete an appointment" is really three separate writes (status update, bill, visit
 * record). This class makes sure they happen as a single atomic unit: either all three
 * succeed and get saved together, or none of them do.
 */
public class AppointmentService {

    private final AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    private final BillingDAO billingDAO = new BillingDAOImpl();
    private final VisitHistoryDAO visitHistoryDAO = new VisitHistoryDAOImpl();

    public boolean completeAppointment(int appointmentId, BigDecimal amount, String diagnosis) {
        Connection conn = null;
        try {
            conn = HikariConnectionPool.getConnection();
            conn.setAutoCommit(false); // stop auto-saving after each statement

            // Write 1: mark appointment as completed
            boolean statusUpdated = appointmentDAO.updateStatus(conn, appointmentId, "Completed");
            if (!statusUpdated) {
                // No such appointment - nothing to roll forward, bail out cleanly.
                conn.rollback();
                System.out.println("No appointment found with ID " + appointmentId + ". Nothing was changed.");
                return false;
            }

            // Write 2: create the bill
            billingDAO.insertBilling(conn, appointmentId, amount);

            // Write 3: record what happened during the visit
            visitHistoryDAO.insertVisitHistory(conn, appointmentId, diagnosis);

            conn.commit(); // all 3 worked -> save everything for real
            return true;

        } catch (SQLException e) {
            System.out.println("Something failed, undoing everything: " + e.getMessage());
            if (conn != null) {
                try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            }
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close(); // returns the connection to the pool, doesn't actually disconnect
                } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }
}
