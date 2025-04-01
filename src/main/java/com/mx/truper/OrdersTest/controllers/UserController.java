package com.mx.truper.OrdersTest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.truper.OrdersTest.entities.UserTable;
import com.mx.truper.OrdersTest.responses.LoginResponse;
import com.mx.truper.OrdersTest.services.AuthenticationService;
import com.mx.truper.OrdersTest.services.JwtService;

@RestController
@RequestMapping("/auth")
public class UserController {
	
	private final JwtService jwtService;
    
    private final AuthenticationService authenticationService;

    public UserController(JwtService jwtService, AuthenticationService authenticationService) {
    	
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        
    }

    @PostMapping(path = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserTable> register(@RequestBody UserTable registerUserDto) {
    	
    	UserTable registeredUser = authenticationService.signup(registerUserDto);
        
    	return ResponseEntity.ok(registeredUser);
        
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResponse> authenticate(@RequestBody UserTable loginUserDto) {
    	
    	UserTable authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = LoginResponse.builder().token(jwtToken).expiresIn(jwtService.getExpirationTime()).build();
        
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
        
    }
    
}
