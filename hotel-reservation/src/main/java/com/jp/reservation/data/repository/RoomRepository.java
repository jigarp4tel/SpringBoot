package com.jp.reservation.data.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jp.reservation.data.entity.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{
	
	// Room findByRoomNumber(String number);
	Room findByRoomNumber(String roomNumber);
	
	Room findByRoomName(String roomName);
	
	void deleteById(Long roomId);

}
