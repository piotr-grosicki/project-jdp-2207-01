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

@Entity
@Table(name="carts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartsEntity {


    @Column(name="cart_id", unique = true)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
   @OneToMany//(cascade={CascadeType.MERGE,
        //        CascadeType.PERSIST},
        //  fetch = FetchType.EAGER,
       //    targetEntity = OrdersEntity.class)
         //  mappedBy = "cartEnity")

    // BigInteger cartId;



    @Column(name="user_id", unique = false)
    @NotNull
   private BigInteger userID;

    @Column(name="date_id_ID", unique = false)
    @NotNull
   private Date date;





}
