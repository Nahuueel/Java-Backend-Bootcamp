package com.bootcamp.Dia14.Respository;

import java.util.ArrayList;

import com.bootcamp.Dia14.Model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel,String> {
    ArrayList<UserModel> getUsersByName(String name);
}
