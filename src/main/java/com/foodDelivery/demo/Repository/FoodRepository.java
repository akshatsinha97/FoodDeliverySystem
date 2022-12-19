package com.foodDelivery.demo.Repository;

import com.foodDelivery.demo.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
}