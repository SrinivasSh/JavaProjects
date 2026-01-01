package com.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTService {

	@Value("${jwt.expiration}")
	private long jwtExpiration;

	@Value("${jwt.secretKey}")
	private String secretKeyBase64;

	public String extractEmail(String token) {
		return extractClaim(token, Claims::getSubject); // Method Reference
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	public String generateToken(String userName) {
		return generateToken(new HashMap<>(), userName);
	}

	public String generateToken(Map<String, Object> extraClaims, String userName) {
		return buildToken(extraClaims, userName, jwtExpiration);
	}

	private String buildToken(Map<String, Object> extraClaims, String userName, long expiration) {
		return Jwts.builder().claims(extraClaims).subject(userName).issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + expiration)).signWith(getSignInKey()).compact();
	}

	public boolean isTokenValid(String token, String userName) {
		final String usernameFromToken = extractEmail(token);
		return (usernameFromToken.equals(userName)) && !isTokenExpired(token);
	}

	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().verifyWith(getSignInKey()).build().parseSignedClaims(token).getPayload();

	}

	private SecretKey getSignInKey() {
//			SecretKey key=Jwts.SIG.HS256.key().build();
//			
//			String base64Key=Encoders.BASE64.encode(key.getEncoded());   ///Once per application
		byte[] keyBytes = Decoders.BASE64.decode(secretKeyBase64);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
