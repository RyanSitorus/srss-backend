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

import com.srss.backend.base.model.DoctorResponse;
import com.srss.backend.base.model.Status;
import com.srss.backend.entity.Doctor;
import com.srss.backend.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	private final static Logger log = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private DoctorService doctorService;

	@GetMapping("/getAll")
	public HttpEntity getAllDoctor() {
		Status status = new Status();
		HttpStatus httpStatus = null;
		DoctorResponse allDoctor = new DoctorResponse();

		try {
			allDoctor.setDoctor(doctorService.getAllDoctor());

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

		allDoctor.setStatus(status);

		return new ResponseEntity<>(allDoctor, httpStatus);
	}

	@GetMapping("/getById")
	public HttpEntity getDoctorById(@RequestParam Long doctorId) {
		Status status = new Status();
		HttpStatus httpStatus = null;
		DoctorResponse doctor = new DoctorResponse();

		try {
			doctor.setDoctor(doctorService.getDoctorById(doctorId));

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

		doctor.setStatus(status);

		return new ResponseEntity<>(doctor, httpStatus);
	}

	@PostMapping(value = "/add")
	public HttpEntity addDoctor(@RequestBody Doctor doctor) {
		Status status = new Status();
		HttpStatus httpStatus = null;

		try {
			doctorService.saveDoctor(doctor);

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

	@PutMapping(value = "/update/{doctorId}")
	public HttpEntity updateDoctor(@PathVariable Long doctorId, @RequestBody Doctor doctor ) {
		Status status = new Status();
		HttpStatus httpStatus = null;

		try {

			doctorService.updateDoctor(doctorId, doctor);

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
	
	@DeleteMapping(value = "/deleteById/{doctorId}")
	public HttpEntity deleteDoctorById(@PathVariable Long doctorId) {
		Status status = new Status();
		HttpStatus httpStatus = null;

		try {

			doctorService.deleteDoctorById(doctorId);

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
