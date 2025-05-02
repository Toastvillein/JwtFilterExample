package com.example.jwtfilterpractice.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jwtfilterpractice.user.dto.request.UserSignupRequest;
import com.example.jwtfilterpractice.user.dto.response.UserSignupResponse;
import com.example.jwtfilterpractice.user.entity.User;
import com.example.jwtfilterpractice.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserSerivceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;


	@Override
	public UserSignupResponse signup(UserSignupRequest request) {

		if(userRepository.findByEmail(request.email()).isPresent()){
			throw new IllegalArgumentException("이미 존재하는 ID 입니다.");
		}

		String encodedPass = passwordEncoder.encode(request.password());

		User user = new User(request.email(), request.name(), encodedPass);

		userRepository.save(user);

		String message = "회원가입 완료!";

		return UserSignupResponse.from(message);
	}
}
