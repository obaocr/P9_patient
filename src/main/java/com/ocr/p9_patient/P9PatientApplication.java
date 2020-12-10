package com.ocr.p9_patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO Jacoco
// TODO Docker
// TODO les dates creation/màj sont  à nulle ? à gérer dans ce code en cas de post/put

@SpringBootApplication
public class P9PatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(P9PatientApplication.class, args);
	}

}
