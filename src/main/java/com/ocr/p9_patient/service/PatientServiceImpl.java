package com.ocr.p9_patient.service;

import com.ocr.p9_patient.model.Patient;
import com.ocr.p9_patient.repository.PatientRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// TODO gérer les erreurs DML, exceptions ?

@Service
public class PatientServiceImpl implements  PatientService {

    private static final Logger log = LogManager.getLogger(PatientServiceImpl.class);

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getPatients() {
        log.debug("getPatients");
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Integer Id) {
        log.debug("getPatientById");
        Optional<Patient> patient = patientRepository.findById(Id);
        if(patient != null) {
            return patient.get();
        } else {
            throw new IllegalArgumentException("Invalid Patient Id:" + Id);
        }
    }

    @Override
    public Integer addPatient(Patient patient) {
        log.debug("getPatientById");
        return patientRepository.save(patient).getId();
    }

    @Override
    public Boolean updatePatient(Patient patient) {
        log.debug("updatePatient");
        patientRepository.save(patient);
        return true;
    }
}
