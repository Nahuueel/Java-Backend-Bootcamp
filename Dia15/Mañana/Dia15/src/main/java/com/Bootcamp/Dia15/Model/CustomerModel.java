package com.Bootcamp.Dia15.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table (name = "Customers", uniqueConstraints = {@UniqueConstraint(columnNames = "phone")})
public class CustomerModel {
    @Id
    @NotBlank
    @Size(max = 50)
    @Email
    @Column(name = "dni")
    private String dni;

    @NotBlank
    @Size(max = 30)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Size(max = 20)
    @Column(name = "SurName")
    private String surname;

    @NotBlank
    @Size(max = 20)
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(max = 20)
    @Column(name = "phone")
    private String phone;

    public CustomerModel() {
    }

    public CustomerModel(String dni, String name, String surname, String email, String phone) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }


    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }


}
