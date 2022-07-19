package com.kodilla.ecommercee.entity;


import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UserEntityTestSuite {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testSaveUserandFindUserById() {

       User james = new User(1L,"JamesH","James","Howe","jameshowe@gmail.com","Chicago", true, new ArrayList<>());
       User steve = new User(2L,"SteveB","Steve","Bowie","stevebowie@gmail.com","Tampa", true, new ArrayList<>());


       userRepository.save(james);
       userRepository.save(steve);

       Long jamesId = james.getId();
       Long steveId = steve.getId();
       Optional <User> existingUser = userRepository.findById(jamesId);
       Optional <User> existingUser1 = userRepository.findById(steveId);

       assertEquals(1L, existingUser.get().getId());
       assertEquals(2L, existingUser1.get().getId());

       assertTrue(existingUser.isPresent());
       assertTrue(existingUser1.isPresent());

       assertNotNull(existingUser.get().getId());
       assertNotNull(existingUser1.get().getId());

       userRepository.deleteAll();
         }

    @Test
    public void testFindAll() {

        User james = new User(11L,"JamesW","James","Howe","jameshowe@gmail.com","Chicago", true, new ArrayList<>());
        User steve = new User(21L,"SteveB","Steve","Bowie","stevebowie@gmail.com","Tampa", true, new ArrayList<>());
        User adam = new User(31L,"AdamW","Adam","Wolf","adamwolf@gmail.com","Brooklyn", true, new ArrayList<>());
        User john = new User(41L,"JohnW","John","Smith","johnSmith@gmail.com","Brooklyn", true, new ArrayList<>());


        userRepository.save(james);
        userRepository.save(steve);
        userRepository.save(adam);
        userRepository.save(john);

        List <User> findAllUsersList = userRepository.findAll();

        assertEquals(4,findAllUsersList.size());

        userRepository.deleteAll();

            }

    @Test
    public void testDeleteUserById() {

        User james = new User(9L,"JamesH","James","Howe","jameshowe@gmail.com","Chicago", true, new ArrayList<>());
        User steve = new User(15L,"SteveB","Steve","Bowie","stevebowie@gmail.com","Tampa", true, new ArrayList<>());

        userRepository.save(james);
        userRepository.save(steve);

        Long jamesId = james.getId();
        userRepository.deleteById(jamesId);

        List <User> findAllUsersList = userRepository.findAll();

        Optional <User> findById = userRepository.findById(jamesId);

        assertEquals(1,findAllUsersList.size());
        assertFalse(findById.isPresent());

        userRepository.deleteAll();

    }
    @Test
    public void testDeleteAll() {

        User james = new User(5L,"JamesH","James","Howe","jameshowe@gmail.com","Chicago", true, new ArrayList<>());
        User steve = new User(6L,"SteveB","Steve","Bowie","stevebowie@gmail.com","Tampa", true, new ArrayList<>());
        User adam = new User(7L,"AdamW","Adam","Wolf","adamwolf@gmail.com","Brooklyn", true, new ArrayList<>());
        User john = new User(8L,"JohnW","John","Smith","johnSmith@gmail.com","Brooklyn", true, new ArrayList<>());

        userRepository.save(james);
        userRepository.save(steve);
        userRepository.save(adam);
        userRepository.save(john);

        userRepository.deleteAll();

        List <User> findAllUsersList = userRepository.findAll();

        assertEquals(0,findAllUsersList.size());

        userRepository.deleteAll();

    }

 }

