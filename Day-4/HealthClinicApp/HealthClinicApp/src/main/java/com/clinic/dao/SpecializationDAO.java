package com.clinic.dao;

import com.clinic.dto.Specialization;
import java.util.List;

public interface SpecializationDAO {
    int insertSpecialization(Specialization spec);
    Specialization getSpecializationById(int id);
    List<Specialization> getAllSpecializations();
    boolean updateSpecialization(Specialization spec);
    boolean deleteSpecialization(int id);
}
