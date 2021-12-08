package com.assignment.shopcrud.Service;

import com.assignment.shopcrud.entity.Product;
import com.assignment.shopcrud.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        this.productRepo.save(product);
    }

    @Override
    public Product getUpdateProduct(int id) {
        Product product = productRepo.findById(id).get();
        return product;
    }

    @Override
    public void deleteProduct(int id) {
        this.productRepo.deleteById(id);
    }

    @Override
    public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.productRepo.findAll(pageable);
    }
}
