package com.jp.reservation.business.service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.jp.reservation.auth.UserDto;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
	}

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		UserDto user = (UserDto) object;
		return user.getPassword().equals(user.getMatchingPassword());
	}

}
