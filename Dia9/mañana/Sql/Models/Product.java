package models;

public class Product {

	private double price;
	private int ammount;
	private int minStock;
	

	public Product(double price, int ammount, int minStock) {

	
		this.price = price;
		this.ammount = ammount;
		this.minStock = minStock;
	}
	public Product() {
	
	}
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmmount() {
		return ammount;
	}
	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}
	public int getMinStock() {
		return minStock;
	}
	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}

}