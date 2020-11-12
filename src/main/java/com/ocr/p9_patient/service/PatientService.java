package com.ocr.p9_patient.service;

import com.ocr.p9_patient.model.Patient;

import java.util.List;

public interface PatientService {
    public List<Patient> getPatients();
    public Patient getPatientById(Integer Id);
    public Integer addPatient(Patient patient);
    public Boolean updatePatient(Patient patient);
}
