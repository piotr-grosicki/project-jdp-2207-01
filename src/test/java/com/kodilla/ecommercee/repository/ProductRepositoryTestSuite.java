package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.Group;
import com.kodilla.ecommercee.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class ProductRepositoryTestSuite {

//    @Autowired
//    ProductRepository productRepository;
//    @Autowired
//    GroupRepository groupRepository;
//
//    @Test
//    public void saveProduct() {
//        Given
//        Product product = Product.builder().productName("cheese").build();
//
//        When
//        productRepository.save(product);
//
//        Then
//        assertEquals("cheese", product.getProductName());
//        assertNotNull(product.getProductId());
//
//        CleanUp
//        productRepository.deleteById(product.getProductId());
//    }
//
//    @Test
//    public void findProductById() {
//        Given
//        Product product = Product.builder().productName("cheese").build();
//
//        When
//        productRepository.save(product);
//        Long id = product.getProductId();
//        Optional<Product> result = productRepository.findById(id);
//
//        Then
//        assertNotNull(result);
//
//        CleanUp
//        productRepository.deleteById(id);
//    }

//    @Test
//    public void findProductGroup() {
//        Given
//        Group breadstuff = Group.builder().name("breadstuff").products(new ArrayList<>()).build();
//        Product product = Product.builder().productName("bread").group(breadstuff).build();
//
//        When
//        groupRepository.save(breadstuff);
//        productRepository.save(product);
//
//        String groupName = product.getGroup().getName();
//
        //Then
//        assertEquals("breadstuff", groupName);
//
//        CleanUp
//        productRepository.deleteById(product.getProductId());
//        groupRepository.deleteById(breadstuff.getId());
//    }
}