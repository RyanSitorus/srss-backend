package com.srss_backend.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.srss_backend.base.model.Status;
import com.srss_backend.entity.Patient;
import com.srss_backend.service.PatientService;

@Controller
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping("/")
	public List<Patient> test() {
		return patientService.getAllPatient();
	}

	@GetMapping("/allPatient")
	public HttpEntity getAllPatient() {
		Status status = new Status();
		HttpStatus httpStatus = null;
		Map<String, Object> response = new HashMap<>();

		try {
			response.put("patient", patientService.getAllPatient());

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

		response.put("status", status);

		return new ResponseEntity<>(response, httpStatus);
	}

	@GetMapping("/patientById")
	public HttpEntity getPatientById(@RequestParam Long patientId) {
		Status status = new Status();
		HttpStatus httpStatus = null;
		Map<String, Object> response = new HashMap<>();

		try {
			response.put("patient", patientService.getPatientById(patientId));

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

		response.put("status", status);

		return new ResponseEntity<>(response, httpStatus);
	}

	@RequestMapping(value = "/addPatient", method = RequestMethod.POST)
	public HttpEntity addPatient(@RequestBody Patient patient) {
		Status status = new Status();
		HttpStatus httpStatus = null;
		Map<String, Object> response = new HashMap<>();

		try {
			LocalDate today = LocalDate.now();
			String dateString = today.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
			Random rand = new Random();

			patient.setNomorPasien(dateString + String.valueOf(rand.nextInt(1000)));
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

		response.put("status", status);

		return new ResponseEntity<>(response, httpStatus);

	}

	@RequestMapping(value = "/updatePatient", method = RequestMethod.PUT)
	public HttpEntity updatePatient(@RequestParam Long patientId, @RequestBody Patient patient) {
		Status status = new Status();
		HttpStatus httpStatus = null;
		Map<String, Object> response = new HashMap<>();

		try {

			patientService.updatePatient(patientId, patient);

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
		response.put("status", status);

		return new ResponseEntity<>(response, httpStatus);
	}

	@RequestMapping(value = "/deletePatientById", method = RequestMethod.DELETE)
	public HttpEntity deletePatientById(@RequestParam Long patientId) {
		Status status = new Status();
		HttpStatus httpStatus = null;
		Map<String, Object> response = new HashMap<>();

		try {

			patientService.deletePatientById(patientId);

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
		response.put("status", status);

		return new ResponseEntity<>(response, httpStatus);
	}

}
