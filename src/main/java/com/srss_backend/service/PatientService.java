package com.srss_backend.service;

import java.util.List;

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
		patientRepository.save(patient);
	}

	public Patient getPatientById(Long id) {
		return patientRepository.findById(id).get();
	}

	public void updatePatient(Long patientId, Patient patient) {
		Patient existingPatient = patientRepository.findById(patientId).get();

		if (existingPatient != null) {
			patient.setIdPasien(patientId);
			patient.setNomorPasien(existingPatient.getNomorPasien());
			patientRepository.save(patient);
		}
	}

	public void deletePatientById(Long id) {
		patientRepository.deleteById(id);
	}

}
