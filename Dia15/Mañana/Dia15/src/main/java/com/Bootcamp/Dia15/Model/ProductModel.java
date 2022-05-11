package com.Bootcamp.Dia15.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Products")
public class ProductModel {
    
    @Id
    @NotBlank
    @Size(max = 30)
    @Column(name = "code")
    private String code;

    @NotBlank
    @Size(max = 30)
    @Column (name = "name")
    private String name;

    @NotBlank
    @Size(max = 10)
    @Column(name = "ammount")
    private int amount;

    @NotBlank
    @Size(max = 10)
    @Column(name = "price")
    private float price;


    public ProductModel(){}

    public ProductModel(String code, String name, int amount, float price) {
        this.code = code;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }


    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
}
