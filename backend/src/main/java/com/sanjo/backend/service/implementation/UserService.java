package com.sanjo.backend.service.implementation;

import com.sanjo.backend.dto.LoginRequest;
import com.sanjo.backend.dto.Response;
import com.sanjo.backend.dto.UserDTO;
import com.sanjo.backend.entity.User;
import com.sanjo.backend.exception.OurException;
import com.sanjo.backend.repository.UserRepository;
import com.sanjo.backend.service.interfac.IUserService;
import com.sanjo.backend.utils.JWTUtils;
import com.sanjo.backend.utils.Utils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JWTUtils jwtUtils, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Response register(User user) {
        Response response = new Response();
        try {
            if (user.getRole() == null || user.getRole().isBlank() ) {
                user.setRole("USER");
            }

            if (userRepository.existsByEmail(user.getEmail())) {
                throw new OurException(user.getEmail() + "already exist");
                
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User savedUser = userRepository.save(user);

            UserDTO userDTO = Utils.mapUserEntityToUserDTO(savedUser);
            response.setStatusCode(400);
            response.setUser(userDTO);

        }catch (OurException e) {
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error Occurred During User Registration "+e.getMessage());
        }

        return response;
    }

    @Override
    public Response login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public Response getAllUsers() {
        return null;
    }

    @Override
    public Response getUserBookingHistory(String userId) {
        return null;
    }

    @Override
    public Response deleteUser(String userId) {
        return null;
    }

    @Override
    public Response getUserById(String userId) {
        return null;
    }

    @Override
    public Response getMyInfo(String email) {
        return null;
    }
}
