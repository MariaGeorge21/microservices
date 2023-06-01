package com.bootsecurity.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bootsecurity.MyUserDetailsService;
import com.bootsecurity.model.AuthenticationRequest;
import com.bootsecurity.model.AuthenticationResponse;
import com.bootsecurity.util.JwtUtil;

@RestController
public class EmployeeResource {
	@Autowired
	private AuthenticationManager authenticationmanager;
	@Autowired
	private MyUserDetailsService userdetailsService;
	@Autowired
	JwtUtil jwtUtil;
	@GetMapping("/")
	public String greet() {
		return "working";
	}
	
	@GetMapping
	@RequestMapping("/admin")
	public String greetAdmin() {
		return "Admin@work";
	}

	@GetMapping
	@RequestMapping("/user")
	public String greetUser() {
		return "User@work";

	}
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
               System.out.println(authenticationRequest.getUsername() + authenticationRequest.getPassword());	
		try {
		authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}catch(BadCredentialsException e) {
			
			throw new Exception("Incorrect username or password",e);
		}
		final UserDetails userDetails = userdetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}
}


	
	
	
	
	
	
	
	
	
	
	
	
	


