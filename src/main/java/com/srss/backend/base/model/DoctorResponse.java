package com.srss.backend.base.model;

import java.util.List;

import com.srss.backend.entity.Doctor;

public class DoctorResponse {

	private Status status;
	private List<Doctor> doctor;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Doctor> getDoctor() {
		return doctor;
	}

	public void setDoctor(List<Doctor> patient) {
		this.doctor = patient;
	}

	

}
