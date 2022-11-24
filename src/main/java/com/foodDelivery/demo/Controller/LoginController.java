package com.foodDelivery.demo.Controller;

import com.foodDelivery.demo.Model.User;
import com.foodDelivery.demo.Repository.RoleRepository;
import com.foodDelivery.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/home/login")
    public String loginUser(@RequestBody User user){
        return "login";
    }
    @GetMapping("/home/register")
    public String registerUser(User user){
        return "register";
    }

}
