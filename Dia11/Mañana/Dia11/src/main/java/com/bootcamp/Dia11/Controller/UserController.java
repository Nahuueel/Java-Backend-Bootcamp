package com.bootcamp.Dia11.Controller;

import java.util.ArrayList;
import java.util.Optional;

import com.bootcamp.Dia11.Model.UserModel;
import com.bootcamp.Dia11.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

   @Autowired
    UserService Us;

        @GetMapping
        public ResponseEntity<ArrayList<UserModel>> getAllUsers() {
            ArrayList<UserModel> users =  Us.getAllUser();
            return ResponseEntity.status(201).body(users); 
        }

        @GetMapping("/user/{dni}")
        public ResponseEntity<Optional<UserModel>> getUseByDni(@PathVariable("dni") String dni) {
            Optional<UserModel> user = Us.getUserByDni(dni);
            return ResponseEntity.status(201).body(user); 
        }

        @PostMapping("/user")
        public ResponseEntity<UserModel> createUser(@RequestBody UserModel userBody) {
            UserModel user = Us.createUser(userBody);
            return ResponseEntity.status(201).body(user); 
        }

        @PutMapping("/user")
        public ResponseEntity<UserModel> modifyUser(@RequestBody UserModel userBody) {
            UserModel user = Us.createUser(userBody);
            return ResponseEntity.status(201).body(user); 
        }

        @DeleteMapping("/user/{dni}")
        public ResponseEntity<Optional<UserModel>> deleteUser(@PathVariable("dni") String dni){
            Optional<UserModel> user = Us.deleteUserByDni(dni);
            return ResponseEntity.status(201).body(user); 
        }

    }