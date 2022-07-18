package com.kodilla.ecommercee.controller.service;

import com.kodilla.ecommercee.entity.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

        @Autowired
        GroupRepository groupRepository;

        public List<Group> getGroups() {
            return groupRepository.findAll();
        }

        public Group addGroup(Group group) {
            return groupRepository.save(group);
        }

        public Optional<Group> getGroup(long groupId) {
            return groupRepository.findById(groupId);
        }

        public Group updateGroup(Group group) {
            Optional <Group> groupToUpdate = groupRepository.findById(group.getId());
            long updatedGroupId = groupToUpdate.get().getId();
            String updatedGroupName = groupToUpdate.get().getName();

            return groupRepository.save(new Group(updatedGroupName,updatedGroupId));
        }

}
