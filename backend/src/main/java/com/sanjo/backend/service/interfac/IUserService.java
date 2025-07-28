package com.sanjo.backend.service.interfac;

import com.sanjo.backend.dto.LoginRequest;
import com.sanjo.backend.dto.Response;
import com.sanjo.backend.entity.User;

public interface IUserService {

    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String email);

}
