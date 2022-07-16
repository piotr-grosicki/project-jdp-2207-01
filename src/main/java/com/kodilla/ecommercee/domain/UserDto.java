package com.kodilla.ecommercee.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private boolean isActive;
}
