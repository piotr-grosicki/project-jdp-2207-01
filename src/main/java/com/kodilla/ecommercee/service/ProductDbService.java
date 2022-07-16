package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.entity.Product;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductDbService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(final Long productId) {
        return productRepository.findById(productId);
    }

    public Product createProduct(final Product product) {
        return productRepository.save(product);
    }
}