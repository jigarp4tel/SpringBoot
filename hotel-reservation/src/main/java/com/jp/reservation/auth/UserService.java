package com.jp.reservation.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Transactional
	public User registerNewUserAccount(UserDto userDto)   throws UserAlreadyExistException {
		
		if(emailExist(userDto.getEmail())) {
			throw new UserAlreadyExistException()
		}
		
	}
	
	private boolean emailExist(String email) {
		return userRepository.findByEmail(email) != null;
	}
	
	
	

}
