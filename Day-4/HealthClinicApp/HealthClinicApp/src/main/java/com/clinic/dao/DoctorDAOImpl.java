package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Doctor;
import com.clinic.dto.Specialization;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {

    @Override
    public int insertDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctors (first_name, last_name, phone_number, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, doctor.getFirstName());
            pstmt.setString(2, doctor.getLastName());
            pstmt.setString(3, doctor.getPhoneNumber());
            pstmt.setString(4, doctor.getEmail());
            pstmt.executeUpdate();
            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next()) return keys.getInt(1);
        } catch (SQLException e) {
            System.out.println("Insert doctor failed: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public Doctor getDoctorById(int id) {
        String sql = "SELECT * FROM doctors WHERE doctor_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Doctor d = mapRow(rs);
                    d.setSpecializations(getSpecializationsForDoctor(id));
                    return d;
                }
            }
        } catch (SQLException e) {
            System.out.println("Query doctor failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctors ORDER BY doctor_id";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) doctors.add(mapRow(rs));
        } catch (SQLException e) {
            System.out.println("Fetch all doctors failed: " + e.getMessage());
        }
        return doctors;
    }

    @Override
    public boolean updateDoctor(Doctor doctor) {
        String sql = "UPDATE doctors SET first_name=?, last_name=?, phone_number=?, email=? WHERE doctor_id=?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, doctor.getFirstName());
            pstmt.setString(2, doctor.getLastName());
            pstmt.setString(3, doctor.getPhoneNumber());
            pstmt.setString(4, doctor.getEmail());
            pstmt.setInt(5, doctor.getDoctorId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Update doctor failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteDoctor(int id) {
        String sql = "UPDATE doctors SET is_active = FALSE WHERE doctor_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Delete doctor failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean assignSpecialization(int doctorId, int specializationId) {
        String sql = "INSERT IGNORE INTO doctor_specializations (doctor_id, specialization_id) VALUES (?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, doctorId);
            pstmt.setInt(2, specializationId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Assign specialization failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean removeSpecialization(int doctorId, int specializationId) {
        String sql = "DELETE FROM doctor_specializations WHERE doctor_id=? AND specialization_id=?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, doctorId);
            pstmt.setInt(2, specializationId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Remove specialization failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Specialization> getSpecializationsForDoctor(int doctorId) {
        List<Specialization> list = new ArrayList<>();
        String sql = "SELECT s.* FROM specializations s " +
                "JOIN doctor_specializations ds ON s.specialization_id = ds.specialization_id " +
                "WHERE ds.doctor_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, doctorId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Specialization s = new Specialization();
                    s.setSpecializationId(rs.getInt("specialization_id"));
                    s.setName(rs.getString("name"));
                    s.setDescription(rs.getString("description"));
                    list.add(s);
                }
            }
        } catch (SQLException e) {
            System.out.println("Fetch doctor specializations failed: " + e.getMessage());
        }
        return list;
    }

    private Doctor mapRow(ResultSet rs) throws SQLException {
        Doctor d = new Doctor();
        d.setDoctorId(rs.getInt("doctor_id"));
        d.setFirstName(rs.getString("first_name"));
        d.setLastName(rs.getString("last_name"));
        d.setPhoneNumber(rs.getString("phone_number"));
        d.setEmail(rs.getString("email"));
        d.setActive(rs.getBoolean("is_active"));
        return d;
    }
}
