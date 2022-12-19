package com.foodDelivery.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @Column(name = "CategoryId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "categoryName")
    private String name;

    @Column(name = "foodCount")
    private int foodCount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Food> foods;
}
