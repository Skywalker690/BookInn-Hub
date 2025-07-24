package com.sanjo.backend.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    private int numOfAdult;
    private int numOfChildren;
    private int totalNumOfGuest;

    private String bookingConfirmationCode;


}
