package com.foodDelivery.demo.Controller;

import com.foodDelivery.demo.Model.Role;
import com.foodDelivery.demo.Model.User;
import com.foodDelivery.demo.Repository.RoleRepository;
import com.foodDelivery.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public ResponseEntity<HttpStatus> login(@RequestBody User user) throws Exception {

        UsernamePasswordAuthenticationToken authreq = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
        Authentication auth = authenticationManager.authenticate(authreq);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        if (sc.getAuthentication().isAuthenticated()){
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } else {
            throw new Exception("Invalid credentials");
        }
    }
    @PostMapping("/register")
    public void registerUser(@RequestBody User user, HttpServletRequest request) throws ServletException {
        Optional<User> exists = userRepository.findByEmail(user.getEmail());
        if (exists.isPresent()){
            throw new ServletException("User email already exists");
        }else {
            String password = user.getPassword();
            user.setPassword(bCryptPasswordEncoder.encode(password));
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findById(2).get());
            userRepository.save(user);
            request.login(user.getEmail(), password);
        }
    }
}
