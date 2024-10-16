package com.srss_backend.base.model;

import java.util.List;

import com.srss_backend.entity.Patient;

public class PatientResponse {

	private Status status;
	private List<Patient> patient;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}

	

}
