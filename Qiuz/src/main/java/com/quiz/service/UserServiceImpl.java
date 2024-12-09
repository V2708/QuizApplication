package com.quiz.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.quiz.dto.UserDTO;
import com.quiz.entity.User;
import com.quiz.exception.UserException;
import com.quiz.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Environment environment;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDTO addUser(UserDTO userDTO) throws UserException {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        user = userRepository.save(user);

        return new UserDTO(user.getId(), user.getUsername(), null, user.getEmail());
    }

    @Override
    public UserDTO findUserById(Long id) throws UserException {
        Optional<User> userOpt = userRepository.findById(id);

        if (userOpt.isEmpty()) {
            String errorMessage = String.format(environment.getProperty("USER_ID_NOT_FOUND"), id);
            throw new UserException(errorMessage);
        }

        User user = userOpt.get();
        return new UserDTO(user.getId(), user.getUsername(), null, user.getEmail()); 
    }

    @Override
    public UserDTO loginUser(UserDTO userDTO) throws UserException {
        User user = userRepository.findByUsername(userDTO.getUsername());

        if (user == null || !passwordEncoder.matches(userDTO.getPassword(), user.getPassword())) {
            throw new UserException(environment.getProperty("LOGIN_FAILED"));
        }

        return new UserDTO(user.getId(), user.getUsername(), null, user.getEmail());
    }
}
