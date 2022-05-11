package com.Bootcamp.Dia15.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Users")
public class UserModel {
   
    @Id
    @NotBlank
    @Size(max = 50)
    @Email
    @Column(name = "email")
    private String email;   
    
    @NotBlank
    @Size(max = 20)
    @Column(name = "lastName")
 
    private String name;
   
    @NotBlank
    @Size(max = 20)
    @Column(name = "firstName")
    private String surname;
    
    @NotBlank
    @Size(max = 30)
    @Column(name = "password")
    private String password;

    public UserModel() {
    }

    public UserModel(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
