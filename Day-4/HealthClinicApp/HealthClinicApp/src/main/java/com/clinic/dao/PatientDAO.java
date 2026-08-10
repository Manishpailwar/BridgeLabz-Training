package com.clinic.dao;

import com.clinic.dto.Patient;
import java.util.List;

/** Contract only - no SQL here. Any class implementing this promises these operations. */
public interface PatientDAO {
    int insertPatient(Patient patient);
    Patient getPatientById(int id);
    List<Patient> getAllPatients();
    boolean updatePatient(Patient patient);
    boolean deletePatient(int id); // soft delete - flips is_active to false
}
