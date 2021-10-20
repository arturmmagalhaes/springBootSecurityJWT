package com.docs;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.docs.entities.Authority;
import com.docs.entities.Users;
import com.docs.repositories.UserDetailsRepository;

@SpringBootApplication
public class DocsApplication {

	@Autowired
	private UserDetailsRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(DocsApplication.class, args);
	}

	@PostConstruct
	protected void init() {
		List<Authority> authorityList  = new ArrayList<>();
		
		authorityList.add(createAuthority("USER", "User Role"));
		authorityList.add(createAuthority("ADMIN", "Admin Role"));
		
		Users user = new Users();
		user.setNome("Admin");
		user.setEmail("admin@admin");
		user.setSenha(passwordEncoder.encode("admin"));
		user.setAuthorities(authorityList);
		userRepository.save(user);
	}
	
	private Authority createAuthority(String roleCode, String roleDescription) {
		Authority authority = new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}
}
