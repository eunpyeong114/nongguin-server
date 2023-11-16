package com.nongguin.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtil {
	private static final String SALT = "NONGGUIN";

	// 토큰 생성 메서드
	public String createToken(String key, String value) throws UnsupportedEncodingException {
		return Jwts.builder().setHeaderParam("alg", "HS256").setHeaderParam("type", "JWT") // 헤더 완료
				.claim(key, value).setExpiration(new Date(System.currentTimeMillis() + 1800000)) // 페이로드 완료
				.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8")) // 서명 완료
				.compact(); // String형태로 바꿔줌
	}

	// 토큰 유효성 검사(복호화) 메서드
	public void valid(String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException,
			SignatureException, IllegalArgumentException, UnsupportedEncodingException {
		Jwts.parser().setSigningKey(SALT.getBytes("UTF-8")).parseClaimsJws(token);
	}
}
