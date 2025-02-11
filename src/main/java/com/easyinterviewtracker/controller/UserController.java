package com.easyinterviewtracker.controller;

import com.easyinterviewtracker.domain.User;
import com.easyinterviewtracker.dto.UserDTO;
import com.easyinterviewtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = this.userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDto){
        User newUser = this.userService.createUser(userDto);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
