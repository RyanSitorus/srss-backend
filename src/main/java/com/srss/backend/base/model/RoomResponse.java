package com.srss.backend.base.model;

import java.util.List;

import com.srss.backend.entity.Room;

public class RoomResponse {

	private Status status;
	private List<Room> room;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}

	

}
