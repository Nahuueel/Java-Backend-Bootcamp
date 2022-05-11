package com.Bootcamp.Dia15.Respository;

import java.util.ArrayList;

import com.Bootcamp.Dia15.Model.CustomerModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerModel,String> {
    ArrayList<CustomerModel> getCustomersByName(String name);
}
