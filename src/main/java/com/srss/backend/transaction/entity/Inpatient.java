package com.srss.backend.transaction.entity;

import java.time.LocalDate;

import com.srss.backend.entity.Doctor;
import com.srss.backend.entity.Patient;
import com.srss.backend.entity.Room;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name = "inpatient_patient_id", nullable = false)
	private Patient patient;

	@ManyToOne
	@JoinColumn(name = "inpatient_doctor_id", nullable = false)
	private Doctor doctor;

	@ManyToOne
	@JoinColumn(name = "inpatient_id_room", nullable = false)
	private Room room;

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

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
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
