package com.docs.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.docs.dto.UserDTO;
import com.docs.entities.Users;
import com.docs.services.CustomUserService;

@RestController
@RequestMapping(value = "/user")
public class UsersResource {
	
	CustomUserService userService;
	
//	@RequestMapping(method = RequestMethod.POST, path = "/login")
//	public ResponseEntity<Users> findByEmail () {
//		return ResponseEntity.ok().body(user);
//	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> insertUser (@PathVariable UserDTO userDTO) {
		userService.insert(userDTO);
		return ResponseEntity.ok().body("Salvo com Sucesso!");
	}
}
