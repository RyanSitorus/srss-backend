package com.srss.backend.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srss.backend.entity.Patient;
import com.srss.backend.repository.PatientRepository;

@Service
public class PatientService {
	
	private final static Logger log = LoggerFactory.getLogger(PatientService.class);

	@Autowired
	private PatientRepository patientRepository;

	public List<Patient> getAllPatient() throws ServiceException{
		return patientRepository.findAll();
	}
	
	public List<Patient> getPatientById(Long id) throws ServiceException{
		Patient patient = new Patient();
		List<Patient> listPatient = new ArrayList<>();
		try {
			
			patient = patientRepository.findById(id).get();
			listPatient.add(patient);
			
			return listPatient;
			
		} catch (NoSuchElementException e) {
			
			throw new ServiceException("Patient with id " + id + " not found");
			
		}
	}

	public void savePatient(Patient patient) throws ServiceException{
		LocalDate today = LocalDate.now();
		String dateString = today.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
		Random rand = new Random();

		patient.setNomorPasien(dateString + String.valueOf(rand.nextInt(1000)));
		patientRepository.save(patient);
	}

	public void updatePatient(Long patientId, Patient patient) throws ServiceException{
		Patient existingPatients = new Patient();
		try {
			existingPatients = patientRepository.findById(patientId).get();
			
			patient.setIdPasien(existingPatients.getIdPasien());
			patient.setNomorPasien(existingPatients.getNomorPasien());
			patientRepository.save(patient);

		} catch (NoSuchElementException e) {
			throw new ServiceException("Patient with id " + patientId + " not found");
		}

	}

	public void deletePatientById(Long id) throws ServiceException{
		patientRepository.deleteById(id);
	}

}
