package com.example.cardatabase.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    static final long EXPIRATIONTIME = 86400000; //하루
    static final String PREFIX = "Bearer"; //JWT, OAuth 토큰 사용을 명시한다.

    //비밀 키 생성. 시연 용도로만 이용해야함
    //앱 구성에서 읽을 수 있다
    static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    //서명된 JWT 토큰 생성
    public String getToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(key)
                .compact();
    }

    //요청 권한 부여 헤더에서 토큰을 가져와
    //토큰을 확인하고 사용자 이름을 얻음
    public String getAuthUser(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (token != null) {
            String user = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody()
                    .getSubject();
            if (user != null) {
                return user;
            }
        }
        return null;
    }
}
