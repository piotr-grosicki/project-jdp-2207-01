package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductRepositoryTestSuite {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void saveProduct() {
        //Given
        Product product = Product.builder().productName("cheese").build();

        //When
        productRepository.save(product);

        //Then
        assertEquals("cheese", product.getProductName());
        assertNotNull(product.getProductId());

        //CleanUp
        productRepository.deleteById(product.getProductId());
    }

    @Test
    public void findProductById() {
        //Given
        Product product = Product.builder().productName("cheese").build();

        //When
        productRepository.save(product);
        Long id = product.getProductId();
        Optional<Product> result = productRepository.findById(id);

        //Then
        assertNotNull(result);
    }
}