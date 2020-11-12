package com.ocr.p9_patient.service;

import com.ocr.p9_patient.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PatientServiceIntgTest {

    @Autowired
    private PatientService patientService;

    @Test
    void addPatient() {
        Date birth = new Date();
        Patient patient = new Patient("Martin", "Alain", "TestFamille", "Test", "12 rue des oliviers", "M", birth);
        Integer Id = patientService.addPatient(patient);
        assertTrue(Id > 0);
    }

    @Test
    void updatePatient() {
        Date birth = new Date();
        Patient patient = new Patient("Martin", "Alain", "TestFamille", "Test", "12 rue des oliviers", "M", birth);
        Integer Id = patientService.addPatient(patient);
        assertTrue(Id > 0);
        //
        Patient patient1 = patientService.getPatientById(Id);
        assertTrue(patient1 != null);
        //
        patient1.setFirstName("Christian");
        patient1.setLastName("Dupont");
        patientService.updatePatient(patient1);
        //
        patient1 = patientService.getPatientById(Id);
        assertTrue(patient1.getFirstName() == "Christian");
        assertTrue(patient1.getLastName() == "Dupont");

    }

}
