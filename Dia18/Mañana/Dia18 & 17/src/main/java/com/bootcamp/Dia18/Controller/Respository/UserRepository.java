package com.bootcamp.Dia18.Controller.Respository;

import com.bootcamp.Dia18.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User getUserByEmail(String email);
}
