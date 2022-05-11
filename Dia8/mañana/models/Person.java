package models;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Person {
	
	protected static int idInfo;
	protected int id;
	protected String firstname, lastname, dni, address;
	protected LocalDate  birth;
	protected Date  birthSQL;

	
	public Person(String firstname, String lastname, String dni, String address, int day, int month, int year) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.dni = dni;
		this.address = address;
		this.birth = LocalDate.of(year, month, month);
		birthSQL = birthSQL.valueOf(birth);
		idInfo++;
		id = idInfo;
	}
	
	public static int getIdInfo() {
		return idInfo;
	}

	public static void setIdInfo(int idInfo) {
		Person.idInfo = idInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	public Date getBirthSQL() {
		return birthSQL;
	}
	public void setBirthSQL(Date birthSQL) {
		this.birthSQL = birthSQL;
	}
	

	
}