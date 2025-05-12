package com.example.jwtfilterpractice.global.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtUtil {

	@Value("${jwt.secret}")
	private String secretKey;

	private static final long expiration = 1000L * 60 * 30;
							// Long id, UserRole role
	public String createToken(Long id){
		return Jwts.builder()
			.setSubject(String.valueOf(id))
			//.claim("role",role)
			.setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis()+expiration))
			.signWith(Keys.hmacShaKeyFor(secretKey.getBytes()))
			.compact();
	}

	public UserAuth extractUserAuth(String token){
		Claims claims = Jwts.parserBuilder()
			.setSigningKey(secretKey.getBytes())
			.build()
			.parseClaimsJws(token)
			.getBody();

		return new UserAuth(Long.parseLong(claims.getSubject())); //,UserRole.valueOf(body.get("userRole",String.class))
	}

	public boolean validateToken(String token){
		try {
			extractUserAuth(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String extractToken(HttpServletRequest request){
		String bearer = request.getHeader("Authorization");
		if(bearer != null && bearer.startsWith("Bearer ")){
			return bearer.substring(7);
		}
		return null;
	}

	public long getExpiration(String token){
		Claims claims = Jwts.parserBuilder()
			.setSigningKey(secretKey.getBytes())
			.build()
			.parseClaimsJws(token)
			.getBody();

		return claims.getExpiration().getTime() - System.currentTimeMillis();
	}
}
