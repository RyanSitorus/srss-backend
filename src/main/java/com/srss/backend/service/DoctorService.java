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

import com.srss.backend.entity.Doctor;
import com.srss.backend.repository.DoctorRepository;

@Service
public class DoctorService {

	private final static Logger log = LoggerFactory.getLogger(DoctorService.class);
	
	@Autowired
	private DoctorRepository doctorRepository;

	public List<Doctor> getAllDoctor() throws ServiceException{
		return doctorRepository.findAll();
	}

	public List<Doctor> getDoctorById(Long id) throws ServiceException{
		Doctor doctor = new Doctor();
		List<Doctor> listDoctor = new ArrayList<>();
		try {
			doctor = doctorRepository.findById(id).get();
			listDoctor.add(doctor);
		} catch (NoSuchElementException e) {
			
			throw new ServiceException("Doctor with id " + id + " not found");
			
		}
		return listDoctor;
	}

	
	public void saveDoctor(Doctor doctor) throws ServiceException{
		LocalDate today = LocalDate.now();
		String dateString = today.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
		Random rand = new Random();

		doctor.setDoctorNumber(dateString + String.valueOf(rand.nextInt(1000)));
		doctorRepository.save(doctor);
	}

	public void updateDoctor(Long doctorId, Doctor doctor) throws ServiceException {
		Doctor existingDoctors = new Doctor();
		try {
			existingDoctors = doctorRepository.findById(doctorId).get();

			doctor.setDoctorId(existingDoctors.getDoctorId());
			doctor.setDoctorNumber(existingDoctors.getDoctorNumber());
			doctorRepository.save(doctor);

		} catch (NoSuchElementException e) {
			throw new ServiceException("Doctor with id " + doctorId + " not found");
		}
	}

	public void deleteDoctorById(Long id) throws ServiceException{
		doctorRepository.deleteById(id);
	}

}
