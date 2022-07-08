package com.kodilla.ecommercee.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="cart")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Carts {


    //@Column(name = "carts_id", unique = true)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int carts_id;
    @OneToMany
    @JoinColumn(name  = "orders_id")
    private List<Orders> orders;


    @Column(name="user_id")
    @NotNull
   private BigInteger userID;







}