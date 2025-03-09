package com.srss.backend.transaction.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inpatient")
public class Inpatient {

	@Id
	@Column(name = "inpatient_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inpatientId;

	@Column(name = "inpatient_number", nullable = false)
	private String inpatientNumber;

	@Column(name = "admission_date", nullable = false)
	private LocalDate admissionDate;

	@Column(name = "patient_name", nullable = false)
	private String patientName;

	@Column(name = "room_name", nullable = false)
	private String roomName;

	@Column(name = "doctor_name", nullable = false)
	private String doctorName;

	@Column(name = "diagnosis")
	private String diagnosis;

	@Column(name = "description")
	private String description;

	public Long getInpatientId() {
		return inpatientId;
	}

	public void setInpatientId(Long inpatientId) {
		this.inpatientId = inpatientId;
	}

	public String getInpatientNumber() {
		return inpatientNumber;
	}

	public void setInpatientNumber(String inpatientNumber) {
		this.inpatientNumber = inpatientNumber;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
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

	public String getNotes() {
		return description;
	}

	public void setNotes(String notes) {
		this.description = notes;
	}
}
