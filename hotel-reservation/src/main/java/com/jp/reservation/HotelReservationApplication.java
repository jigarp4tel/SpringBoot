package com.jp.reservation;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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
	
	

}
