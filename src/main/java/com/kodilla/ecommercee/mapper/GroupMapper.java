package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.entity.Group;
import org.springframework.stereotype.Service;

@Service
public class GroupMapper {

    public Group mapToGroup (final GroupDto groupDto) {
        return new Group(groupDto.getGroupName(),
                groupDto.getGroupId()
        );
    }

    public GroupDto mapToGroupDto(final Group group) {
        return new GroupDto(group.getName(),
                group.getId()
        );
    }

}
