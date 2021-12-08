package com.assignment.shopcrud.controller;

import com.assignment.shopcrud.Service.CategoryService;
import com.assignment.shopcrud.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/Admin/Category")
    public String viewCategory (Model model) {
        model.addAttribute("lsCategory", categoryService.getAllCategories());
        return "category";
    }

    @GetMapping("/Admin/Category/Add")
    public String showNewCategoryForm(@Valid Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "add_category";
    }

    @PostMapping("/Admin/Category/Save")
    public String saveCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "add_category";
        }
        categoryService.saveCategory(category);
        return "redirect:/Admin/Category";
    }

    @GetMapping("/Admin/Category/Update/{id}")
    public String showUpdateCategoryForm(@PathVariable(value = "id") int id,@Valid Model model) {
        Category category = categoryService.getUpdateCategory(id);
        model.addAttribute("category", category);
        return "update_category";
    }

    @GetMapping("/Admin/Category/Delete/{id}")
    public String deleteCategory(@PathVariable(value = "id") int id){
        this.categoryService.deleteCategory(id);
        return "redirect:/Admin/Category";
    }
}
