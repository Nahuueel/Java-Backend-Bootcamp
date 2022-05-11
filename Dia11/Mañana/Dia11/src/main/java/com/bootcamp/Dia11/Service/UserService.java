package com.bootcamp.Dia11.Service;

import java.util.ArrayList;
import java.util.Optional;

import com.bootcamp.Dia11.Model.UserModel;
import com.bootcamp.Dia11.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository Ur;

    public ArrayList<UserModel> getAllUser(){
            ArrayList<UserModel> users = new ArrayList<UserModel>();
            Ur.findAll().forEach(users::add);
            return users;
    }

    public Optional<UserModel>getUserByDni(String dni) {
            Optional<UserModel> user = Ur.findById(dni);
            return user;
    }


    public UserModel createUser(UserModel userBody) {
            UserModel user = Ur.save(userBody);
            return user;
    }

    public Optional<UserModel> deleteUserByDni(String dni) {
                Ur.deleteById(dni);
                Optional<UserModel> user = Ur.findById(dni);
                return user; 
        }    
}
