package com.ocr.p9_patient.repository;

import com.ocr.p9_patient.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests DAO with H2 database in memory
 */
@SpringBootTest
public class PatientDaoTests {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    void patientCreationTest() {
        LocalDate birth = LocalDate.of(2000,1,15);
        Patient patient = new Patient();
        patient.setAddress("12 rue des oliviers");
        patient.setFamilly("TestFamille");
        patient.setGiven("Test");
        patient.setSex("M");
        patient.setBirthDate(birth);
        patientRepository.save(patient);
        assertNotNull(patient.getId());
    }

    @Test
    void patientCreationConstructorTest() {
        LocalDate birth = LocalDate.of(2000,1,15);
        Patient patient = new Patient("Martin", "Alain", "12 rue des oliviers", "M", birth, "+33 123456789");
        patientRepository.save(patient);
        assertNotNull(patient.getId());
    }

    @Test
    void patientFindAllTest() {
        LocalDate birth = LocalDate.of(2000,1,15);
        Patient patient = new Patient("Martin", "Alain", "12 rue des oliviers", "M", birth, "+33 123456789");
        patientRepository.save(patient);
        List<Patient> patients = patientRepository.findAll();
        assertTrue(patients.size() > 0);
    }

    @Test
    void patientUpdateTest() {
        LocalDate birth = LocalDate.of(2000,1,15);
        Patient patient = new Patient("Martin", "Alain", "12 rue des oliviers", "M", birth, "+33 123456789");
        patientRepository.save(patient);
        Patient patient2 = patientRepository.findAll().get(0);
        patient2.setGiven("Marc");
        patientRepository.save(patient2);
        Patient patientUpdated = patientRepository.findById(patient2.getId()).get();
        assertTrue(patientUpdated.getGiven() == "Marc");
    }

}
