package com.example.cardatabase.controller;

import com.example.cardatabase.domain.AccountCredentials;
import com.example.cardatabase.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) {
        //토큰 생성하고 응답을 Authorization 헤더로 보냄
        UsernamePasswordAuthenticationToken creds =
                new UsernamePasswordAuthenticationToken(
                        credentials.getUsername(),
                        credentials.getPassword()
                );

        Authentication auth = authenticationManager.authenticate(creds);

        //토큰생성
        String jwts = jwtService.getToken(auth.getName());

        //생성된 토큰으로 응답을 생성
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION,"Bearer " + jwts) //띄어쓰기
                .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS,"Authorization")
                .build();
    }

}
