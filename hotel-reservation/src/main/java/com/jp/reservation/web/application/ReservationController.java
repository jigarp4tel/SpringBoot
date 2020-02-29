package com.jp.reservation.web.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.jp.reservation.business.domain.RoomReservation;
import com.jp.reservation.business.service.ReservationService;
import com.jp.reservation.data.entity.Reservation;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;


	@RequestMapping(value = "/reservations" , method = RequestMethod.GET)
	public String getReservation(@RequestParam(value = "date", required = false) String dateString, Model model) {

		List<RoomReservation> roomReservationsList = this.reservationService.getRoomReservationsByDate(dateString);
		model.addAttribute("roomReservations", roomReservationsList);

		return "reservations";
	}

	@GetMapping(value="/add_reservation")
	public String getReservationForm(Reservation reservation, Model model) {

		model.addAttribute("roomDetails", this.reservationService.getRooms());
		model.addAttribute("guestDetails", this.reservationService.getGuests());
		return "add_reservation";
		
	}
	

	@RequestMapping(value="/addareservation", method=RequestMethod.POST)
	public String addReservation(@ModelAttribute Reservation reservation) {

		System.out.println("IN POST METHOD");
		this.reservationService.addReservation(reservation);

		return "redirect:/reservations";
	}
	

}
