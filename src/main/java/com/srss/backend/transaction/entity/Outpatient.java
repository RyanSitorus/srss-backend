package com.srss.backend.transaction.entity;

import java.time.LocalDate;

import com.srss.backend.entity.Doctor;
import com.srss.backend.entity.Patient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "outpatient")
public class Outpatient {

	@Id
	@Column(name = "outpatient_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long outpatientId;

	@Column(name = "outpatient_number", nullable = false)
	private String outpatientNumber;

	@Column(name = "appointment_date", nullable = false)
	private LocalDate appointmentDate;

	@ManyToOne
	@JoinColumn(name = "outpatient_patient_id", nullable = false)
	private Patient patient;

	@ManyToOne
	@JoinColumn(name = "outpatient_doctor_id", nullable = false)
	private Doctor doctor;

	@Column(name = "diagnosis")
	private String diagnosis;

	@Column(name = "description")
	private String description;

	public Long getOutpatientId() {
		return outpatientId;
	}

	public void setOutpatientId(Long outpatientId) {
		this.outpatientId = outpatientId;
	}

	public String getOutpatientNumber() {
		return outpatientNumber;
	}

	public void setOutpatientNumber(String outpatientNumber) {
		this.outpatientNumber = outpatientNumber;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
