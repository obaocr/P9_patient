package com.ocr.p9_patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO controller + exceptions + tests Ctrl + exceptions DML ?
// TODO Jacoco
// TODO Docker
// TODO ... Custom exception not_found ne fonctionne pas ... à voir ... rend un 404 (au lieu de nOT_FOUND) avec tout le message détaillé...

@SpringBootApplication
public class P9PatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(P9PatientApplication.class, args);
	}

}
