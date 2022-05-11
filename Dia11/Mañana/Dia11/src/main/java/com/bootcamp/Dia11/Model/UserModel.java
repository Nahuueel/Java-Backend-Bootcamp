package com.bootcamp.Dia11.Model;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "users")
public class UserModel {
    @Id
    private String dni;
    private String name;
    private String surname;

    public UserModel() {
    }

    public UserModel(String name, String surname, String dni) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
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

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
}
