package com.foodDelivery.demo.Repository;

import com.foodDelivery.demo.Model.Category;
import com.foodDelivery.demo.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Food> findAllByCategoryId(int id);
}
