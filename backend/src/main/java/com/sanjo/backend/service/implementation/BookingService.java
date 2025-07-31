package com.sanjo.backend.service.implementation;

import com.sanjo.backend.dto.Response;
import com.sanjo.backend.entity.Booking;
import com.sanjo.backend.service.interfac.IBookingService;
import org.springframework.stereotype.Service;

@Service
public class BookingService implements IBookingService {

    @Override
    public Response saveBooking(Long roomId, Long userId, Booking bookingRequest) {
        return null;
    }

    @Override
    public Response findBookingByConfirmationCode(String confirmationCode) {
        return null;
    }

    @Override
    public Response getAllBookings() {
        return null;
    }

    @Override
    public Response cancelBooking(Long bookingId) {
        return null;
    }
}
