package com.assignment.shopcrud.Service;

import com.assignment.shopcrud.entity.Category;
import com.assignment.shopcrud.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    void saveProduct(Product product);
    Product getUpdateProduct(int id);
    void deleteProduct(int id);
    Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
