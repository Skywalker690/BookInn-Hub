package com.sanjo.backend.service.interfac;

import com.sanjo.backend.dto.Response;
import com.sanjo.backend.entity.Booking;

public interface IBookingService {

    Response saveBooking(Long roomId, Long userId, Booking bookingRequest);

    Response findBookingByConfirmationCode(String confirmationCode);

    Response getAllBookings();

    Response cancelBooking(Long bookingId);

}
