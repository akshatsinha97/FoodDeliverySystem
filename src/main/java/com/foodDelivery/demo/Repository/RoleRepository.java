package com.foodDelivery.demo.Repository;

import com.foodDelivery.demo.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByname(String name);
}
