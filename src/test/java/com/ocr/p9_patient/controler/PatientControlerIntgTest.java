package com.ocr.p9_patient.controler;

import com.ocr.p9_patient.model.Patient;
import com.ocr.p9_patient.service.PatientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientControlerIntgTest {

    @Autowired
    private PatientControler patientControler;

    @MockBean
    private PatientService patientService;

    @Test
    void addPatient() throws Exception {
        LocalDate birth = LocalDate.of(2000, 1, 15);
        Patient patient = new Patient("Martin", "Alain", "12 rue des oliviers", "M", birth, "+33 123456789");
        Mockito.when(patientService.addPatient(patient)).thenReturn(999);
        Integer Id = patientControler.addPatient(patient);
        assertTrue(Id ==  999);
    }

    @Test
    void updatePatient() throws Exception {
        LocalDate birth = LocalDate.of(2000, 1, 15);
        Patient patient = new Patient("Martin", "Alain", "12 rue des oliviers", "M", birth, "+33 123456789");
        Mockito.when(patientService.updatePatient(patient)).thenReturn(true);
        Boolean result = patientControler.updatePatient(999, patient);
        assertTrue(result ==  true);
    }

    @Test
    void deletePatient() throws Exception {
        LocalDate birth = LocalDate.of(2000, 1, 15);
        Patient patient = new Patient("Martin", "Alain", "12 rue des oliviers", "M", birth, "+33 123456789");
        Mockito.when(patientService.deletePatientById(999)).thenReturn(true);
        Boolean result = patientControler.deletePatient(999);
        assertTrue(result ==  true);
    }

}
