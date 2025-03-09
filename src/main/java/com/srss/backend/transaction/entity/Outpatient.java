package com.srss.backend.transaction.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	@Column(name = "patient_name", nullable = false)
	private String patientName;

	@Column(name = "doctor_name", nullable = false)
	private String doctorName;

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

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
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
