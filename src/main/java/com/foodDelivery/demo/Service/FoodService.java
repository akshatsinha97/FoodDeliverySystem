package com.foodDelivery.demo.Service;

import com.foodDelivery.demo.Model.Category;
import com.foodDelivery.demo.Model.Food;
import com.foodDelivery.demo.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public List<Food> getAllFood(){
        return foodRepository.findAll();
    }

    public void addFood(Food food){
        foodRepository.save(food);
    }

    public Optional<Food> getFoodById(int id){
        return foodRepository.findById(id);
    }

    public void removeById(int id){
        foodRepository.deleteById(id);
    }
}
