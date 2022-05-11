package models;

import java.util.ArrayList;

public class Market {

	private static Market myInstance;
	
	ArrayList<Product> products;
	ArrayList<Client> clients;
	ArrayList<Vendor> vendors;
	ArrayList<Billing> billigs;
	private void market()
	{
		products = new ArrayList<Product>();
		clients = new ArrayList<Client>();
		vendors = new ArrayList<Vendor>();
		billigs = new ArrayList<Billing>();
	}
	public Market getInstance()
	{
		if(myInstance == null)
		return	myInstance = new Market();
		
		return myInstance;
	}
	public static Market getMyInstance() {
		return myInstance;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	public ArrayList<Client> getClients() {
		return clients;
	}
	public ArrayList<Vendor> getVendors() {
		return vendors;
	}
	public ArrayList<Billing> getBilligs() {
		return billigs;
	}
	
}