package com.kodilla.ecommercee.domain;


import com.kodilla.ecommercee.entity.Product;
import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long cartId;
    private List<Product> products;
    private Long userId;
}