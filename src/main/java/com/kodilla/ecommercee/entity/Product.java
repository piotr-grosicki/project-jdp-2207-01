package com.kodilla.ecommercee.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Long productId;

    @Column(name = "productName")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private Group group;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cart_has_product",
            joinColumns = {@JoinColumn(name = "productId", referencedColumnName = "productId")},
            inverseJoinColumns = {@JoinColumn(name = "cartId", referencedColumnName = "cartId")}
    )
    private List<Cart> carts;
}