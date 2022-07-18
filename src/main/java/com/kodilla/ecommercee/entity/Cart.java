package com.kodilla.ecommercee.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "cart")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cart {

    @Id
    @NotNull
    @Column(name = "cartId", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cart_id;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "carts")
    private List<Product> product;

    @OneToMany
    @JoinColumn(name = "orderId")
    private List<Order> order;


    @Column(name = "userId")
    @NotNull
    private Long userID;




}