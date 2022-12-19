package com.foodDelivery.demo.Controller;

import com.foodDelivery.demo.Entity.Category;
import com.foodDelivery.demo.Entity.Food;
import com.foodDelivery.demo.Service.CategoryService;
import com.foodDelivery.demo.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {

    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/images";
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FoodService foodService;

//    @GetMapping("/admin")
//    public String adminHome(){
//        return "adminHome";
//    }

    @GetMapping("/admin/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategory();
    }

//    @GetMapping("/admin/Categories/add")
//    public  String fillCategory(Model model){
//        model.addAttribute("category", new Category());
//        return "categoriesAdd";
//    }

    @PostMapping("/admin/Categories/add")
    public void postCategory(@RequestBody Category category){
        categoryService.addCategory(category);
    }

    @PutMapping("/admin/updateCategory/{id}")
    public void updateCategory(@RequestBody Category newcategory, @PathVariable int id){
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            Category category1 = category.get();
            category1.setName(newcategory.getName());
            categoryService.addCategory(category1);
            }
        }

    @DeleteMapping("/admin/categories/delete/{id}")
    public void deleteCategory(@PathVariable int id){
        categoryService.removeById(id);
    }

    @GetMapping("/admin/foods")
    public List<Food> getAllFoods() {
        return foodService.getAllFood();
    }

//    @GetMapping("/admin/foods/add")
//    public String postFood(@RequestBody Food food){
//        model.addAttribute("food", new Food());
//        return "foodAdd";
//    }

    @PostMapping("/admin/foods/add")
    public void postFood(@RequestBody Food food, @RequestParam MultipartFile file,
                         @RequestParam("imgName")String imgName) throws IOException {
        String imageUUID;
        if(!file.isEmpty()){
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        }else {
            imageUUID = imgName;
        }
        food.setImageName(imageUUID);
        foodService.addFood(food);
    }

    @PutMapping("/admin/foods/updateFood/{id}")
    public void updateFood(@PathVariable int id,@RequestBody Food newfood){
        Optional<Food> food = foodService.getFoodById(id);
        if (food.isPresent()){
            Food food1 = food.get();
            food1.setName(newfood.getName());
            food1.setDescription(newfood.getDescription());
            food1.setPrice(newfood.getPrice());
            food1.setCategory(newfood.getCategory());
            food1.setImageName(newfood.getImageName());
        }
    }
    @DeleteMapping("/admin/foods/delete/{id}")
    public void deleteFood(@PathVariable int id){
        foodService.removeById(id);
    }
}
