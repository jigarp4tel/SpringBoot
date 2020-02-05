package com.jp.reservation.web.application;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jp.reservation.business.service.RoomService;
import com.jp.reservation.data.entity.Room;

@Controller
public class RoomWebController {

	@Autowired
	private RoomService roomService;

	@RequestMapping(value = "/rooms", method = RequestMethod.GET)
	public String getRoom(@RequestParam(value = "roomnumber", required = false) String roomNumber, Model model) {
		List<Room> roomList = this.roomService.getRoomByRoomNumber(roomNumber);
		model.addAttribute("roomDetails", roomList);

		return "rooms";

	}

	@GetMapping("/addroom")
	public String showAddRoomForm(Room room) {
		return "add_room"; // Redirects to addroom.html
	}

	// Method called from the addroom.html form
	@RequestMapping(value = "/addaroom", method = RequestMethod.POST)
	public String addRoom(@ModelAttribute Room room) {

		this.roomService.addRoom(room);
//		model.addAttribute("rooms", this.roomService.findAllRooms());
		return "add_room";
	}

	@GetMapping("/delete/{roomId}")
	public String deleteRoom(@PathVariable("roomId") long roomId, Model model) {

		this.roomService.deleteRoom(roomId);
		model.addAttribute("rooms", this.roomService.findAllRooms());
		return "redirect:/rooms";
	}

	@GetMapping("/edit/{roomId}")
	public ModelAndView showEditRoomForm(@PathVariable("roomId") long roomId) {

		ModelAndView mav = new ModelAndView("edit_room");
		Room room = this.roomService.findById(roomId);
		mav.addObject("room", room);
		return mav;
	}

	@PostMapping("/update")
	public String editRoom(@ModelAttribute Room room, Model model) {

		this.roomService.updateRoom(room);
		model.addAttribute("rooms", this.roomService.findAllRooms());
		return "redirect:/rooms";
	}

}
