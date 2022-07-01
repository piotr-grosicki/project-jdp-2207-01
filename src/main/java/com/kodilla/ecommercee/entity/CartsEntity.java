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
@Table(name="CARTS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartsEntity {


    @Column(name="CART_ID", unique = true)
    @NotNull
    @GeneratedValue
    @Id
    //@OneToMany(cascade=CascadeType.ALL,
  //          fetch = FetchType.EAGER,
  //          targetEntity = OrdersEntity.class,
  //          mappedBy = "cartEnity")

     BigInteger cartId;



    @Column(name="USER_ID", unique = false)
    @NotNull
   private BigInteger userID;

    @Column(name="DATE_ID", unique = false)
    @NotNull
   private Date date;





}
