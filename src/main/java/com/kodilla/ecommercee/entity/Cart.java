package com.kodilla.ecommercee.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "cart")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cart {


    //@Column(name = "cart_id", unique = true)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long carts_id;
    // @ManyToMany(mappedBy = "product")
   // private list<Product> product;

    @OneToMany
    @JoinColumn(name = "orders_id")
    private List<Order> order;


    @Column(name = "user_id")
    @NotNull
    private BigInteger userID;


}