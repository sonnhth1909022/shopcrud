package com.assignment.shopcrud.dto;

import com.assignment.shopcrud.entity.Category;
import com.assignment.shopcrud.ulti.ObjectUlti;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class CategoryDto {
//    @Id
    private int id;
    private String name;

    public CategoryDto (Category category){
        ObjectUlti.cloneObject(this, category);
        id  = category.getId();
        name = category.getName();
    }

}
