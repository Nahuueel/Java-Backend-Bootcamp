package com.Bootcamp.Dia15.Service;

import java.util.ArrayList;
import java.util.Optional;

import com.Bootcamp.Dia15.Model.CustomerModel;
import com.Bootcamp.Dia15.Respository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<ArrayList<CustomerModel>> getAllCustomers(){
        try {
            ArrayList<CustomerModel> users = new ArrayList<CustomerModel>();
            customerRepository.findAll().forEach(users::add);
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Optional<CustomerModel>>getCustomerByDni(String dni) {
        try {
            Optional<CustomerModel> user = customerRepository.findById(dni);
            if (user.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ArrayList<CustomerModel>>getCustomersByName(String name) {
        try {
            ArrayList<CustomerModel> customer = customerRepository.getCustomersByName(name);
            if (customer.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<CustomerModel> registerCostumer(CustomerModel costumerBody) {
        try {
            if(this.getCustomerByDni(costumerBody.getDni()) != null){
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
            CustomerModel customer = customerRepository.save(costumerBody);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity deleteCostumerByDni(String dni) {
        try {
            customerRepository.deleteById(dni);
            Optional<CustomerModel> user = customerRepository.findById(dni);
            if (user.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
