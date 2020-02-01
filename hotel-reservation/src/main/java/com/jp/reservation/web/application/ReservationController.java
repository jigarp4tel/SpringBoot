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

@Controller
@RequestMapping(value = "/reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@RequestMapping(method = RequestMethod.GET)
	public String getReservation(@RequestParam(value = "date", required = false) String dateString, Model model) {

		List<RoomReservation> roomReservationsList = this.reservationService.getRoomReservationsByDate(dateString);
		model.addAttribute("roomReservations", roomReservationsList);

		return "reservations";
	}

}
