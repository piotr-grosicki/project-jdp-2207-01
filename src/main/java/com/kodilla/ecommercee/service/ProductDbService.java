package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.controller.ProductNotFoundException;
import com.kodilla.ecommercee.entity.Product;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDbService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(final Long productId) throws ProductNotFoundException {
        return productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
    }

    public Product createProduct(final Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(final Long productId) {
        productRepository.deleteById(productId);
    }
}