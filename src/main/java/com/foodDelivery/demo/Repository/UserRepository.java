package com.foodDelivery.demo.Repository;

import com.foodDelivery.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByusername(String username);
    Optional<User> findByUsernameOrEmail(String username, String email);
}