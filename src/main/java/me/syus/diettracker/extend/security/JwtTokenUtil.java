package me.syus.diettracker.extend.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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

//    private Long experication
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

    public Date generateExpireDate(){
        return new Date(System.currentTimeMillis()+86400L*1000);
    }



}
