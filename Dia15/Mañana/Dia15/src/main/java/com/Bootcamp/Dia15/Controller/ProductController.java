package com.Bootcamp.Dia15.Controller;

import java.util.ArrayList;
import java.util.Optional;

import com.Bootcamp.Dia15.Model.ProductModel;
import com.Bootcamp.Dia15.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/products")
@Api(value = "Controller Products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<ArrayList<ProductModel>> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{code}")
    public ResponseEntity<Optional<ProductModel>> getProductByCode(@PathVariable("code") String code) {
        if(code == null ^ (code.length()<=0 ^ code.length() >8)){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return productService.getProductByCode(code);
    }

    @GetMapping("/{name}")
    public ResponseEntity<ArrayList<ProductModel>> getProductByName(@PathVariable("name") String name) {
        if(name == null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return productService.getProductsByName(name);
    }

    @PostMapping("/product")
    public ResponseEntity<ProductModel> registerProduct(@RequestBody ProductModel productBody) {
        if(productBody.getCode() == null ^
          (productBody.getCode().length()<=0 ^ productBody.getCode().length() >8)){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return productService.registerProduct(productBody);
    }

    @PutMapping("/product")
    public ResponseEntity<ProductModel> modifyProduct(@RequestBody ProductModel productBody) {
        if(productBody.getCode() == null ^
                (productBody.getCode().length()<=0 ^ productBody.getCode().length() >8)){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return productService.registerProduct(productBody);
    }

    @DeleteMapping("/product/{code}")
    public ResponseEntity deleteProduct(@PathVariable("code") String code){
        if(code == null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        if(code.length()<=0 ^ code.length() >8){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return productService.deleteProductByCode(code);
    }
}
