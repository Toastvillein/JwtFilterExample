package com.example.jwtfilterpractice.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BizException extends RuntimeException {

	private ErrorCode errorCode;
}
