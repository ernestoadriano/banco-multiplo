package com.ernesto.banco_multiplo.controller;

import com.ernesto.banco_multiplo.entity.user.AuthenticationDTO;
import com.ernesto.banco_multiplo.service.user.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * @author: Ernesto Adriano
 * */
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO dto) {
       return authenticationService.login(dto);
    }
}
