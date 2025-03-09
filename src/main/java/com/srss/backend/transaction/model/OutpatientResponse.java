package com.srss.backend.transaction.model;

import java.util.List;

import com.srss.backend.base.model.Status;
import com.srss.backend.transaction.entity.Outpatient;

public class OutpatientResponse {

	private Status status;
	private List<Outpatient> outpatient;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Outpatient> getOutpatient() {
		return outpatient;
	}

	public void setOutpatient(List<Outpatient> patient) {
		this.outpatient = patient;
	}

	

}
