package com.easyinterviewtracker.service;

import com.easyinterviewtracker.domain.User;
import com.easyinterviewtracker.dto.UserDTO;
import com.easyinterviewtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserById(Long id){
        return this.userRepository.findUserById(id)
                    .orElseThrow(() -> new RuntimeException("User not found."));
    }

    public List<User> findAllUsers(){
        return this.userRepository.findAll();
    }

    public User saveUser(User user){
        return this.userRepository.save(user);
    }

    public User createUser(UserDTO userDTO){
        User newUser = new User(userDTO);
        return this.userRepository.save(newUser);
    }
}
