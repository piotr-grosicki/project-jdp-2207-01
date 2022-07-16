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
    //@NotNull
    @Column(name = "cart_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cart_id;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "carts")
    private List<Product> products;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Order> orders;


    @Column(name = "user_id")
    //@NotNull
    private Long userID;


}