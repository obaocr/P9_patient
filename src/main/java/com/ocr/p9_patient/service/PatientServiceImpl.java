package com.ocr.p9_patient.service;

import Utils.EntityNotFoundException;
import com.ocr.p9_patient.model.Patient;
import com.ocr.p9_patient.repository.PatientRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

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
        if(patientRepository.findById(Id).isPresent()) {
            return patientRepository.findById(Id).get();
        } else {
            throw new EntityNotFoundException("Patient not found for Id: " + Id);
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
        this.getPatientById(patient.getId());
        patientRepository.save(patient);
        return true;
    }

}
