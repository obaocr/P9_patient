package com.ocr.p9_patient.service;

import com.ocr.p9_patient.Utils.EntityNotFoundException;
import com.ocr.p9_patient.model.Patient;
import com.ocr.p9_patient.repository.PatientRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * PatientServiceImpl : implementation for patient
 */

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
        if (patientRepository.findById(Id).isPresent()) {
            return patientRepository.findById(Id).get();
        } else {
            throw new EntityNotFoundException("Patient not found for Id: " + Id);
        }

    }

    @Override
    public Integer addPatient(Patient patient) {
        log.debug("getPatientById");
        LocalDateTime dtUpdate = LocalDateTime.now();
        patient.setCreateDate(dtUpdate);
        patient.setUpdateDate(dtUpdate);
        return patientRepository.save(patient).getId();
    }

    @Override
    public Boolean updatePatient(Patient patient) {
        log.debug("updatePatient");
        Patient patientToUpdate = this.getPatientById(patient.getId());
        patientToUpdate.setFamilly(patient.getFamilly());
        patientToUpdate.setGiven(patient.getGiven());
        patientToUpdate.setSex(patient.getSex());
        patientToUpdate.setAddress(patient.getAddress());
        patientToUpdate.setPhone(patient.getPhone());
        patientToUpdate.setBirthDate(patient.getBirthDate());
        LocalDateTime dtUpdate = LocalDateTime.now();
        patientToUpdate.setUpdateDate(dtUpdate);
        patientRepository.save(patientToUpdate);
        return true;
    }

    @Override
    public Boolean deletePatientById(Integer Id) {
        log.debug("deletePatientById");
        Patient patientToDelete = this.getPatientById(Id);
        patientRepository.deleteById(Id);
        return true;
    }

}
