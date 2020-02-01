package com.jp.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.reservation.data.entity.Guest;
import com.jp.reservation.data.repository.GuestRepository;

@SpringBootApplication
public class HotelReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelReservationApplication.class, args);
	}
	
	/*
	 * @RestController
	 * 
	 * @RequestMapping("/rooms") public class RoomController{
	 * 
	 * @Autowired private RoomRepository roomRepository;
	 * 
	 * @GetMapping public Iterable<Room> getRooms(){ return
	 * this.roomRepository.findAll(); }
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	
	@RestController
	@RequestMapping("/guests")
	public class GuestController {
		
		@Autowired
		private GuestRepository guestRepository;
		
		@GetMapping
		public Iterable<Guest> getGuests(){
			return this.guestRepository.findAll();
		}
	}

}
