package com.foodDelivery.demo.Model;

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
    @Column(name = "categoryId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "categoryName")
    private String name;

    @Column(name = "categoryCount")
    private int categoryCount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryId")
    private List<Food> foods;
}
