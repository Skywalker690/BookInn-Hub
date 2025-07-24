package com.sanjo.backend.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.sanjo.backend.entity.Booking;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) //Don't want to return data with null value
public class UserDTO {

    private long id;
    private String email;
    private String name;
    private String phoneNumber;
    private List<Booking> bookings = new ArrayList<>();
}

//Exposing role and password
