package com.assignment.shopcrud.repository;

import com.assignment.shopcrud.dto.CategoryDto;
import com.assignment.shopcrud.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
