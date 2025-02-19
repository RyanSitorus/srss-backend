package com.srss.backend.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	@Column(name = "doctor_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long doctorId;

	@Column(name = "doctor_number", nullable = false)
	private String doctorNumber;

	@Column(name = "doctor_name", nullable = false)
	private String doctorName;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(name = "gender")
	private String gender;

	@Column(name = "specialty")
	private String specialty;

	@Column(name = "address")
	private String address;

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorNumber() {
		return doctorNumber;
	}

	public void setDoctorNumber(String doctorNumber) {
		this.doctorNumber = doctorNumber;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
