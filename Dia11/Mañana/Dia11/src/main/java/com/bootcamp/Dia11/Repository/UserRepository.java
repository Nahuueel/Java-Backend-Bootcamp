package com.bootcamp.Dia11.Repository;

import java.util.ArrayList;

import com.bootcamp.Dia11.Model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel,String> {
    ArrayList<UserModel> getUsersById(String name);

}
