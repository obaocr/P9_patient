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
    void patientGetById_NotFound() {
        try {
            Patient patient = patientService.getPatientById(123456);
        } catch (Exception e) {
            System.out.println("Exception du test :" + e.toString());
            assertTrue(e.toString().contains("Patient not found"));
        }
    }

    @Test
    void addPatient() {
        Date birth = new Date();
        Patient patient = new Patient("Martin", "Alain",  "12 rue des oliviers", "M", birth,"+33 123456789");
        Integer Id = patientService.addPatient(patient);
        assertTrue(Id > 0);
    }

    @Test
    void updatePatient() {
        Date birth = new Date();
        Patient patient = new Patient("Martin", "Alain",  "12 rue des oliviers", "M", birth,"+33 123456789");
        Integer Id = patientService.addPatient(patient);
        assertTrue(Id > 0);
        //
        Patient patient1 = patientService.getPatientById(Id);
        assertTrue(patient1 != null);
        //
        patient1.setFamilly("Christian");
        patient1.setGiven("Dupont");
        patientService.updatePatient(patient1);
        //
        patient1 = patientService.getPatientById(Id);
        assertTrue(patient1.getFamilly() == "Christian");
        assertTrue(patient1.getGiven() == "Dupont");

    }

}
