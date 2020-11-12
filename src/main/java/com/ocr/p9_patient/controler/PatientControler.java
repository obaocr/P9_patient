package com.ocr.p9_patient.controler;

import Utils.EntityIllegalArgumentException;
import com.ocr.p9_patient.model.Patient;
import com.ocr.p9_patient.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controler for Patient
 */
@RestController
public class PatientControler {

    private Logger logger = LoggerFactory.getLogger(PatientControler.class);

    @Autowired
    PatientService patientService;

    private void checkInput(Patient patient) {
        if (patient == null || patient.getFirstName().isEmpty() || patient.getLastName().isEmpty() ||  patient.getAddress().isEmpty()
                || patient.getBirthDate() == null || patient.getFamilly().isEmpty() ||  patient.getGiven().isEmpty() || patient.getSex().isEmpty()) {
            logger.error("All fields are mandatory for a Patient");
            throw new EntityIllegalArgumentException("All fields are mandatory for a Patient");
        }
    }

    @GetMapping("/")
    public String patientHome() {
        logger.debug("patientHome");
        return "P9 Patient Home";
    }

    @GetMapping("/Patients")
    public List<Patient> getAllPatient() {
        logger.debug("getAllPatient");
        return patientService.getPatients();
    }

    @GetMapping("/Patient")
    public Patient getPatientById(@RequestParam Integer Id) {
        logger.debug("getPatientById");
        if (Id == null || Id == 0 ) {
            logger.error("The parameter Id is mandatory and must be > 0");
            throw new EntityIllegalArgumentException("The parameter Id is mandatory and must be > 0");
        }
        return patientService.getPatientById(Id);
    }

    @PutMapping(value = "/Patient/{Id}")
    public Boolean updatePatient(@PathVariable("Id") Integer Id, @RequestBody @Valid Patient patient) {
        logger.debug("updatePatient");
        checkInput(patient);
        return patientService.updatePatient(patient);
    }

    @PostMapping(value = "/Patient")
    public Integer addPatient(@RequestBody @Valid Patient patient) {
        logger.debug("addPatient");
        checkInput(patient);
        return patientService.addPatient(patient);
    }

}