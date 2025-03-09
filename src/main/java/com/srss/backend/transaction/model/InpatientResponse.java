package com.srss.backend.transaction.model;

import java.util.List;

import com.srss.backend.base.model.Status;
import com.srss.backend.transaction.entity.Inpatient;

public class InpatientResponse {

	private Status status;
	private List<Inpatient> inpatient;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Inpatient> getInpatient() {
		return inpatient;
	}

	public void setInpatient(List<Inpatient> patient) {
		this.inpatient = patient;
	}

	

}
