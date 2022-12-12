package com.foodDelivery.demo.Controller;

import com.foodDelivery.demo.Model.CartItem;
import com.foodDelivery.demo.Model.Food;
import com.foodDelivery.demo.Model.User;
import com.foodDelivery.demo.Service.CartItemService;
import com.foodDelivery.demo.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CartController {

    @Autowired
    CartItemService cartItemService;

    @GetMapping("/cart")
    public List<Food> getCartItems(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        return cartItemService.getAllItems(user);
    }

    @PostMapping("/addToCart/{foodId}")
    public void addCart(@PathVariable int foodId, @RequestParam("quantity") int quantity){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        cartItemService.addToCart(foodId, quantity, user);
    }
    @DeleteMapping("/cart/deleteItem/{id}")
    public void removeItem(@PathVariable int id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        cartItemService.deleteCartItem(id, user);
    }
}
