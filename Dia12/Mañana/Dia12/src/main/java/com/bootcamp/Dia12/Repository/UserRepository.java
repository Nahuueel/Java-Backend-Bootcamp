package com.bootcamp.Dia12.Repository;

import java.util.ArrayList;

import com.bootcamp.Dia12.Model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel,String> {
    ArrayList<UserModel> getUsersByName(String name);

}
