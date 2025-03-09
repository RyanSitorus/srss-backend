package com.srss.backend.controller;

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

import com.srss.backend.base.model.Status;
import com.srss.backend.transaction.entity.Outpatient;
import com.srss.backend.transaction.model.OutpatientResponse;
import com.srss.backend.transaction.service.OutpatientService;

@RestController
@RequestMapping("/outpatient")
public class OutpatientController {

	private final static Logger log = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private OutpatientService outpatientService;

	@GetMapping("/getAll")
	public HttpEntity getAllOutpatient() {
		Status status = new Status();
		HttpStatus httpStatus = null;
		OutpatientResponse allOutpatient = new OutpatientResponse();

		try {
			allOutpatient.setOutpatient(outpatientService.getAllOutpatient());

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

		allOutpatient.setStatus(status);

		return new ResponseEntity<>(allOutpatient, httpStatus);
	}

	@GetMapping("/getById")
	public HttpEntity getOutpatientById(@RequestParam Long outpatientId) {
		Status status = new Status();
		HttpStatus httpStatus = null;
		OutpatientResponse outpatient = new OutpatientResponse();

		try {
			outpatient.setOutpatient(outpatientService.getOutpatientById(outpatientId));

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

		outpatient.setStatus(status);

		return new ResponseEntity<>(outpatient, httpStatus);
	}

	@PostMapping(value = "/add")
	public HttpEntity addOutpatient(@RequestBody Outpatient outpatient) {
		Status status = new Status();
		HttpStatus httpStatus = null;

		try {
			outpatientService.saveOutpatient(outpatient);

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

	@PutMapping(value = "/update/{outpatientId}")
	public HttpEntity updateOutpatient(@PathVariable Long outpatientId, @RequestBody Outpatient outpatient ) {
		Status status = new Status();
		HttpStatus httpStatus = null;

		try {

			outpatientService.updateOutpatient(outpatientId, outpatient);

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
	
	@DeleteMapping(value = "/deleteById/{outpatientId}")
	public HttpEntity deleteOutpatientById(@PathVariable Long outpatientId) {
		Status status = new Status();
		HttpStatus httpStatus = null;

		try {

			outpatientService.deleteOutpatientById(outpatientId);

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

}
