package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.Group;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupRepositoryTestSuite {

    @Mock
    GroupRepository groupRepository;

    @Test
    public void testTest() {
        //given
        List<Group> groupList = new ArrayList<>();
        groupList.add(new Group(1l, "name"));
        groupList.add(new Group(2l, "name2"));

        when(groupRepository.findAll()).thenReturn(groupList);

        //when
        List<Group> result = groupRepository.findAll();

        //then
        assertEquals(2, result.size());
    }
}
