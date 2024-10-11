package com.srss_backend.base.model;

import com.srss_backend.entity.Patient;

public class PatientResponse {

	private Status status;
	private Patient patient;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
