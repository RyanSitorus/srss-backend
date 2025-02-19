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

import com.srss.backend.base.model.RoomResponse;
import com.srss.backend.base.model.Status;
import com.srss.backend.entity.Room;
import com.srss.backend.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {

	private final static Logger log = LoggerFactory.getLogger(RoomController.class);

	@Autowired
	private RoomService roomService;

	@GetMapping("/getAll")
	public HttpEntity getAllRoom() {
		Status status = new Status();
		HttpStatus httpStatus = null;
		RoomResponse allRoom = new RoomResponse();

		try {
			allRoom.setRoom(roomService.getAllRoom());

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

		allRoom.setStatus(status);

		return new ResponseEntity<>(allRoom, httpStatus);
	}

	@GetMapping("/getById")
	public HttpEntity getRoomById(@RequestParam Long roomId) {
		Status status = new Status();
		HttpStatus httpStatus = null;
		RoomResponse room = new RoomResponse();

		try {
			room.setRoom(roomService.getRoomById(roomId));

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

		room.setStatus(status);

		return new ResponseEntity<>(room, httpStatus);
	}

	@PostMapping(value = "/add")
	public HttpEntity addRoom(@RequestBody Room room) {
		Status status = new Status();
		HttpStatus httpStatus = null;

		try {
			roomService.saveRoom(room);

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

	@PutMapping(value = "/update/{roomId}")
	public HttpEntity updateRoom(@PathVariable Long roomId, @RequestBody Room room) {
		Status status = new Status();
		HttpStatus httpStatus = null;

		try {

			roomService.updateRoom(roomId, room);

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

	@DeleteMapping(value = "/deleteById/{roomId}")
	public HttpEntity deleteRoomById(@PathVariable Long roomId) {
		Status status = new Status();
		HttpStatus httpStatus = null;

		try {

			roomService.deleteRoomById(roomId);

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