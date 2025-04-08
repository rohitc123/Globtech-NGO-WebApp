package com.example.NGOWebApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.NGOWebApp.model.Role;
import com.example.NGOWebApp.model.User;
import com.example.NGOWebApp.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // No @Autowired, use constructor

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

	

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(u -> org.springframework.security.core.userdetails.User
                                 .withUsername(u.getUsername())
                                 .password(u.getPassword())
                                 .roles(u.getRole().name())
                                 .build())
                   .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public void saveUser(String username, String password, Role role) {
    	User user = new User();
    	 user.setUsername(username);
    	 user.setPassword(passwordEncoder.encode(password));
    	 user.setRole(role);
    	 userRepository.save(user);

    }
	
}
