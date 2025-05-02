package com.example.jwtfilterpractice.user.repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.jwtfilterpractice.global.exception.BizException;
import com.example.jwtfilterpractice.global.exception.ErrorCode;
import com.example.jwtfilterpractice.user.exception.UserErrorCode;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RedisRepository {

	private final RedisTemplate<String,String> redisTemplate;

	public String generateBlacklistKey(String token){
		String blacklistKey = "blacklist:" + token;

		return blacklistKey;
	}

	public boolean validateKey(String token){
		try {
			return redisTemplate.hasKey(generateBlacklistKey(token));
		} catch (Exception e) {
			throw new BizException(UserErrorCode.INVALID_REQUEST);
		}
	}

}
