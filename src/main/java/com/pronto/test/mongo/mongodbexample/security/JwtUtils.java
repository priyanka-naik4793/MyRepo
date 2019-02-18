package com.pronto.test.mongo.mongodbexample.security;

import com.pronto.test.mongo.mongodbexample.constants.SecurityConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

import java.util.Date;

import static com.pronto.test.mongo.mongodbexample.constants.SecurityConstants.EXPIRATION_TIME;

public class JwtUtils {

    public static String getAuthenticationToken(String userName){
        return Jwts.builder()
                .setSubject(userName)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
                .compact();
    }
}
