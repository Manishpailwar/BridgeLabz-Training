package com.clinic.dao;

import com.clinic.dto.VisitHistory;
import java.sql.Connection;
import java.util.List;

public interface VisitHistoryDAO {
    int insertVisitHistory(VisitHistory visit);
    VisitHistory getVisitByAppointmentId(int appointmentId);
    List<VisitHistory> getAllVisitHistories();
    boolean updateVisitHistory(VisitHistory visit);
    boolean deleteVisitHistory(int visitId);

    // Used by the Service layer so this write can share the caller's transaction/connection.
    void insertVisitHistory(Connection conn, int appointmentId, String diagnosis) throws java.sql.SQLException;
}
