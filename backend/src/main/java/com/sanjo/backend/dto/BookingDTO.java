package com.sanjo.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sanjo.backend.entity.Room;
import com.sanjo.backend.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {

    private long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numOfAdult;
    private int numOfChildren;
    private int totalNumOfGuest;
    private String bookingConfirmationCode;

    private UserDTO user;

    private RoomDTO room;
}
