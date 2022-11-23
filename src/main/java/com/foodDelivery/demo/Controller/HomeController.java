package com.foodDelivery.demo.Controller;

import com.foodDelivery.demo.Model.Category;
import com.foodDelivery.demo.Model.Food;
import com.foodDelivery.demo.Service.CategoryService;
import com.foodDelivery.demo.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @GetMapping("/admin/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategory();
    }
    @GetMapping("/foods")
    public List<Food> getAllFoods() {
        return foodService.getAllFood();
    }
//    @GetMapping({"/","/home"})
//    public String Home(Model model){
//        model.addAttribute("allCategory", categoryService.getAllCategory());
//        model.addAttribute("allFoods", foodService.getAllFood());
//        return "home";
//    }
    @GetMapping("/home/categories/{id}")
    public List<Food> category(@PathVariable int id){
        return categoryService.getFoods(id);
    }
    @GetMapping("/home/foods/foodItem/{id}")
    public Food foodDisplay(@PathVariable int id) {
        Optional<Food> food = foodService.getFoodById(id);
        if (food.isPresent()) {
            return food.get();
        }
        return null;
    }
}
