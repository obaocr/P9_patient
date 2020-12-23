package com.ocr.p9_patient.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Date;

/**
 * Model tests
 */
public class PatientTest {

    @Test
    void patientConstructorTest () {
        LocalDate birth = LocalDate.of(2000,1,15);
        Patient patient = new Patient();
        patient.setId(1);
        patient.setAddress("12 rue des oliviers");
        patient.setFamilly("TestFamille");
        patient.setGiven("Test");
        patient.setSex("M");
        patient.setBirthDate(birth);
        assertTrue(patient != null);
        assertTrue(patient.getSex() == "M");
        assertTrue(patient.getAddress() == "12 rue des oliviers");
        assertTrue(patient.getFamilly() == "TestFamille");
        assertTrue(patient.getGiven() == "Test");
        assertTrue(patient.getId() != null);
        assertTrue(patient.getBirthDate() != null);

    }
}
