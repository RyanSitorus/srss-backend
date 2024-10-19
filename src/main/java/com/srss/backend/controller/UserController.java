package com.srss.backend.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.srss.backend.base.model.Status;
import com.srss.backend.entity.Users;
import com.srss.backend.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "User", description = "APIs for patient data")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/allUser")
	public HttpEntity getAllUser() {
		Status status = new Status();
		HttpStatus httpStatus = null;
		Map<String, Object> response = new HashMap<>();

		try {
			response.put("users", userService.getAllUser());

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

	@GetMapping("/userById")
	public HttpEntity getUserById(@RequestParam Long userId) {
		Status status = new Status();
		HttpStatus httpStatus = null;
		Map<String, Object> response = new HashMap<>();

		try {
			response.put("users", userService.getUsersById(userId));

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

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public HttpEntity addUser(@RequestBody Users user) {
		Status status = new Status();
		HttpStatus httpStatus = null;
		Map<String, Object> response = new HashMap<>();

		try {
			userService.saveUsers(user);

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

	@GetMapping("/getUsers")
	public HttpEntity getUsers(@RequestParam String username) {
		Status status = new Status();
		HttpStatus httpStatus = null;
		Map<String, Object> response = new HashMap<>();

		try {
			response.put("users", userService.getUsers(username));

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

		} catch (NullPointerException npe) {

			status.setResponseCode(HttpStatus.BAD_REQUEST.value());
			status.setResponseMessage(npe.getMessage());
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
	
}