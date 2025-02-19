package com.srss.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srss.backend.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
