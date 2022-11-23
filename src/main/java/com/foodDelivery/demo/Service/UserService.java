package com.foodDelivery.demo.Service;

import com.foodDelivery.demo.Model.User;
import com.foodDelivery.demo.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public int findUserId(User user){
        return userRepository.
    }
    public Optional<User> findUser(int id){
        return userRepository.findById(id);
    }
}
