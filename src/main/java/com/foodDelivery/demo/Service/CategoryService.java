package com.foodDelivery.demo.Service;

import com.foodDelivery.demo.Model.Category;
import com.foodDelivery.demo.Model.Food;
import com.foodDelivery.demo.Repository.CategoryRepository;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public List<Food> getFoods(int id){
        return categoryRepository.findAllByid(id);
    }

    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    public Optional<Category> getCategoryById(int id){
        return categoryRepository.findById(id);
    }

    public void removeById(int id){
        categoryRepository.deleteById(id);
    }

//    private CategoryDTO mapToDTO(Category category){
//        CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
//        return categoryDTO;
//    }
//
//    private Category mapToCategory(CategoryDTO categoryDTO){
//        Category category = modelMapper.map(categoryDTO, Category.class);
//        return category;
//    }
}
