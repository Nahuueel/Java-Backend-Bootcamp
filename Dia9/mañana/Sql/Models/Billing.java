package models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Billing {

private LocalDate date;
private Date dateSQL;
private int client;
private int vendor;
int products[];
int pos;




public Billing(int client, int vendor, int day, int month, int year, Product product) {
	super();

	this.date = LocalDate.of(year, month, month); //DATE TO SQL
	dateSQL = dateSQL.valueOf(date);
	this.client = client;
	this.vendor = vendor;
this.products = new int[30];
pos = 0;
}
public Billing() {
	
this.products = new int[30];
pos = 0;
}



public int[] getProducts() {
	return products;
}
public int getOneProduct(int i)
{
	return products[i];
}
public void insertProducts(int prod)
{
	products[pos] = prod;
	pos++;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public Date getDateSQL() {
	return dateSQL;
}
public void setDateSQL(Date dateSQL) {
	this.dateSQL = dateSQL;
}
public int getClient() {
	return client;
}
public void setClient(int client) {
	this.client = client;
}
public int getVendor() {
	return vendor;
}
public void setVendor(int vendor) {
	this.vendor = vendor;
}





}
