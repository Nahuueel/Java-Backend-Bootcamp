package com.bootcamp.Dia18.Controller.Service;

import java.util.ArrayList;

import com.bootcamp.Dia18.Controller.Respository.UserRepository;
import com.bootcamp.Dia18.Model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    @Autowired
    private UserRepository ur;

    public ArrayList<User> getAllUser() {
        return (ArrayList<User>) ur.findAll();
    }

    public User getUserByEmail(String email) {
        return ur.getUserByEmail(email);
    }


    public void registerUser(User user) {
        ur.save(user);
    }

    public void modifyUser(User user, String email) {
        user.setEmail(email);
        ur.save(user);
    }

    public void deleteUser(String email) {
        ur.deleteById(email);
    }
}
