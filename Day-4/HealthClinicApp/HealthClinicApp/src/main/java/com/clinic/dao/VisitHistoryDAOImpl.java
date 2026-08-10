package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.VisitHistory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisitHistoryDAOImpl implements VisitHistoryDAO {

    @Override
    public int insertVisitHistory(VisitHistory visit) {
        String sql = "INSERT INTO visit_history (appointment_id, diagnosis, prescription, visit_notes) VALUES (?, ?, ?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, visit.getAppointmentId());
            pstmt.setString(2, visit.getDiagnosis());
            pstmt.setString(3, visit.getPrescription());
            pstmt.setString(4, visit.getVisitNotes());
            pstmt.executeUpdate();
            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next()) return keys.getInt(1);
        } catch (SQLException e) {
            System.out.println("Insert visit history failed: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public VisitHistory getVisitByAppointmentId(int appointmentId) {
        String sql = "SELECT * FROM visit_history WHERE appointment_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointmentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        } catch (SQLException e) {
            System.out.println("Query visit history failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<VisitHistory> getAllVisitHistories() {
        List<VisitHistory> list = new ArrayList<>();
        String sql = "SELECT * FROM visit_history ORDER BY visit_id";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) list.add(mapRow(rs));
        } catch (SQLException e) {
            System.out.println("Fetch all visit histories failed: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean updateVisitHistory(VisitHistory visit) {
        String sql = "UPDATE visit_history SET diagnosis=?, prescription=?, visit_notes=? WHERE visit_id=?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, visit.getDiagnosis());
            pstmt.setString(2, visit.getPrescription());
            pstmt.setString(3, visit.getVisitNotes());
            pstmt.setInt(4, visit.getVisitId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Update visit history failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteVisitHistory(int visitId) {
        String sql = "DELETE FROM visit_history WHERE visit_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, visitId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Delete visit history failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void insertVisitHistory(Connection conn, int appointmentId, String diagnosis) throws SQLException {
        String sql = "INSERT INTO visit_history (appointment_id, diagnosis) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointmentId);
            pstmt.setString(2, diagnosis);
            pstmt.executeUpdate();
        }
    }

    private VisitHistory mapRow(ResultSet rs) throws SQLException {
        VisitHistory v = new VisitHistory();
        v.setVisitId(rs.getInt("visit_id"));
        v.setAppointmentId(rs.getInt("appointment_id"));
        v.setDiagnosis(rs.getString("diagnosis"));
        v.setPrescription(rs.getString("prescription"));
        v.setVisitNotes(rs.getString("visit_notes"));
        return v;
    }
}
