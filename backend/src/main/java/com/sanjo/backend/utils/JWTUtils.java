package com.sanjo.backend.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class JWTUtils {

    private static final long EXPIRATION_TIME = 1000 * 60 * 24 * 7; // 7 days
    private SecretKey key;

    @Value("${jwt.secret}")
    private String secretString;

    @PostConstruct
    public void init() {
        byte[] keyBytes = Decoders.BASE64.decode(secretString);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }


}
