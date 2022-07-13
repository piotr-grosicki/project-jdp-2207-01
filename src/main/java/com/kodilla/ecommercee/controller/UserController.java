package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.entity.User;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public static ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<UserDto> blockUser(@RequestBody UserDto userDto) {
        User savedUser = userRepository.save(userMapper.mapToUser(userDto));

        return ResponseEntity.ok(userMapper.mapToUserDto(savedUser));
    }

    @PutMapping(value = "key/{userId}")
    public ResponseEntity<UserDto> generateKey(@PathVariable Long userId) {
        return ResponseEntity.ok(new UserDto(
                1L, "user2", "David",
                "Plumber", "david.plumber@example.com", "address2"));
    }
}
