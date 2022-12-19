package com.foodDelivery.demo.Service;

import com.foodDelivery.demo.Entity.Role;
import com.foodDelivery.demo.Entity.User;
import com.foodDelivery.demo.Repository.RoleRepository;
import com.foodDelivery.demo.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to database", user.getFirstName());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        User user = userRepository.findByusername(username);
        Role role = roleRepository.findByname(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("fetching user {}", username);
        return userRepository.findByusername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("fetching all users");
        return userRepository.findAll();
    }
}
