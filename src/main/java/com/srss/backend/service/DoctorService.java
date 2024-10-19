package com.srss.backend.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srss.backend.entity.Doctor;
import com.srss.backend.entity.Patient;
import com.srss.backend.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	public List<Doctor> getAllDoctor() {
		return doctorRepository.findAll();
	}

	public void saveDoctor(Doctor doctor) {
		LocalDate today = LocalDate.now();
		String dateString = today.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
		Random rand = new Random();

		doctor.setNomorDokter(dateString + String.valueOf(rand.nextInt(1000)));
		doctorRepository.save(doctor);
	}

	public List<Doctor> getDoctorById(Long id) {
		Doctor doctor = new Doctor();
		List<Doctor> listDoctor = new ArrayList<>();
		try {
			doctor = doctorRepository.findById(id).get();
			listDoctor.add(doctor);
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Doctor with id " + id + " not found");
		}
		return listDoctor;
	}

	public void updateDoctor(Long doctorId, Doctor doctor) {
		Doctor existingDoctors = new Doctor();
		try {
			existingDoctors = doctorRepository.findById(doctorId).get();
			if (existingDoctors != null) {
				doctor.setIdDokter(existingDoctors.getIdDokter());
				doctor.setNomorDokter(existingDoctors.getNomorDokter());
				doctorRepository.save(doctor);

			}
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Doctor with id " + doctorId + " not found");
		}
	}

	public void deleteDoctorById(Long id) {
		doctorRepository.deleteById(id);
	}

}
