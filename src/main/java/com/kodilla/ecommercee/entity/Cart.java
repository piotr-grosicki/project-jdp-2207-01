package com.kodilla.ecommercee.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Entity
@Table(name = "cart")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cart {

    @Id
    @NotNull
    @Column(name = "cart_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "carts")
    private List<Product> products;

    @OneToMany(mappedBy = "cart")
    private List<Order> orders;

    @ManyToOne
    private User user;

}