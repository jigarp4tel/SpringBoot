package com.jp.reservation.web.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.reservation.business.service.GuestService;


@Controller
public class GuestController {
		
	@Autowired
	private GuestService guestService;
	
	@RequestMapping(value = "/guests", method = RequestMethod.GET)
	public String getGuests(Model model) {
		
			
		model.addAttribute("guestDetails", this.guestService.getGuest());
		System.out.println(this.guestService.getGuest());
		return "guests";
	}
	

}
