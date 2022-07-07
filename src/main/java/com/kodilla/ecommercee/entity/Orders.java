package com.kodilla.ecommercee.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;



@Entity
@Table(name ="orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Orders {

    @Setter(AccessLevel.NONE)
    @Column(name = "order_id", nullable = false, unique = true)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @ManyToOne(optional = false)

    Carts cart;








}