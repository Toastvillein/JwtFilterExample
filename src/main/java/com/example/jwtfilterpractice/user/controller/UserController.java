package com.example.jwtfilterpractice.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtfilterpractice.user.dto.request.UserSignupRequest;
import com.example.jwtfilterpractice.user.dto.response.UserSignupResponse;
import com.example.jwtfilterpractice.user.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping("/signup")
	public ResponseEntity<UserSignupResponse> signUp(@Valid @RequestBody UserSignupRequest request){
		UserSignupResponse signup = userService.signup(request);

		return ResponseEntity.status(HttpStatus.OK).body(signup);
	}

}
