package com.clinic.dao;

import com.clinic.dto.Doctor;
import com.clinic.dto.Specialization;
import java.util.List;

public interface DoctorDAO {
    int insertDoctor(Doctor doctor);
    Doctor getDoctorById(int id);
    List<Doctor> getAllDoctors();
    boolean updateDoctor(Doctor doctor);
    boolean deleteDoctor(int id); // soft delete

    // Doctor <-> Specialization (many-to-many junction table)
    boolean assignSpecialization(int doctorId, int specializationId);
    boolean removeSpecialization(int doctorId, int specializationId);
    List<Specialization> getSpecializationsForDoctor(int doctorId);
}
