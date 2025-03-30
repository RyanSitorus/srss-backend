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
import com.srss.backend.transaction.entity.Inpatient;
import com.srss.backend.transaction.repository.InpatientRepository;

@Service
public class InpatientService {

	private final static Logger log = LoggerFactory.getLogger(InpatientService.class);
	
	@Autowired
	private InpatientRepository inpatientRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private RoomRepository roomRepository;

	public List<Inpatient> getAllInpatient() throws ServiceException{
		return inpatientRepository.findAll();
	}

	public List<Inpatient> getInpatientById(Long id) throws ServiceException{
		Inpatient inpatient = new Inpatient();
		List<Inpatient> listInpatient = new ArrayList<>();
		try {
			inpatient = inpatientRepository.findById(id).get();
			listInpatient.add(inpatient);
		} catch (NoSuchElementException e) {
			
			throw new ServiceException("Inpatient with id " + id + " not found");
			
		}
		return listInpatient;
	}

	
	public void saveInpatient(Inpatient inpatient) throws ServiceException{
		LocalDate today = LocalDate.now();
		String dateString = today.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
		Random rand = new Random();
		
		inpatient.setInpatientNumber(dateString + String.valueOf(rand.nextInt(1000)));
		
		Patient existingPatient = patientRepository.findById(inpatient.getPatient().getPatientId())
	            .orElseThrow(() -> new RuntimeException("Patient not found"));
	    Room existingRoom = roomRepository.findById(inpatient.getRoom().getIdRoom())
	            .orElseThrow(() -> new RuntimeException("Room not found"));
	    Doctor existingDoctor = doctorRepository.findById(inpatient.getDoctor().getDoctorId())
	            .orElseThrow(() -> new RuntimeException("Doctor not found"));
	    
	    
	    inpatient.setPatient(existingPatient);
	    inpatient.setRoom(existingRoom);
	    inpatient.setDoctor(existingDoctor);
	    
		inpatientRepository.save(inpatient);
	}

	public void updateInpatient(Long inpatientId, Inpatient inpatient) throws ServiceException {
		Inpatient existingInpatients = new Inpatient();
		try {
			existingInpatients = inpatientRepository.findById(inpatientId).get();

			inpatient.setInpatientId(existingInpatients.getInpatientId());
			inpatient.setInpatientNumber(existingInpatients.getInpatientNumber());
			
			Patient existingPatient = patientRepository.findById(inpatient.getPatient().getPatientId())
		            .orElseThrow(() -> new RuntimeException("Patient not found"));
		    Room existingRoom = roomRepository.findById(inpatient.getRoom().getIdRoom())
		            .orElseThrow(() -> new RuntimeException("Room not found"));
		    Doctor existingDoctor = doctorRepository.findById(inpatient.getDoctor().getDoctorId())
		            .orElseThrow(() -> new RuntimeException("Doctor not found"));
		    
		    inpatient.setPatient(existingPatient);
		    inpatient.setRoom(existingRoom);
		    inpatient.setDoctor(existingDoctor);
		    
			inpatientRepository.save(inpatient);

		} catch (NoSuchElementException e) {
			throw new ServiceException("Inpatient with id " + inpatientId + " not found");
		}catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void deleteInpatientById(Long id) throws ServiceException{
		inpatientRepository.deleteById(id);
	}

}
