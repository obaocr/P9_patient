package com.ocr.p9_patient.service;

import com.ocr.p9_patient.model.Patient;
import com.ocr.p9_patient.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @MockBean
    private PatientRepository patientRepository;

    @TestConfiguration
    static class PatientServiceTestsContextConfiguration {

        @Bean
        public PatientService patientService() {
            return new PatientServiceImpl();
        }
    }

    @Test
    void patientGetAll() {
        Date birth = new Date();
        Patient patient = new Patient("Martin", "Alain", "TestFamille", "Test", "12 rue des oliviers", "M", birth);
        List<Patient> patients = new ArrayList<>();
        patients.add(patient);
        Mockito.when(patientRepository.findAll()).thenReturn(patients);
        List<Patient> listPatients = patientService.getPatients();
        assertTrue(listPatients.size() > 0);
    }

    @Test
    void patientGetById() {
        Date birth = new Date();
        Patient patient = new Patient("Martin", "Alain", "TestFamille", "Test", "12 rue des oliviers", "M", birth);
        patient.setId(999);
        Mockito.when(patientRepository.findById(999)).thenReturn(Optional.of(patient));
        Patient itemPatient = patientService.getPatientById(999);
        assertTrue(itemPatient != null);
    }


}
