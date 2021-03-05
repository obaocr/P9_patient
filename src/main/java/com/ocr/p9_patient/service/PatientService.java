package com.ocr.p9_patient.service;

import com.ocr.p9_patient.model.Patient;

import java.util.List;

/**
 * PatientService Interface
 */
public interface PatientService {
    public List<Patient> getPatients();
    public List<Patient> getPatientsByName(String name);
    public Patient getPatientById(Integer Id);
    public Integer addPatient(Patient patient);
    public Boolean updatePatient(Patient patient);
    public Boolean deletePatientById(Integer Id);
}
