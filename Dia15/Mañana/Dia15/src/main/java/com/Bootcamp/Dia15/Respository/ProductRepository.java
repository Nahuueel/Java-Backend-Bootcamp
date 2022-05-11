package com.Bootcamp.Dia15.Respository;

import java.util.ArrayList;

import com.Bootcamp.Dia15.Model.ProductModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel,String> {
    ArrayList<ProductModel> getProductsByName(String name);
}
