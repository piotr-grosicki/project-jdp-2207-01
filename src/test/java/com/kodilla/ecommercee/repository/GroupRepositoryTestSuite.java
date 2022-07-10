package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.Group;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupRepositoryTestSuite {

    @Autowired
    GroupRepository groupRepository;

    @Test
    public void findAllGroupsTest() {
        //given & when
        List<Group> result = groupRepository.findAll();

        //then
        assertTrue(result.isEmpty());
    }

    @Test
    public void findTestByIdTest() {
        //given
        Group groupToSearch = groupRepository.save(Group.builder().name("test").build());

        //when
        Group result = groupRepository.findById(groupToSearch.getId()).get();

        //then
        assertEquals(groupToSearch.getName(), result.getName());
        assertNotNull(result.getId());
    }

    @Test
    public void saveGroupTest() {
        //given
        groupRepository.save(Group.builder().name("test").build());

        //when
        List<Group> result = groupRepository.findAll();

        //then
        assertNotNull(result);
    }

    @Test
    public void updateTestGroup() {
        //given
        String newName = "new name";
        Group groupToSave = groupRepository.save(Group.builder().name("Test").build());

        //when
        groupToSave.setName(newName);
        groupRepository.save(groupToSave);
        List<Group> groupList = groupRepository.findAll();

        //when
        assertEquals(newName, groupToSave.getName());
        assertEquals(1, groupList.size());
    }
}
