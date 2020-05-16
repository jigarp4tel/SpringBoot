package com.jp.reservation.web.application;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.jp.reservation.auth.UserDto;

@Controller
public class RegistrationController {

	public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto, HttpServletRequest request,
			Errors errors) {

		return null;

	}

	@GetMapping("/user/signup")
	public String getRegistrationForm(WebRequest request, Model model) {
		UserDto userDto = new UserDto();
		model.addAttribute("user", userDto);
		return "signup";
	}

}
