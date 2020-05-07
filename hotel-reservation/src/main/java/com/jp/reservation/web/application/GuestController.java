package com.jp.reservation.web.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.reservation.business.service.GuestService;
import com.jp.reservation.data.entity.Guest;

@Controller
public class GuestController {

	@Autowired
	private GuestService guestService;

	@GetMapping(value = { "/", "/index" })
	public String getHomePage(Model model) {

		return "index";
	}

	@RequestMapping(value = "/guests", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_USER')")
	public String getGuests(Model model) {

		model.addAttribute("guestDetails", this.guestService.getGuest());
		System.out.println(this.guestService.getGuest());
		return "guests";
	}

	@GetMapping("/addguest")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String getAddGuestForm(Guest guest) {
		return "add_guest";
	}

	@PostMapping("/addaguest")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String addGuest(@ModelAttribute Guest guest) {

		this.guestService.addGuest(guest);
		return "redirect:/guests";
	}

	@GetMapping(value = "/login")
	public String getLoginPage(Model model) {
		return "login";
	}

	@GetMapping(value = "logout-success")
	public String getLogoutPage(Model model) {
		return "logout";
	}

}
