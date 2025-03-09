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
import com.srss.backend.transaction.entity.Inpatient;
import com.srss.backend.transaction.model.InpatientResponse;
import com.srss.backend.transaction.service.InpatientService;

@RestController
@RequestMapping("/inpatient")
public class InpatientController {

	private final static Logger log = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private InpatientService inpatientService;

	@GetMapping("/getAll")
	public HttpEntity getAllInpatient() {
		Status status = new Status();
		HttpStatus httpStatus = null;
		InpatientResponse allInpatient = new InpatientResponse();

		try {
			allInpatient.setInpatient(inpatientService.getAllInpatient());

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

		allInpatient.setStatus(status);

		return new ResponseEntity<>(allInpatient, httpStatus);
	}

	@GetMapping("/getById")
	public HttpEntity getInpatientById(@RequestParam Long inpatientId) {
		Status status = new Status();
		HttpStatus httpStatus = null;
		InpatientResponse inpatient = new InpatientResponse();

		try {
			inpatient.setInpatient(inpatientService.getInpatientById(inpatientId));

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

		inpatient.setStatus(status);

		return new ResponseEntity<>(inpatient, httpStatus);
	}

	@PostMapping(value = "/add")
	public HttpEntity addInpatient(@RequestBody Inpatient inpatient) {
		Status status = new Status();
		HttpStatus httpStatus = null;

		try {
			inpatientService.saveInpatient(inpatient);

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

	@PutMapping(value = "/update/{inpatientId}")
	public HttpEntity updateInpatient(@PathVariable Long inpatientId, @RequestBody Inpatient inpatient ) {
		Status status = new Status();
		HttpStatus httpStatus = null;

		try {

			inpatientService.updateInpatient(inpatientId, inpatient);

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
	
	@DeleteMapping(value = "/deleteById/{inpatientId}")
	public HttpEntity deleteInpatientById(@PathVariable Long inpatientId) {
		Status status = new Status();
		HttpStatus httpStatus = null;

		try {

			inpatientService.deleteInpatientById(inpatientId);

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
