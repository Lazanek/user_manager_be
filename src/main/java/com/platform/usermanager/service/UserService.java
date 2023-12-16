package com.platform.usermanager.service;

import com.platform.usermanager.dto.UserRegistrationDto;
import com.platform.usermanager.model.User;
import com.platform.usermanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setUsername(userRegistrationDto.username());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.password()));
        user.setEmail(userRegistrationDto.email());

        return userRepository.save(user);
    }
}
