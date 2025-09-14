package com.nikhil.ems.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
  private final String SECRET = "mysecretkeymysecretkeymysecretkey"; // 32+ chars
  private final long EXPIRATION = 1000 * 60 * 60; // 1 hour

  private SecretKey getSigningKey() {
    return Keys.hmacShaKeyFor(SECRET.getBytes());
  }

  public String generateToken(String username) {
    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
        .signWith(getSigningKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  private Claims extractAllClaims(String token) {
    return Jwts.parserBuilder()
        .setSigningKey(getSigningKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  public String extractUsername(String token) {
    return extractAllClaims(token).getSubject();
  }

  private Long extractExpiration(String token) {
    return extractAllClaims(token).getExpiration().getTime();
  }

  public boolean isTokenExpired(String token) {
    return extractExpiration(token) < System.currentTimeMillis();
  }

  public boolean validateToken(String token, String username) {
    return isTokenExpired(token) && extractUsername(token).equals(username);
  }
}

