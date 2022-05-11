package com.Bootcamp.Dia15.Service;

import java.util.ArrayList;
import java.util.Optional;

import com.Bootcamp.Dia15.Model.ProductModel;
import com.Bootcamp.Dia15.Respository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<ArrayList<ProductModel>> getAllProducts(){
        try {
            ArrayList<ProductModel> product = new ArrayList<ProductModel>();
            productRepository.findAll().forEach(product::add);
            if (product.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Optional<ProductModel>>getProductByCode(String code) {
        try {
            Optional<ProductModel> product = productRepository.findById(code);
            if (product.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ArrayList<ProductModel>>getProductsByName(String name) {
        try {
            ArrayList<ProductModel> customer = productRepository.getProductsByName(name);
            if (customer.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ProductModel> registerProduct(ProductModel productBody) {
        try {
            if(this.getProductByCode(productBody.getCode()) != null){
                return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
            }
            ProductModel product = productRepository.save(productBody);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity deleteProductByCode(String code) {
        try {
            productRepository.deleteById(code);
            Optional<ProductModel> product = productRepository.findById(code);
            if (product.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
