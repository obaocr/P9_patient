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

import java.time.LocalDate;
import java.util.ArrayList;
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
        LocalDate birth = LocalDate.of(2000, 1, 15);
        Patient patient = new Patient("Martin", "Alain", "12 rue des oliviers", "M", birth, "+33 123456789");
        List<Patient> patients = new ArrayList<>();
        patients.add(patient);
        Mockito.when(patientRepository.findAll()).thenReturn(patients);
        List<Patient> listPatients = patientService.getPatients();
        assertTrue(listPatients.size() > 0);
    }

    @Test
    void patientGetById() {
        LocalDate birth = LocalDate.of(2000, 1, 15);
        Patient patient = new Patient("Martin", "Alain", "12 rue des oliviers", "M", birth, "+33 123456789");
        patient.setId(999);
        Mockito.when(patientRepository.findById(999)).thenReturn(Optional.of(patient));
        Patient itemPatient = patientService.getPatientById(999);
        assertTrue(itemPatient != null);
    }

    @Test
    void patientGetByName() {
        List<Patient> patients = new ArrayList<>();
        LocalDate birth = LocalDate.of(2000, 1, 15);
        Patient patient = new Patient("Martin", "Alain", "12 rue des oliviers", "M", birth, "+33 123456789");
        patient.setId(999);
        patients.add(patient);
        Mockito.when(patientRepository.findPatientsByFamilly("Martin")).thenReturn(patients);
        List<Patient> items = patientService.getPatientsByName("Martin");
        assertTrue(items.size() > 0);
    }

    @Test
    void addPatient() {
        LocalDate birth = LocalDate.of(2000, 1, 15);
        Patient patient = new Patient("Martin", "Alain", "12 rue des oliviers", "M", birth, "+33 123456789");
        patient.setId(999);
        Mockito.when(patientRepository.save(patient)).thenReturn(patient);
        Integer Id = patientService.addPatient(patient);
        assertTrue(Id == 999);
    }

    @Test
    void updatePatient() {
        LocalDate birth = LocalDate.of(2000, 1, 15);
        Patient patient = new Patient("Martin", "Alain", "12 rue des oliviers", "M", birth, "+33 123456789");
        patient.setId(999);
        Mockito.when(patientRepository.findById(999)).thenReturn(Optional.of(patient));
        Mockito.when(patientRepository.save(patient)).thenReturn(patient);
        Boolean result = patientService.updatePatient(patient);
        assertTrue(result == true);
    }

    @Test
    void deletePatient() {
        LocalDate birth = LocalDate.of(2000, 1, 15);
        Patient patient = new Patient("Martin", "Alain", "12 rue des oliviers", "M", birth, "+33 123456789");
        patient.setId(999);
        Mockito.when(patientRepository.findById(999)).thenReturn(Optional.of(patient));
        Boolean result = patientService.deletePatientById(999);
        assertTrue(result == true);
    }

}
