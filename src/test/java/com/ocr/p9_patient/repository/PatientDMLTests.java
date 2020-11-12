package com.ocr.p9_patient.repository;

import com.ocr.p9_patient.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.font.TrueTypeFont;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests DAO with H2 database in memory
 */
@SpringBootTest
public class PatientDMLTests {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    void patientCreationTest () {
        Date birth = new Date();
        Patient patient = new Patient();
        patient.setLastName("Martin");
        patient.setFirstName("Alain");
        patient.setAddress("12 rue des oliviers");
        patient.setFamilly("TestFamille");
        patient.setGiven("Test");
        patient.setSex("M");
        patient.setBirthDate(birth);
        patientRepository.save(patient);
        assertNotNull(patient.getId());
    }

    @Test
    void patientCreationConstructorTest () {
        Date birth = new Date();
        Patient patient = new Patient("Martin","Alain","TestFamille","Test","12 rue des oliviers","M",birth);
        patientRepository.save(patient);
        assertNotNull(patient.getId());
    }

    @Test
    void patientFindAllTest () {
        Date birth = new Date();
        Patient patient = new Patient("Martin","Alain","TestFamille","Test","12 rue des oliviers","M",birth);
        patientRepository.save(patient);
        List<Patient> patients = patientRepository.findAll();
        assertTrue(patients.size() > 0);
    }

    @Test
    void patientUpdateTest () {
        Date birth = new Date();
        Patient patient = new Patient("Martin","Alain","TestFamille","Test","12 rue des oliviers","M",birth);
        patientRepository.save(patient);
        Patient patient2 = patientRepository.findAll().get(0);
        patient2.setFirstName("Marc");
        patientRepository.save(patient2);
        Patient patientUpdated = patientRepository.findById(patient2.getId()).get();
        assertTrue(patientUpdated.getFirstName() == "Marc");
    }

}
