package com.foodDelivery.demo.Controller;

import com.foodDelivery.demo.Entity.User;
import com.foodDelivery.demo.Repository.RoleRepository;
import com.foodDelivery.demo.Repository.UserRepository;
import com.foodDelivery.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@Controller
public class LoginController {


    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;
//    @PostMapping("/login")
//    public ResponseEntity<HttpStatus> login(@RequestBody User user) throws Exception {
//
//        Authentication authObject = null;
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
//            SecurityContextHolder.getContext().setAuthentication(authObject);
//        } catch (BadCredentialsException e) {
//            throw new Exception("Invalid credentials");
//        }
//
//        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
//    }
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user, HttpServletRequest request) throws ServletException {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/register").toUriString());
        user.getRoles().add(roleRepository.findByname("User"));
        return ResponseEntity.created(uri).body(userService.saveUser(user));
        }

}
