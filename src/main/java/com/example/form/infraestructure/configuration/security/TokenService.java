package com.example.form.infraestructure.configuration.security;

import com.example.form.infraestructure.exception.TokenInvalidException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {

    private final String accessTokenSecret;
    private final Long accessTokenValiditySeconds;

    public TokenService(@Value("${jwt.access.token.secret}") String accessTokenSecret,
                        @Value("${jwt.access.token.validity.seconds}") Long accessTokenValiditySeconds) {
        this.accessTokenSecret = accessTokenSecret;
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }


    public String generateToken(String name, String email) {
        long expirationTime = accessTokenValiditySeconds * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
        Map<String, Object> extra = new HashMap<>();
        extra.put("name", name);
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(accessTokenSecret.getBytes()))
                .compact();

    }

    public UsernamePasswordAuthenticationToken getAuthentication(String token) throws TokenInvalidException {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(accessTokenSecret.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            String email = claims.getSubject();
            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        } catch (JwtException e) {
            throw new TokenInvalidException("The token is Invalid");
        }
    }
}
