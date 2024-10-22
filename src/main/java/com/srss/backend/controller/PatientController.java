package com.srss.backend.controller;

import java.util.NoSuchElementException;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.srss.backend.base.model.PatientResponse;
import com.srss.backend.base.model.Status;
import com.srss.backend.entity.Patient;
import com.srss.backend.service.PatientService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/patient")
@Tag(name = "Patient", description = "APIs for patient data")
public class PatientController {

	private final static Logger log = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private PatientService patientService;

	@GetMapping("/getAll")
	public HttpEntity getAllPatient() {
		Status status = new Status();
		HttpStatus httpStatus = null;
		PatientResponse allPatient = new PatientResponse();

		try {
			allPatient.setPatient(patientService.getAllPatient());

			httpStatus = HttpStatus.OK;
			status.setResponseMessage("Success");
			status.setResponseCode(HttpStatus.OK.value());

		} catch (ServiceException se) {

			status.setResponseCode(HttpStatus.BAD_REQUEST.value());
			status.setResponseMessage(se.getMessage());
			httpStatus = HttpStatus.BAD_REQUEST;

		} catch (Exception e) {

			status.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			status.setResponseMessage("We are having server's problem. Sorry for this inconvenience");
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();

		}

		allPatient.setStatus(status);

		return new ResponseEntity<>(allPatient, httpStatus);
	}

	@GetMapping("/getById")
	public HttpEntity getPatientById(@RequestParam Long patientId) {
		Status status = new Status();
		HttpStatus httpStatus = null;
		PatientResponse patient = new PatientResponse();

		try {
//			response.put("patient", patientService.getPatientById(patientId));
			patient.setPatient(patientService.getPatientById(patientId));

			httpStatus = HttpStatus.OK;
			status.setResponseMessage("Success");
			status.setResponseCode(HttpStatus.OK.value());

		} catch (ServiceException se) {

			status.setResponseCode(HttpStatus.BAD_REQUEST.value());
			status.setResponseMessage(se.getMessage());
			httpStatus = HttpStatus.BAD_REQUEST;

		} catch (NoSuchElementException nse) {

			status.setResponseCode(HttpStatus.BAD_REQUEST.value());
			status.setResponseMessage(nse.getMessage());
			httpStatus = HttpStatus.BAD_REQUEST;

		} catch (Exception e) {

			status.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			status.setResponseMessage("We are having server's problem. Sorry for this inconvenience");
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();

		}

		patient.setStatus(status);

		return new ResponseEntity<>(patient, httpStatus);
	}

	@PostMapping(value = "/add")
	public HttpEntity addPatient(@RequestBody Patient patient) {
		Status status = new Status();
		HttpStatus httpStatus = null;

		try {
			patientService.savePatient(patient);

			httpStatus = HttpStatus.OK;
			status.setResponseMessage("Success");
			status.setResponseCode(HttpStatus.OK.value());

		} catch (ServiceException se) {

			status.setResponseCode(HttpStatus.BAD_REQUEST.value());
			status.setResponseMessage(se.getMessage());
			httpStatus = HttpStatus.BAD_REQUEST;

		} catch (Exception e) {

			status.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			status.setResponseMessage("We are having server's problem. Sorry for this inconvenience");
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();

		}

		return new ResponseEntity<>(status, httpStatus);

	}

	@PutMapping(value = "/update/{patientId}")
	public HttpEntity updatePatient(@PathVariable Long patientId, @RequestBody Patient patient) {
		Status status = new Status();
		HttpStatus httpStatus = null;

		try {

			patientService.updatePatient(patientId, patient);

			httpStatus = HttpStatus.OK;
			status.setResponseMessage("Success");
			status.setResponseCode(HttpStatus.OK.value());

		} catch (ServiceException se) {

			status.setResponseCode(HttpStatus.BAD_REQUEST.value());
			status.setResponseMessage(se.getMessage());
			httpStatus = HttpStatus.BAD_REQUEST;

		} catch (NoSuchElementException nse) {

			status.setResponseCode(HttpStatus.BAD_REQUEST.value());
			status.setResponseMessage(nse.getMessage());
			httpStatus = HttpStatus.BAD_REQUEST;

		} catch (Exception e) {

			status.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			status.setResponseMessage("We are having server's problem. Sorry for this inconvenience");
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();

		}

		return new ResponseEntity<>(status, httpStatus);
	}

	@DeleteMapping(value = "/deleteById/{patientId}")
	public HttpEntity deletePatientById(@PathVariable Long patientId) {
		Status status = new Status();
		HttpStatus httpStatus = null;

		try {

			patientService.deletePatientById(patientId);

			httpStatus = HttpStatus.OK;
			status.setResponseMessage("Success");
			status.setResponseCode(HttpStatus.OK.value());

		} catch (ServiceException se) {

			status.setResponseCode(HttpStatus.BAD_REQUEST.value());
			status.setResponseMessage(se.getMessage());
			httpStatus = HttpStatus.BAD_REQUEST;

		} catch (NoSuchElementException nse) {

			status.setResponseCode(HttpStatus.BAD_REQUEST.value());
			status.setResponseMessage(nse.getMessage());
			httpStatus = HttpStatus.BAD_REQUEST;

		} catch (Exception e) {

			status.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			status.setResponseMessage("We are having server's problem. Sorry for this inconvenience");
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();

		}

		return new ResponseEntity<>(status, httpStatus);
	}

}