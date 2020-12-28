package com.ocr.p9_patient.Utils;

import com.ocr.p9_patient.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Check for Patient model
 */
public class Check {

    private static Logger logger = LoggerFactory.getLogger(Check.class);

    public static void checkPatient(Patient patient) {
        if (patient == null || patient.getFamilly().isEmpty() || patient.getGiven().isEmpty() || patient.getAddress().isEmpty()
                || patient.getBirthDate() == null || patient.getSex().isEmpty() || patient.getPhone().isEmpty()) {
            logger.error("All fields are mandatory for a Patient");
            throw new EntityIllegalArgumentException("All fields are mandatory for a Patient");
        }
        if (patient.getFamilly().length() > 30) {
            logger.error("Familly length must be < 30");
            throw new EntityIllegalArgumentException("Familly length must be <= 30");
        }
        if (patient.getGiven().length() > 30) {
            logger.error("Given length must be < 30");
            throw new EntityIllegalArgumentException("Given length must be <= 30");
        }
        if (patient.getAddress().length() > 100) {
            logger.error("Address length must be < 100");
            throw new EntityIllegalArgumentException("Address length must be <= 100");
        }
        if (patient.getPhone().length() > 30) {
            logger.error("Phone length must be <= 30");
            throw new EntityIllegalArgumentException("Phone length must be <= 30");
        }
        if (patient.getSex().length() > 1) {
            logger.error("Gender length must be <= 1");
            throw new EntityIllegalArgumentException("Gender length must be <= 1");
        }
    }

}
