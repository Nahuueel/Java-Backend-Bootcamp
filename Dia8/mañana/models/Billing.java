package models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Billing {
private static int billingId;
private int id;
private LocalDate date;
private Date dateSQL;
private Client client;
private Vendor vendor;
Product product;




public Billing(Client client, Vendor vendor, int day, int month, int year, Product product) {
	super();
	billingId++;
	this.id = billingId;
	this.date = LocalDate.of(year, month, month); //DATE TO SQL
	dateSQL = dateSQL.valueOf(date);
	this.client = client;
	this.vendor = vendor;
	this.product = product;
}

public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}

public static int getBillingId() {
	return billingId;
}

public static void setBillingId(int billingId) {
	Billing.billingId = billingId;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}
public Vendor getVendor() {
	return vendor;
}
public void setVendor(Vendor vendor) {
	this.vendor = vendor;
}





}