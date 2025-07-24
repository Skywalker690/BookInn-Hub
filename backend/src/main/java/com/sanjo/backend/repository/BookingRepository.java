package com.sanjo.backend.repository;

import com.sanjo.backend.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    List<Booking> findBookingByRoomId(Long roomId);
    List<Booking> findBookingByBookingConfirmationCode(String confirmationCode);
    List<Booking> findByUserId(Long userId);

}
