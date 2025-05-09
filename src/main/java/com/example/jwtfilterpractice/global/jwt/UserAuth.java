package com.example.jwtfilterpractice.global.jwt;

import com.example.jwtfilterpractice.user.entity.UserRole;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserAuth {
	private final Long id;
	// private final UserRole.USER;
}
