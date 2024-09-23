package com.srss_backend.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srss_backend.entity.Patient;
import com.srss_backend.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	public List<Patient> getAllPatient() {
		return patientRepository.findAll();
	}

	public void savePatient(Patient patient) {
		LocalDate today = LocalDate.now();
		String dateString = today.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
		Random rand = new Random();

		patient.setNomorPasien(dateString + String.valueOf(rand.nextInt(1000)));
		patientRepository.save(patient);
	}

	public Patient getPatientById(Long id) {
		Patient patient = new Patient();
		try {
			patient = patientRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Patient with id " + id + " not found");
		}
		return patient;
	}

	public void updatePatient(Patient patient) {
		patientRepository.save(patient);
	}

	public void deletePatientById(Long id) {
		patientRepository.deleteById(id);
	}

}
