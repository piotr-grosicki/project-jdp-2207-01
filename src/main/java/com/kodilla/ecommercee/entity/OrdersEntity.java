package com.kodilla.ecommercee.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrdersEntity {

    @Column(name="ORDER_ID", unique = true)
    @NotNull
    @GeneratedValue
    @Id
    @ManyToOne
    private CartsEntity cartEnity;
    BigInteger orderId;

    @Column(name="USER_ID", unique = false)
    @NotNull
    BigInteger  userId;
    @Column(name="DATE_ID", unique = false)
    @NotNull
    Date date;






}
