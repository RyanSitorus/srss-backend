package com.srss.backend.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

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
import org.springframework.web.bind.annotation.RestController;

import com.srss.backend.base.model.Status;
import com.srss.backend.entity.Doctor;
import com.srss.backend.service.DoctorService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Doctor", description = "APIs for doctor data")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@GetMapping("/allDoctor")
	public HttpEntity getAllDoctor() {
		Status status = new Status();
		HttpStatus httpStatus = null;
		Map<String, Object> response = new HashMap<>();

		try {
			response.put("doctor", doctorService.getAllDoctor());

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

	@GetMapping("/doctorById")
	public HttpEntity getDoctorById(@RequestParam Long doctorId) {
		Status status = new Status();
		HttpStatus httpStatus = null;
		Map<String, Object> response = new HashMap<>();

		try {
			response.put("doctor", doctorService.getDoctorById(doctorId));

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

		}catch (Exception e) {

			status.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			status.setResponseMessage("We are having server's problem. Sorry for this inconvenience");
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();

		}

		response.put("status", status);

		return new ResponseEntity<>(response, httpStatus);
	}

	@RequestMapping(value = "/addDoctor", method = RequestMethod.POST)
	public HttpEntity addDoctor(@RequestBody Doctor doctor) {
		Status status = new Status();
		HttpStatus httpStatus = null;
		Map<String, Object> response = new HashMap<>();

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

		response.put("status", status);

		return new ResponseEntity<>(response, httpStatus);

	}

	@RequestMapping(value = "/updateDoctor", method = RequestMethod.PUT)
	public HttpEntity updateDoctor(@RequestParam Long doctorId, @RequestBody Doctor doctor ) {
		Status status = new Status();
		HttpStatus httpStatus = null;
		Map<String, Object> response = new HashMap<>();

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
		response.put("status", status);

		return new ResponseEntity<>(response, httpStatus);
	}
	
	@RequestMapping(value = "/deleteDoctorById", method = RequestMethod.DELETE)
	public HttpEntity deleteDoctorById(@RequestParam Long doctorId) {
		Status status = new Status();
		HttpStatus httpStatus = null;
		Map<String, Object> response = new HashMap<>();

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
		response.put("status", status);

		return new ResponseEntity<>(response, httpStatus);
	}

}
