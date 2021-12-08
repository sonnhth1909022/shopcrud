package com.assignment.shopcrud.Service;

import com.assignment.shopcrud.dto.CategoryDto;
import com.assignment.shopcrud.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void saveCategory(Category category);
    Category getUpdateCategory(int id);
    void deleteCategory(int id);
}
