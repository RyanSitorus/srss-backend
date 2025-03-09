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

import com.srss.backend.transaction.entity.Inpatient;
import com.srss.backend.transaction.repository.InpatientRepository;

@Service
public class InpatientService {

	private final static Logger log = LoggerFactory.getLogger(InpatientService.class);
	
	@Autowired
	private InpatientRepository inpatientRepository;

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
		inpatientRepository.save(inpatient);
	}

	public void updateInpatient(Long inpatientId, Inpatient inpatient) throws ServiceException {
		Inpatient existingInpatients = new Inpatient();
		try {
			existingInpatients = inpatientRepository.findById(inpatientId).get();

			inpatient.setInpatientId(existingInpatients.getInpatientId());
			inpatient.setInpatientNumber(existingInpatients.getInpatientNumber());
			inpatientRepository.save(inpatient);

		} catch (NoSuchElementException e) {
			throw new ServiceException("Inpatient with id " + inpatientId + " not found");
		}
	}

	public void deleteInpatientById(Long id) throws ServiceException{
		inpatientRepository.deleteById(id);
	}

}
