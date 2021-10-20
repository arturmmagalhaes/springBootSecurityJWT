package com.docs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docs.entities.Users;

public interface UserDetailsRepository extends JpaRepository<Users, Long> {

	Users findByEmail(String email);

}
