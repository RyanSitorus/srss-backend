package com.srss.backend.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srss.backend.entity.Room;
import com.srss.backend.repository.RoomRepository;

@Service
public class RoomService {
	
	private final static Logger log = LoggerFactory.getLogger(RoomService.class);

	@Autowired
	private RoomRepository roomRepository;

	public List<Room> getAllRoom() throws ServiceException{
		return roomRepository.findAll();
	}
	
	public List<Room> getRoomById(Long id) throws ServiceException{
		Room room = new Room();
		List<Room> listRoom = new ArrayList<>();
		try {
			
			room = roomRepository.findById(id).get();
			listRoom.add(room);
			
			return listRoom;
			
		} catch (NoSuchElementException e) {
			
			throw new ServiceException("Room with id " + id + " not found");
			
		}
	}

	public void saveRoom(Room room) throws ServiceException{
		LocalDate today = LocalDate.now();
		String dateString = today.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
		Random rand = new Random();

		room.setRoomCode(dateString + String.valueOf(rand.nextInt(1000)));
		roomRepository.save(room);
	}

	public void updateRoom(Long roomId, Room room) throws ServiceException{
		Room existingRooms = new Room();
		try {
			existingRooms = roomRepository.findById(roomId).get();
			
			room.setIdRoom(existingRooms.getIdRoom());
			room.setRoomCode(existingRooms.getRoomCode());
			roomRepository.save(room);

		} catch (NoSuchElementException e) {
			throw new ServiceException("Room with id " + roomId + " not found");
		}
	}

	public void deleteRoomById(Long id) throws ServiceException{
		roomRepository.deleteById(id);
	}

}
