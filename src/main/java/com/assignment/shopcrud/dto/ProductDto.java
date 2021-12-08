package com.assignment.shopcrud.dto;

import com.assignment.shopcrud.entity.Product;
import com.assignment.shopcrud.ulti.ObjectUlti;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    @Id
    private int id;
    private String name;
    private int price;
    private int quantity;
    private String description;
    private int category_id;

    public ProductDto (Product product){
        ObjectUlti.cloneObject(this,product);
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        quantity = product.getQuantity();
        description = product.getDescription();
        category_id = product.getCategory_id();
    }
}
