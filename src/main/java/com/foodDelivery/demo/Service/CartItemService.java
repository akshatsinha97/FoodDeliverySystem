package com.foodDelivery.demo.Service;

import com.foodDelivery.demo.Exception.CartItemNotExistException;
import com.foodDelivery.demo.Model.CartItem;
import com.foodDelivery.demo.Model.Food;
import com.foodDelivery.demo.Model.User;
import com.foodDelivery.demo.Repository.CartItemRepository;
import com.foodDelivery.demo.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    FoodRepository foodRepository;

    public List<Food> getAllItems(User user) {
        Optional<CartItem> cartItem = cartItemRepository.findByid(user.getId());
        if (cartItem.isPresent())
            return cartItem.get().getFoods();
        else {
            return null;
        }
    }

    public void addToCart(int id, int quantity, User user){
        Optional<CartItem> cartItem = cartItemRepository.findByid(user.getId());
        // when cart for a specific user is not already present
        if (!cartItem.isPresent()){
            CartItem cart1 = new CartItem();
            cart1.setQuantity(quantity);
            List<Food> f = new ArrayList<>();
            f.add(foodRepository.findById(id).get());
            cart1.setFoods(f);
            cart1.setUser(user);
            cartItemRepository.save(cart1);
        }
        // when cart for a specific user is present
        else{
            for(Food food: cartItem.get().getFoods()){
                // when the cart-item/food is already present in the cart
                if (id == food.getId()){
                    cartItem.get().setQuantity(cartItem.get().getQuantity() + quantity);
                }
                // when the cart-item/food is not present in the cart
                else{
                    cartItem.get().getFoods().add(foodRepository.findById(id).get());
                    cartItem.get().setFoods(cartItem.get().getFoods());
                    cartItem.get().setQuantity(cartItem.get().getQuantity() + quantity);
                }
            cartItemRepository.save(cartItem.get());
            }
        }
    }
    public void deleteCartItem(int id, User user) throws CartItemNotExistException {
        Optional<CartItem> cartItem = cartItemRepository.findByid(user.getId());
        for (Food f: cartItem.get().getFoods()) {
            if (id == f.getId()) {
                cartItem.get().getFoods().remove(f);
            }
        }
    }
//        Cart cart = getAddToCartFromDto(addToCartDto,userId);
//        cartRepository.save(cart);

//    public void addToCart(int id){
//        List<Food> foods
//        List<Food> foods = new ArrayList<>();
//        foods.add(foodRepository.findById(id).get());
//    }
}
