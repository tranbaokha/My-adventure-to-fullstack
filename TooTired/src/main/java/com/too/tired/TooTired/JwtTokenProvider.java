package com.too.tired.TooTired;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.nimbusds.jose.JWSAlgorithm;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {
    private final String JWT_SECRET = "lodaaaaaa";
    private final long JWT_EXPIRATION = 3600;
    public String generateToken(UserEntityDetail userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        return Jwts.builder()
                   .setSubject(Long.toString(userDetails.getUserEntity().getId()))
                   .setIssuedAt(now)
                   .setExpiration(expiryDate)
                   .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                   .compact();
    }

    public int getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(JWT_SECRET)
                            .parseClaimsJws(token)
                            .getBody();

        return Integer.parseInt(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            //log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            //log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            //log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            //log.error("JWT claims string is empty.");
        }
        return false;
    }
}