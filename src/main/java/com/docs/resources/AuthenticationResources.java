package com.docs.resources;

import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docs.config.JWTTokenHelper;
import com.docs.dto.AuthenticationDTO;
import com.docs.entities.Users;
import com.docs.response.LoginResponse;

@RestController
@RequestMapping("/api/")
public class AuthenticationResources {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	JWTTokenHelper jWTTokenHelper;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@CrossOrigin
	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationDTO authenticationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {

		final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getEmail(), authenticationRequest.getSenha()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		Users user=(Users)authentication.getPrincipal();
		String jwtToken=jWTTokenHelper.generateToken(user.getUsername());
		
		LoginResponse response=new LoginResponse();
		response.setToken(jwtToken);
		

		return ResponseEntity.ok(response);
	}
	
//	@GetMapping("/auth/userinfo")
//	public ResponseEntity<?> getUserInfo(Principal user){
//		User userObj=(User) userDetailsService.loadUserByUsername(user.getName());
//		
//		UserInfo userInfo=new UserInfo();
//		userInfo.setFirstName(userObj.getFirstName());
//		userInfo.setLastName(userObj.getLastName());
//		userInfo.setRoles(userObj.getAuthorities().toArray());
//		
//		
//		return ResponseEntity.ok(userInfo);
//		
//		
//		
//	}
}