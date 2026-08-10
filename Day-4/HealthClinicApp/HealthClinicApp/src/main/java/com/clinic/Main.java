package com.clinic;

import com.clinic.config.HikariConnectionPool;
import com.clinic.ui.ConsoleMenu;

public class Main {
    public static void main(String[] args) {
        try {
            new ConsoleMenu().start();
        } finally {
            // Release pooled DB connections cleanly on shutdown.
            HikariConnectionPool.shutdown();
        }
    }
}
