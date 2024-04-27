package com.apigestion.hoteleria.web.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {
    private static final String SECRET_KEY = "clave";
    private static final Algorithm ALGORITM = Algorithm.HMAC256(SECRET_KEY);

    public String create(String username){
        return JWT.create()
                .withSubject(username)
                .withIssuer("keiner-code")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(15)))
                .sign(ALGORITM);
    }
    public Boolean isValid(String jwt){
        try{
            JWT.require(ALGORITM)
                    .build()
                    .verify(jwt);
            return true;
        }catch (JWTVerificationException e){
            return false;
        }
    }
    public String getUsername(String jwt){
        return JWT.require(ALGORITM)
                .build()
                .verify(jwt)
                .getSubject();
    }
}
