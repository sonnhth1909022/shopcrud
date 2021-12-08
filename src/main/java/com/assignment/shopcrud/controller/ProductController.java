package com.assignment.shopcrud.controller;

import com.assignment.shopcrud.Service.CategoryService;
import com.assignment.shopcrud.Service.ProductService;
import com.assignment.shopcrud.entity.Category;
import com.assignment.shopcrud.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/Admin/Product")
    public String viewProduct (Model model) {
        return findPaginated(1, "name", "asc", model);
    }

    @GetMapping("/Admin/Product/Add")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "add_product";
    }

    @PostMapping("/Admin/Product/Save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "add_product";
        }
        productService.saveProduct(product);
        return "redirect:/Admin/Product";
    }

    @GetMapping("/Admin/Product/Update/{id}")
    public String showUpdateProductForm(@PathVariable(value = "id") int id, Model model) {
        Product product = productService.getUpdateProduct(id);
        model.addAttribute("product", product);
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories",categories);
        return "update_product";
    }

    @GetMapping("/Admin/Product/Delete/{id}")
    public String deleteProduct(@PathVariable(value = "id") int id){
        this.productService.deleteProduct(id);
        return "redirect:/Admin/Product";
    }

    @GetMapping("page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, Model model){
        int pageSize = 5;
        Page<Product> page = productService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Product> products = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("products", products);
        return "product";

    }
}
