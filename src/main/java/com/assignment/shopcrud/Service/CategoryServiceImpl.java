package com.assignment.shopcrud.Service;

import com.assignment.shopcrud.dto.CategoryDto;
import com.assignment.shopcrud.entity.Category;
import com.assignment.shopcrud.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public void saveCategory(Category category) {
        this.categoryRepo.save(category);
    }

    @Override
    public Category getUpdateCategory(int id) {
        Category category = categoryRepo.findById(id).get();
        return category;
    }

    @Override
    public void deleteCategory(int id) {
        this.categoryRepo.deleteById(id);
    }

}
