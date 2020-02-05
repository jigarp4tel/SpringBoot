package com.jp.reservation.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jp.reservation.data.entity.Guest;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {

}
