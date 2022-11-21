package com.foodDelivery.demo.Controller;

import com.foodDelivery.demo.Model.Category;
import com.foodDelivery.demo.Model.Food;
import com.foodDelivery.demo.Service.CategoryService;
import com.foodDelivery.demo.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FoodService foodService;

    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getAllCategories(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        return "categories";
    }

    @GetMapping("/admin/Categories/add")
    public  String fillCategory(Model model){
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @PostMapping("/admin/Categories/add")
    public String postCategory(@ModelAttribute("category") Category category){
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @PostMapping("/admin/updateCategory/{id}")
    public String updateCategory(@PathVariable int id, Model model){
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()){
            model.addAttribute("category", category.get());
            return "categoriesAdd";
        } else {
            return "error 404";
        }
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCategory(@PathVariable int id){
        categoryService.removeById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/foods")
    public String getAllFoods(Model model) {
        model.addAttribute("foods", foodService.getAllFood());
        return "foods";
    }

    @GetMapping("/admin/foods/add")
    public String postFood(Model model){
        model.addAttribute("food", new Food());
        return "foodAdd";
    }

    @PostMapping("/admin/foods/add")
    public String postFood(@ModelAttribute("food") Food food){
        foodService.addFood(food);
        return "redirect:/admin/foods";
    }

    @PostMapping("/admin/foods/updateFood/{id}")
    public String updateFood(@PathVariable int id, Model model){
        Optional<Food> food = foodService.getFoodById(id);
        if (food.isPresent()){
            model.addAttribute("food", food.get());
            return "/admin/foods";
        } else {
            return "error 404";
        }
    }
    @GetMapping("/admin/foods/delete/{id}")
    public String deleteFood(@PathVariable int id){
        foodService.removeById(id);
        return "redirect:/admin/foods";
    }

}
