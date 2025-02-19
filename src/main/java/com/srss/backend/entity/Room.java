package com.srss.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "room")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_room", nullable = false)
	private Long idRoom;

	@Column(name = "room_code", nullable = false, unique = true)
	private String roomCode;

	@Column(name = "room_name", nullable = false)
	private String roomName;

	@Column(name = "bed_capacity", nullable = false)
	private Integer bedCapacity;

	@Column(name = "description", nullable = true)
	private String description;

	public Long getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(Long idRoom) {
		this.idRoom = idRoom;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Integer getBedCapacity() {
		return bedCapacity;
	}

	public void setBedCapacity(Integer bedCapacity) {
		this.bedCapacity = bedCapacity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
