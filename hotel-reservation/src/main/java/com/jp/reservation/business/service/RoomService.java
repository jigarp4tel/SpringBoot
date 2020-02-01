package com.jp.reservation.business.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.reservation.data.entity.Room;
import com.jp.reservation.data.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;

	////////// GET ROOM BY ROOM NUMBER //////////

	public List<Room> getRoomByRoomNumber(String roomNumber) {

		List<Room> roomList = new ArrayList<Room>();

		if (null == roomNumber || roomNumber.equals("")) {
			Iterable<Room> rooms = this.roomRepository.findAll();

			rooms.forEach(room -> {
				roomList.add(room);
			});
		} else {
			Room room = this.roomRepository.findByRoomNumber(roomNumber.toUpperCase());

			if (null != room) {
				roomList.add(room);
			} else {
				Iterable<Room> rooms = this.roomRepository.findAll();

				rooms.forEach(room1 -> {
					roomList.add(room1);
				});

			}

		}

		roomList.sort(new Comparator<Room>() {

			@Override
			public int compare(Room r1, Room r2) {
				return r1.getRoomNumber().compareTo(r2.getRoomNumber());
			}
		});
		return roomList;
	}

	//////////////////////////////////////////////////////////////////////////////

	public Iterable<Room> findAllRooms() {
		return this.roomRepository.findAll();
	}

	/////////////////////////////////////////////////////////////////////////////////////

	public Room findByRoomNumber(String roomNumber) {
		return this.roomRepository.findByRoomNumber(roomNumber);
	}

	/////////////// ADD A ROOM///////////////////
	public void addRoom(Room room) {
		this.roomRepository.save(room);
	}

	////////////////// DELETE A ROOM //////////////////////
	public void deleteRoom(long roomId) {
		this.roomRepository.deleteById(roomId);
	}

	//////////////////////////////////////////////////////////////
	public Room findById(long id) {
		return this.roomRepository.findById(id).get();
	}

	/////////////////////////////////////////////////////////////////////

	public Room updateRoom(Room room) {

		Optional<Room> roomList = this.roomRepository.findById(room.getRoomId());

		Room newRoom = roomList.get();

		newRoom.setRoomName(room.getRoomName());
		newRoom.setRoomNumber(room.getRoomNumber());
		newRoom.setBedInfo(room.getBedInfo());

		newRoom = this.roomRepository.save(newRoom);

		return newRoom;
	}

}
