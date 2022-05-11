package com.Bootcamp.Dia15.Respository;

import java.util.ArrayList;
import java.util.Optional;

import com.Bootcamp.Dia15.Model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel,String> {
    ArrayList<UserModel> getUsersByName(String name);
    Optional<UserModel> getUserByEmail(String email);
    UserModel findByEmail(String email);
}
