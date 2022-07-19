package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMapper {

    public ProductDto mapToProductDto(Product product) {
        ProductDto productDto = ProductDto
                .builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .build();
        return productDto;
    }
    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }
}
