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

    @Column(name="order_id", unique = true)
    @NotNull
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
   // @ManyToOne


    // private CartsEntity cartEnity;
    BigInteger orderId;








}