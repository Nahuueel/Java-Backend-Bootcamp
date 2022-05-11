package com.bootcamp.Dia14.Controller;

import java.util.ArrayList;
import java.util.Optional;

import com.bootcamp.Dia14.Model.UserModel;
import com.bootcamp.Dia14.Service.UserService;

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
@RequestMapping("/users")
@Api(value = "Controller de Users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<ArrayList<UserModel>> getAllUsers() {
        return userService.getAllUser();
    }


    @GetMapping("/{dni}")
    public ResponseEntity<Optional<UserModel>> getUserByDni(@PathVariable("dni") String dni) {
        if(dni == null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        if(dni.length()<=0 ^ dni.length() >8){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return userService.getUserByDni(dni);
    }

    @GetMapping("/user/{name}")
    public ResponseEntity<ArrayList<UserModel>> getUserByname(@PathVariable("name") String name) {
        if(name == null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return userService.getUserByName(name);
    }

    @PostMapping()
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel userBody) {
        return userService.createUser(userBody);
    }

    @PutMapping()
    public ResponseEntity<UserModel> modifyUser(@RequestBody UserModel userBody) {
        return userService.createUser(userBody);
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity deleteUser(@PathVariable("dni") String dni){
        if(dni == null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        if(dni.length()<=0 ^ dni.length() >8){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return userService.deleteUserByDni(dni);
    }
}
