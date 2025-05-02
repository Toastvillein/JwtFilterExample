package com.example.jwtfilterpractice.user.service;

import com.example.jwtfilterpractice.user.dto.request.UserSignupRequest;
import com.example.jwtfilterpractice.user.dto.response.UserSignupResponse;

import jakarta.validation.Valid;

public interface UserService {
	UserSignupResponse signup(UserSignupRequest request);
}
