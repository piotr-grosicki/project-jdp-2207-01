package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GroupDto {

    private String groupName;
    private Long groupId;

    public GroupDto() {

    }
}
