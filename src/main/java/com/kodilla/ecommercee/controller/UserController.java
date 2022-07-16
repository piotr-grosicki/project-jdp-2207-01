package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.service.KeyGenerator;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.entity.User;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final KeyGenerator keyGenerator;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<UserDto> blockUser(@RequestBody UserDto userDto) {
        if(userDto.isActive()){
            userDto.setActive(false);
            userRepository.save(userMapper.mapToUser(userDto));
            return ResponseEntity.ok(userMapper.mapToUserDto(userRepository.findById(userDto.getUserId()).get()));
        }
        else{
            return ResponseEntity.ok(userDto);
        }
    }

    @GetMapping (value = "key/{userId}")
    public String generateKey(@PathVariable Long userId) {
        User createdUser = userRepository.findById(userId).get();
        List<User> userList = userRepository.findAll();
        if(userList.contains(createdUser)) {
            return keyGenerator.activateKeyForTime();
        }
        else {
            return "wrong value";
        }
    }
}
