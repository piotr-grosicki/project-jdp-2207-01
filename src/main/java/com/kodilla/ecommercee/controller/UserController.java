package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/users")
public class UserController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "block/{userId}")
    public ResponseEntity<UserDto> blockUser(@PathVariable Long userId) {
        return ResponseEntity.ok(new UserDto(
                1L, "user1", "John",
                "Smith", "john.smith@example.com", "address1", 1234, false));
    }

    @PutMapping(value = "key/{userId}")
    public ResponseEntity<UserDto> generateKey(@PathVariable Long userId) {
        return ResponseEntity.ok(new UserDto(
                1L, "user2", "David",
                "Plumber", "david.plumber@example.com", "address2", 4321, false));
    }
}
