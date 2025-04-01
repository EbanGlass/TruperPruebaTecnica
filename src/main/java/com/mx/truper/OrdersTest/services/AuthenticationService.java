package com.mx.truper.OrdersTest.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mx.truper.OrdersTest.entities.UserTable;
import com.mx.truper.OrdersTest.repository.UserRepository;

@Service
public class AuthenticationService {

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	private final AuthenticationManager authenticationManager;

	public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder,
			AuthenticationManager authenticationManager) {
		
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
		
	}

    public UserTable signup(UserTable input) {
    	
    	UserTable user = new UserTable();
    	user.setUsername(input.getUsername());
    	user.setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);
        
    }

    public UserTable authenticate(UserTable input) {
    	
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return userRepository.findByUsername(input.getUsername())
                .orElseThrow();
        
    }
	
}
