package com.quiz.service;

import java.util.Optional;

import com.quiz.dto.UserDTO;
import com.quiz.entity.User;
import com.quiz.exception.UserException;

import java.util.Optional;

public interface UserService {
    UserDTO addUser(UserDTO userDTO) throws UserException;
    UserDTO findUserById(Long id) throws UserException;
    UserDTO loginUser(UserDTO userDTO) throws UserException; // Use UserDTO for login as well
}

