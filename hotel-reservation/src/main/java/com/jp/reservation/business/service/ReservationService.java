package com.jp.reservation.business.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.reservation.business.domain.RoomReservation;
import com.jp.reservation.data.entity.Guest;
import com.jp.reservation.data.entity.Reservation;
import com.jp.reservation.data.entity.Room;
import com.jp.reservation.data.repository.GuestRepository;
import com.jp.reservation.data.repository.ReservationRepository;
import com.jp.reservation.data.repository.RoomRepository;

@Service
public class ReservationService {

	@Autowired
	private final RoomRepository roomRepository;
	private final GuestRepository guestRepository;
	private final ReservationRepository reservationRepository;

	public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository,
			ReservationRepository reservationRepository) {
		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
		this.reservationRepository = reservationRepository;
	}

	public List<RoomReservation> getRoomReservationsByDate(String dateString) {
		Date date = DateUtils.createDateFromDateString(dateString);
		Iterable<Room> rooms = this.roomRepository.findAll();
		Map<Long, RoomReservation> roomReservationMap = new HashMap<Long, RoomReservation>();
		rooms.forEach(room -> {
			RoomReservation roomReservation = new RoomReservation();
			roomReservation.setRoomId(room.getRoomId());
			roomReservation.setRoomName(room.getRoomName());
			roomReservation.setRoomNumber(room.getRoomNumber());

			roomReservationMap.put(room.getRoomId(), roomReservation);

		});

		Iterable<Reservation> reservations = this.reservationRepository
				.findByReservationDate(new java.sql.Date(date.getTime()));
		if (null != reservations) {
			reservations.forEach(reservation -> {
				Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();

				RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
				roomReservation.setFirstName(guest.getFirstName());
				roomReservation.setLastName(guest.getLastName());
				roomReservation.setGuestId(guest.getGuestId());

			});
		}

		List<RoomReservation> roomReservations = new ArrayList<RoomReservation>();

		for (Long roomId : roomReservationMap.keySet()) {
			roomReservations.add(roomReservationMap.get(roomId));

		}

		roomReservations.sort(new Comparator<RoomReservation>() {

			@Override
			public int compare(RoomReservation r1, RoomReservation r2) {
				if (r1.getRoomName() == r2.getRoomName()) {
					return r1.getRoomNumber().compareTo(r2.getRoomNumber());
				}
				return r1.getRoomName().compareTo(r2.getRoomName());
			}
		});

		return roomReservations;

	}

	public void addReservation(Reservation reservation) {
		this.reservationRepository.save(reservation);
	}

	public Iterable<Room> getRooms(){
		return this.roomRepository.findAll();
	}

	public Iterable<Guest> getGuests(){
		return this.guestRepository.findAll();
	}
	
}
