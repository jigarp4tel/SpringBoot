package com.jp.reservation.data.webservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.reservation.data.entity.Room;
import com.jp.reservation.data.repository.RoomRepository;

@RestController
public class RoomController {
	/*
	 * @Autowired private RoomRepository roomRepository;
	 * 
	 * @RequestMapping(value="/rooms", method = RequestMethod.GET) List<Room>
	 * findAll(@RequestParam(value = "room" , required = false)String roomNumber){
	 * 
	 * List<Room> rooms = new ArrayList<Room>(); if(null == roomNumber) {
	 * Iterable<Room> results = this.roomRepository.findAll(); results.forEach(room
	 * -> {rooms.add(room);}); }else { Room room =
	 * this.roomRepository.findByRoomNumber(roomNumber); if(null!=room) {
	 * rooms.add(room); }
	 * 
	 * }
	 * 
	 * return rooms;
	 * 
	 * }
	 */
	
	
	@Autowired
	private RoomRepository roomRepository;
	
	@RequestMapping("/getrooms")
	public List<Room> getRooms(){
		
		List<Room> roomList = new ArrayList<Room>();
		
		Iterable<Room> rooms = this.roomRepository.findAll();
		
		rooms.forEach(room -> {
			roomList.add(room);
		});
		return roomList;
		
	}
	
}
