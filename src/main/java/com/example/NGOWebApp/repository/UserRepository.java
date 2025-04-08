package com.example.NGOWebApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.NGOWebApp.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findByUsername(String username);

}
