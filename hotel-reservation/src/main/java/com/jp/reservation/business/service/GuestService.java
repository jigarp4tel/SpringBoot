package com.jp.reservation.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.reservation.data.entity.Guest;
import com.jp.reservation.data.repository.GuestRepository;

@Service
public class GuestService {
	
	
	@Autowired
	private GuestRepository guestRepository;
	
	public Iterable<Guest> getGuest(){
		return this.guestRepository.findAll();
	}
	
}
