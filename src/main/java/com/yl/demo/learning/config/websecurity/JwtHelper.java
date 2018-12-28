package com.yl.demo.learning.config.websecurity;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class JwtHelper implements Serializable {

    private final Map<String, Object> header = new HashMap<>();

    private final Map<String, Object> publicClaims = new HashMap<>();

    @Value("${jwt.secret}")
    private final String secret = "jwt_secret_sample";

    @Value("${jwt.expiration}")
    private final Long expiration = 1300819380L;



    public String generateToken(String username, String password) throws Exception {
        // TODO set your own generation
        header.put("alg", "HS256");
        header.put("typ", "JWT");

        publicClaims.put("username", username);
        publicClaims.put("password", password);

        return Jwts.builder()
                .setSubject(username)
                .setHeader(header)
                .setClaims(publicClaims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Date generateExpirationDate() throws Exception {
        return Date.from(
                LocalDateTime.now().plusHours(1)
                .atZone(ZoneId.systemDefault())
                .toInstant()); // will expires at now + 1 hour (datetime format);
    }

    public String getUsername(String token) throws Exception {
        return getClaims(token).get("username", String.class);
    }

    public Header getHeader(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parse(token).getHeader();
    }

    public Claims getClaims(String token) throws Exception {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public Jwt getPrettyToken(String token) throws Exception {
        return Jwts.parser()
                .setSigningKey(secret)
                .parse(token);
    }

    public boolean validate(String token, UserDetails userDetails) throws Exception {
        //TODO set your own validate rule between token and userDetails
        return true;
    }

    public boolean isExpired(String token) throws Exception {
        return getExpirationDate(token).before(new Date());
    }

    public Date getExpirationDate(String token) throws Exception {
        return getClaims(token).getExpiration();
    }

}
