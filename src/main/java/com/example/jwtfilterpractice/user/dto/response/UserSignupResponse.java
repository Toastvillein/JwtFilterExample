package com.example.jwtfilterpractice.user.dto.response;

public record UserSignupResponse(
	String message
) {
	public static UserSignupResponse from(String message){
		return new UserSignupResponse(message);
	}
}
