package com.jp.reservation.data.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jp.reservation.data.entity.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long>{
	
	List<Reservation> findByReservationDate(Date date);
	
	

}
