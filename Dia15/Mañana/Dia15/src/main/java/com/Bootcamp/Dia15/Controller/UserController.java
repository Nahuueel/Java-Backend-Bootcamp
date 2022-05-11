package com.Bootcamp.Dia15.Controller;

import java.util.ArrayList;
import java.util.Optional;

import com.Bootcamp.Dia15.Model.UserModel;
import com.Bootcamp.Dia15.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/users")
@Api(value = "Controller Users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<ArrayList<UserModel>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<Optional<UserModel>> getUserByEmail(@PathVariable("email") String email) {
        if(email == null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return userService.getUserByEmail(email);
    }

    @GetMapping("/{name}")
    public ResponseEntity<ArrayList<UserModel>> getUsersByname(@PathVariable("name") String name) {
        if(name == null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return userService.getUsersByName(name);
    }

    @PutMapping("/user")
    public ResponseEntity<UserModel> modifyUser(@RequestBody UserModel userBody) {
        return userService.registerUser(userBody);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity deleteUser(@PathVariable("email") String email){
        if(email == null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return userService.deleteUserByEmail(email);
    }
}
