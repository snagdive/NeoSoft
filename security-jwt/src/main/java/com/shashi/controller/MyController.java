package com.shashi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shashi.model.AuthenticationRequest;
import com.shashi.model.AuthenticationResponse;
import com.shashi.security.MyUserDetailsService;
import com.shashi.util.JwtUtil;

@RestController
public class MyController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@GetMapping(value = "/home")
	public String home()
	{
		return "<h1> Welcome Home </h1>";
	}
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception
	{
		// Authenticate Username and Password
		try
		{
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
				);
		}
		catch(BadCredentialsException ex)
		{
			throw new Exception("Incorrect Username Password.", ex);
		}
		
		// If Authenticated, Fetch UserDetails Object
		UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		
		// Generate JWT token
		final String jwt = jwtUtil.generateToken(userDetails);
		
		//Build and Return Authentication Response from JWT Token 
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
