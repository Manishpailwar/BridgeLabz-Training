package com.clinic.dao;

import com.clinic.dto.Billing;
import java.sql.Connection;
import java.util.List;

public interface BillingDAO {
    int insertBilling(Billing billing);
    Billing getBillingByAppointmentId(int appointmentId);
    List<Billing> getAllBillings();
    boolean markAsPaid(int billId);
    boolean deleteBilling(int billId);

    // Used by the Service layer so this write can share the caller's transaction/connection.
    void insertBilling(Connection conn, int appointmentId, java.math.BigDecimal amount) throws java.sql.SQLException;
}
