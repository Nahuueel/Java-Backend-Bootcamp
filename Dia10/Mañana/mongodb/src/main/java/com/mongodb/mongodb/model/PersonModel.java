package com.mongodb.mongodb.model;

public class PersonModel {

	private String firstname, lastname, dni, address;
	
	public PersonModel(String firstname, String lastname, String dni, String address) {

		this.firstname = firstname;
		this.lastname = lastname;
		this.dni = dni;
		this.address = address;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}