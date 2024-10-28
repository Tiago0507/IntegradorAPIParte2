package com.example.integradorapiparte2.controller;

import com.example.integradorapiparte2.entity.User;
import com.example.integradorapiparte2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("users/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {

        userRepository.save(user);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("users/list")
    public ResponseEntity<?> listUsers() {
        var users = userRepository.findAll();
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("users")
    public ResponseEntity<?> getUserByEmail(@RequestParam("email") String email) {
        Optional<User> optuser = userRepository.findUserByEmail(email);
        if(optuser.isPresent()) {
            var user = optuser.get();
            return ResponseEntity.status(200).body(user);
        }else {
            return ResponseEntity.status(404).body("User not found");
        }
    }
}
