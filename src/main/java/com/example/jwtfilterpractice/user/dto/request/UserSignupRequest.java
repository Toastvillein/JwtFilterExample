package com.example.jwtfilterpractice.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserSignupRequest(
	@Email
	@NotBlank
	String email,

	@NotBlank
	String name,

	@NotBlank
	String password
) {
}
