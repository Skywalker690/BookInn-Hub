package com.sanjo.backend.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "CheckIn date is required")
    private LocalDate checkInDate;
    @Future(message = "CheckOut date must be in future")
    private LocalDate checkOutDate;

    @Min(value = 1,message = "Number of adults must not less than 1")
    private int numOfAdult;

    @Min(value = 0,message = "Number of children cannot not less than 0")
    private int numOfChildren;

    private int totalNumOfGuest;

    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;


    public void setNumOfAdult(int numOfAdult) {
        this.numOfAdult = numOfAdult;
        calculateTotalNumGuest();
    }

    public void setNumOfChildren(int numOfChildren) {
        this.numOfChildren = numOfChildren;
        calculateTotalNumGuest();
    }


    public void calculateTotalNumGuest(){
        this.totalNumOfGuest=this.numOfAdult+this.numOfChildren;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", numOfAdult=" + numOfAdult +
                ", numOfChildren=" + numOfChildren +
                ", totalNumOfGuest=" + totalNumOfGuest +
                ", bookingConfirmationCode='" + bookingConfirmationCode + '\'' +
                '}';
    }
}

