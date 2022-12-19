package com.foodDelivery.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CartItemId")
    private int id;

    @Column(name = "FoodQuantity")
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Food.class)
    @JoinColumn(name="FoodId")
    private List<Food> foods;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserId")
    private User user;
}
