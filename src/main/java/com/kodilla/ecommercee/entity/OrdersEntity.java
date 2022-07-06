package com.kodilla.ecommercee.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrdersEntity {

    @Column(name="order_id", unique = true)
    @NotNull
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    @ManyToOne


   // private CartsEntity cartEnity;
    BigInteger orderId;

    @Column(name="user_id
    BigInteger  userId;
    @Column(name="date_id", unique = false)
    @NotNull
    Date date;






}
