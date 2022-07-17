package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User mapToUser(UserDto userDto) {
        return new User(userDto.getUserId(),
                userDto.getUsername(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getAddress(),
                userDto.isActive()
        );
    }


    public UserDto mapToUserDto(User user) {
        return new UserDto(user.getId(),
                user.getName(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAddress(),
                user.isActive()
        );
    }
}
