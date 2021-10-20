package com.docs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.docs.dto.UserDTO;
import com.docs.entities.Users;
import com.docs.repositories.UserDetailsRepository;

@Service
public class CustomUserService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserDetailsRepository repository;

	public void insert(UserDTO userDTO) {
		Users user = new Users(userDTO.getNome(), userDTO.getEmail(), userDTO.getSenha());
		repository.save(user);
	}

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) {
		Users user = repository.findByEmail(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Usuário " + username + " não encontrado!");
		}

		return user;
	}
}
