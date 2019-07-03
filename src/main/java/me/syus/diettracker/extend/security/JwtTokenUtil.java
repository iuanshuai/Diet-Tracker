package me.syus.diettracker.extend.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {

    final String CLAIM_KEY_USERNAME = "sub";
    final String CLAIM_KEY_CREATED = "created";
    final String secret = "shuaige";
    final Long expiration = 86400L * 1000;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    //    private Long experication

    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
            logger.warn("get username from token failure", e);
        }
        return username;
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    private String generateToken(Map<String, Object> claims) {

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpireDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

    }

    public Date generateExpireDate() {
        return new Date(System.currentTimeMillis() + expiration);
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
            logger.warn("unable to decrypt token");
        }
        return claims;
    }


}
