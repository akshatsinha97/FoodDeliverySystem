package com.foodDelivery.demo.Controller;

import com.foodDelivery.demo.Model.Category;
import com.foodDelivery.demo.Model.Food;
import com.foodDelivery.demo.Service.CategoryService;
import com.foodDelivery.demo.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FoodService foodService;

    @GetMapping({"/","/home"})
    public String Home(Model model){
        model.addAttribute("allCategory", categoryService.getAllCategory());
        model.addAttribute("allFoods", foodService.getAllFood());
        return "home";
    }
    @GetMapping("/home/categories/{category}")
    public String category(@PathVariable Category category, Model model){
        List<Food> foods = categoryService.getFoods(category.getId());
        model.addAttribute("foods", foods);
        return "foodsByCategory";
    }
    @GetMapping("/home/foods/foodItem/{id}")
    public String foodDisplay(@PathVariable int id, Model model){
        Optional<Food> food = foodService.getFoodById(id);
        if (food.isPresent()) {
            model.addAttribute("food", food);
            return "foodDisplay";
        } else {
            return "error 404";
        }
    }
}
