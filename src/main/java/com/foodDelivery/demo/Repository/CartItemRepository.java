package com.foodDelivery.demo.Repository;

import com.foodDelivery.demo.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    Optional<CartItem> findByid(int id);
}
