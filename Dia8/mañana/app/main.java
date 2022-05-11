package app;

import database.dbController;
import models.*;

public class Main {

	public static void main(String[] args) {
		
		dbController dbc = new dbController();
		Product prod = new Product(120.5, 12, 5);
		Vendor vendor = new Vendor("Carlos", "Magno", "234", "mendoza", 14,02,1950, 1240.5);
		Client client = new Client("Franco", "Luzardi", "123", "mar del plata", 15, 04, 2002);
		Billing billing = new Billing(client, vendor, 13,04,2022, prod);
	
		
		
		dbc.insertVendor(vendor);
		dbc.insertClient(client);
		dbc.insertProduct(prod);
		dbc.insertBilling(billing);
		
		dbc.selectClients();
		dbc.selectVendors();
		dbc.selectProducts();
		dbc.selectBillings();

	}

}