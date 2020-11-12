package com.ocr.p9_patient.controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ocr.p9_patient.model.Patient;
import com.ocr.p9_patient.service.PatientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    void getAllPatientShouldReturnOK() throws Exception {
        Date birth = new Date();
        Patient patient = new Patient("Martin", "Alain", "TestFamille", "Test", "12 rue des oliviers", "M", birth);
        List<Patient> patients = new ArrayList<>();
        patients.add(patient);
        Mockito.when(patientService.getPatients()).thenReturn(patients);

        this.mockMvc.perform(get("/Patients")
                //.contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getPatientByIdShouldReturnOK() throws Exception {
        Date birth = new Date();
        Patient patient = new Patient("Martin", "Alain", "TestFamille", "Test", "12 rue des oliviers", "M", birth);
        patient.setId(999);
        Mockito.when(patientService.getPatientById(999)).thenReturn(patient);

        this.mockMvc.perform(get("/Patient")
                .param("Id","999")
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void addPatientShouldReturnOK() throws Exception {
        Date birth = new Date();
        Patient patient = new Patient("Martin", "Alain", "TestFamille", "Test", "12 rue des oliviers", "M", birth);
        Mockito.when(patientService.addPatient(patient)).thenReturn(999);

        ObjectMapper objectMapper = new ObjectMapper();
        String patientJSON = objectMapper.writeValueAsString(patient);

        this.mockMvc.perform(post("/Patient")
                .contentType(MediaType.APPLICATION_JSON)
                .content(patientJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void updatePatientShouldReturnOK() throws Exception {
        Date birth = new Date();
        Patient patient = new Patient("Martin", "Alain", "TestFamille", "Test", "12 rue des oliviers", "M", birth);
        patient.setId(999);
        Mockito.when(patientService.updatePatient(patient)).thenReturn(true);

        ObjectMapper objectMapper = new ObjectMapper();
        String patientJSON = objectMapper.writeValueAsString(patient);
        String url = "/Patient/999";
        this.mockMvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(patientJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

}
