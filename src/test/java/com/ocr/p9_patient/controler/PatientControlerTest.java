package com.ocr.p9_patient.controler;

import com.ocr.p9_patient.model.Patient;
import com.ocr.p9_patient.service.PatientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientControlerTest {

    @MockBean
    private PatientService patientService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void homeShouldReturnOK() throws Exception {
        this.mockMvc.perform(get("/")
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getAllPatientShouldReturnOK() throws Exception {
        LocalDate birth = LocalDate.of(2000, 1, 15);
        Patient patient = new Patient("Martin", "Jean", "12 rue des acacias", "M", birth, "+33 123456789");
        List<Patient> patients = new ArrayList<>();
        patients.add(patient);
        Mockito.when(patientService.getPatients()).thenReturn(patients);

        this.mockMvc.perform(get("/patient")
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getPatientByIdShouldReturnOK() throws Exception {
        LocalDate birth = LocalDate.of(2000, 1, 15);
        Patient patient = new Patient("Martin", "Alain", "24 rue des acacias", "M", birth, "+33 123456789");
        patient.setId(999);
        Mockito.when(patientService.getPatientById(999)).thenReturn(patient);

        this.mockMvc.perform(get("/patient/999")
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getPatientByNameShouldReturnOK() throws Exception {
        LocalDate birth = LocalDate.of(2000, 1, 15);
        Patient patient = new Patient("Martin", "Alain", "24 rue des acacias", "M", birth, "+33 123456789");
        patient.setId(999);
        Mockito.when(patientService.getPatientById(999)).thenReturn(patient);

        this.mockMvc.perform(get("/patient")
                .param("familly","Martin")
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

}
