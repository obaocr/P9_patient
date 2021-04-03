package com.ocr.p9_patient.utils;

import com.ocr.p9_patient.Utils.Check;
import com.ocr.p9_patient.Utils.EntityIllegalArgumentException;
import com.ocr.p9_patient.model.Patient;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckPatientTest {

    @Test
    void checkPatientFamillyShouldReturnException () {
        LocalDate birth = LocalDate.of(2000,1,15);
        Patient patient = new Patient();
        patient.setId(1);
        patient.setAddress("12 rue des grands oliviers");
        patient.setFamilly("*************************************************************************");
        patient.setGiven("Jean");
        patient.setPhone("0102030405");
        patient.setSex("M");
        patient.setBirthDate(birth);
        try {
            Check.checkPatient(patient);
        } catch (EntityIllegalArgumentException e) {
            assertTrue(e.toString().contains("Familly length must be <= 30"));
        }
    }

    @Test
    void checkPatientGivenShouldReturnException () {
        LocalDate birth = LocalDate.of(2000,1,15);
        Patient patient = new Patient();
        patient.setId(1);
        patient.setAddress("12 rue des grands oliviers");
        patient.setFamilly("Test");
        patient.setGiven("**********************************************************************");
        patient.setPhone("0102030405");
        patient.setSex("M");
        patient.setBirthDate(birth);
        try {
            Check.checkPatient(patient);
        } catch (EntityIllegalArgumentException e) {
            assertTrue(e.toString().contains("Given length must be <= 30"));
        }
    }

    @Test
    void checkPatientAddressShouldReturnException () {
        LocalDate birth = LocalDate.of(2000,1,15);
        Patient patient = new Patient();
        patient.setId(1);
        String addTest = "*";
        while (addTest.length() < 101) {
            addTest += "*";
        }
        patient.setAddress(addTest);
        patient.setFamilly("Test");
        patient.setGiven("Test");
        patient.setPhone("0102030405");
        patient.setSex("M");
        patient.setBirthDate(birth);
        try {
            Check.checkPatient(patient);
        } catch (EntityIllegalArgumentException e) {
            assertTrue(e.toString().contains("Address length must be <= 100"));
        }
    }

    @Test
    void checkPatientGenderShouldReturnException () {
        LocalDate birth = LocalDate.of(2000,1,15);
        Patient patient = new Patient();
        patient.setId(1);
        patient.setAddress("12 rue des grands oliviers");
        patient.setFamilly("Test");
        patient.setGiven("Test");
        patient.setPhone("0102030405");
        patient.setSex("Z");
        patient.setBirthDate(birth);
        try {
            Check.checkPatient(patient);
        } catch (EntityIllegalArgumentException e) {
            assertTrue(e.toString().contains("Gender must be M or F"));
        }
    }

    @Test
    void checkPatientPhoneShouldReturnException () {
        LocalDate birth = LocalDate.of(2000,1,15);
        Patient patient = new Patient();
        patient.setId(1);
        patient.setAddress("12 rue des grands oliviers");
        patient.setFamilly("Test");
        patient.setGiven("Test");
        patient.setPhone("0102030405010203040501020304050102030405");
        patient.setSex("MM");
        patient.setBirthDate(birth);
        try {
            Check.checkPatient(patient);
        } catch (EntityIllegalArgumentException e) {
            assertTrue(e.toString().contains("Phone length must be <= 30"));
        }
    }

    @Test
    void checkPatientAllShouldReturnException () {
        LocalDate birth = LocalDate.of(2000,1,15);
        Patient patient = new Patient();
        patient.setId(1);
        patient.setAddress("");
        patient.setFamilly("Test");
        patient.setGiven("Test");
        patient.setPhone("0102030405010203040501020304050102030405");
        patient.setSex("MM");
        patient.setBirthDate(birth);
        try {
            Check.checkPatient(patient);
        } catch (EntityIllegalArgumentException e) {
            assertTrue(e.toString().contains("All fields are mandatory for a Patient"));
        }
    }

}
