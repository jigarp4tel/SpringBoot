package com.jp.reservation.web.application;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jp.reservation.business.service.RoomService;
import com.jp.reservation.data.entity.Room;

@Controller
public class RoomWebController {

	@Autowired
	private final RoomService roomService;

	public RoomWebController(RoomService roomService) {
		super();
		this.roomService = roomService;
	}

	@GetMapping(value = "/rooms")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String getRoom(@RequestParam(value = "roomnumber", required = false) String roomNumber, Model model) {
		List<Room> roomList = this.roomService.getRoomByRoomNumber(roomNumber);
		model.addAttribute("roomDetails", roomList);
		return "rooms";

	}
	


	@GetMapping("/addroom")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String showAddRoomForm(Room room) {
		return "add_room"; // Redirects to addroom.html
	}

	@PostMapping(value = "/addaroom")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String addRoom(@ModelAttribute Room room) {

		this.roomService.addRoom(room);
		return "add_room";
	}
	
	
	

	@GetMapping("/delete/{roomId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String deleteRoom(@PathVariable("roomId") long roomId, Model model) {

		this.roomService.deleteRoom(roomId);
		model.addAttribute("rooms", this.roomService.findAllRooms());
		return "redirect:/rooms";
	}
	
	
	/*
	 * @GetMapping("/edit/{roomId}")
	 * 
	 * @PreAuthorize("hasRole('ROLE_USER')") public ModelAndView
	 * showEditRoomForm(@PathVariable("roomId") long roomId) {
	 * 
	 * Room room = this.roomService.findById(roomId); ModelAndView mav = new
	 * ModelAndView("edit_room"); mav.addObject("room", room); return mav; }
	 */
	
	
	@GetMapping("/edit/{roomId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String showEditRoomForm(@PathVariable("roomId") long roomId, Model model) {
		Room room = this.roomService.findById(roomId);		
		model.addAttribute("room", room);		
		return "edit_room";
	}

	@PostMapping("/update")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String editRoom(@ModelAttribute Room room, Model model) {

		this.roomService.updateRoom(room);
		model.addAttribute("rooms", this.roomService.findAllRooms());
		return "redirect:/rooms";
	}

}
