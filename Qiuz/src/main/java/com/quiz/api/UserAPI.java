package com.quiz.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quiz.dto.UserDTO;
import com.quiz.exception.UserException;
import com.quiz.service.UserService;

@RestController
@RequestMapping("/users")
public class UserAPI {

    @Autowired
    private UserService userService;

    @Autowired
    private Environment environment;

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO) throws UserException {
        UserDTO newUser = userService.addUser(userDTO);
        String message = environment.getProperty("ADD_USER_MESSAGE", "User has been added with the id:") + newUser.getId();
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Long id) throws UserException {
        UserDTO user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginUser(@RequestBody UserDTO userDTO) throws UserException {
        UserDTO user = userService.loginUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
