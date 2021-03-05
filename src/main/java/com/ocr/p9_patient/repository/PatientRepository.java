package com.ocr.p9_patient.repository;

import com.ocr.p9_patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PatientRepository Interface
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findPatientsByFamilly(String name);
}
