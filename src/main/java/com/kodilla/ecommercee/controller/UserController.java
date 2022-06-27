package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/users")
public class UserController {

    @PostMapping(value = "createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(UserDto userDto) {
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "block")
    public ResponseEntity<UserDto> blockUser(UserDto userDto) {
        return ResponseEntity.ok(new UserDto(
                1L, "user1", "John",
                "Smith", "john.smith@example.com", "address1", 1234, false));
    }

    @PutMapping(value = "key")
    public ResponseEntity<UserDto> generateKey(UserDto userDto) {
        return ResponseEntity.ok(new UserDto(
                1L, "user2", "David",
                "Plumber", "david.plumber@example.com", "address2", 4321, false));
    }
}
