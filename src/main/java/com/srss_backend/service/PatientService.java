package com.srss_backend.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

	public List<Patient> getPatientById(Long id) {
		Patient patient = new Patient();
		List<Patient> listPatient = new ArrayList<>();
		try {
			patient = patientRepository.findById(id).get();
			listPatient.add(patient);
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Patient with id " + id + " not found");
		}
		return listPatient;
	}

	public void updatePatient(Long patientId, Patient patient) {
		Patient existingPatients = new Patient();
		try {
			existingPatients = patientRepository.findById(patientId).get();
			if (existingPatients != null) {
				patient.setIdPasien(existingPatients.getIdPasien());
				patient.setNomorPasien(existingPatients.getNomorPasien());
				patientRepository.save(patient);

			}
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Patient with id " + patientId + " not found");
		}

	}

	public void deletePatientById(Long id) {
		patientRepository.deleteById(id);
	}

}
