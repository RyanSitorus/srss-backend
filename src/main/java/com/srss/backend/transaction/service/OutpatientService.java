package com.srss.backend.transaction.service;

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

import com.srss.backend.entity.Doctor;
import com.srss.backend.entity.Patient;
import com.srss.backend.entity.Room;
import com.srss.backend.repository.DoctorRepository;
import com.srss.backend.repository.PatientRepository;
import com.srss.backend.repository.RoomRepository;
import com.srss.backend.transaction.entity.Outpatient;
import com.srss.backend.transaction.repository.OutpatientRepository;

@Service
public class OutpatientService {

	private final static Logger log = LoggerFactory.getLogger(OutpatientService.class);
	
	@Autowired
	private OutpatientRepository outpatientRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private RoomRepository roomRepository;
	

	public List<Outpatient> getAllOutpatient() throws ServiceException{
		return outpatientRepository.findAll();
	}

	public List<Outpatient> getOutpatientById(Long id) throws ServiceException{
		Outpatient outpatient = new Outpatient();
		List<Outpatient> listOutpatient = new ArrayList<>();
		try {
			outpatient = outpatientRepository.findById(id).get();
			listOutpatient.add(outpatient);
		} catch (NoSuchElementException e) {
			
			throw new ServiceException("Outpatient with id " + id + " not found");
			
		}
		return listOutpatient;
	}

	
	public void saveOutpatient(Outpatient outpatient) throws ServiceException{
		LocalDate today = LocalDate.now();
		String dateString = today.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
		Random rand = new Random();

		outpatient.setOutpatientNumber(dateString + String.valueOf(rand.nextInt(1000)));
		
		Patient existingPatient = patientRepository.findById(outpatient.getPatient().getPatientId())
	            .orElseThrow(() -> new RuntimeException("Patient not found"));
	    Doctor existingDoctor = doctorRepository.findById(outpatient.getDoctor().getDoctorId())
	            .orElseThrow(() -> new RuntimeException("Doctor not found"));
	    
	    
	    outpatient.setPatient(existingPatient);
	    outpatient.setDoctor(existingDoctor);
	    
	    
		outpatientRepository.save(outpatient);
	}

	public void updateOutpatient(Long outpatientId, Outpatient outpatient) throws ServiceException {
		Outpatient existingOutpatients = new Outpatient();
		try {
			existingOutpatients = outpatientRepository.findById(outpatientId).get();

			outpatient.setOutpatientId(existingOutpatients.getOutpatientId());
			outpatient.setOutpatientNumber(existingOutpatients.getOutpatientNumber());
			
			Patient existingPatient = patientRepository.findById(outpatient.getPatient().getPatientId())
		            .orElseThrow(() -> new RuntimeException("Patient not found"));
		    Doctor existingDoctor = doctorRepository.findById(outpatient.getDoctor().getDoctorId())
		            .orElseThrow(() -> new RuntimeException("Doctor not found"));
		    
		    
		    outpatient.setPatient(existingPatient);
		    outpatient.setDoctor(existingDoctor);
		    
			outpatientRepository.save(outpatient);

		} catch (NoSuchElementException e) {
			throw new ServiceException("Outpatient with id " + outpatientId + " not found");
		}catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void deleteOutpatientById(Long id) throws ServiceException{
		outpatientRepository.deleteById(id);
	}

}
