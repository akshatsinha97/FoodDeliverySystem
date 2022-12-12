package com.foodDelivery.demo.Repository;

import com.foodDelivery.demo.Model.CartItem;
import com.foodDelivery.demo.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    Optional<CartItem> findByid(int id);
}
