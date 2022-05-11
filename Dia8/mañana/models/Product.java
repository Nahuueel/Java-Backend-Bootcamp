package models;

public class Product {
	private static int productId;
	private int code;
	private double price;
	private int ammount;
	private int minStock;
	

	public Product(double price, int ammount, int minStock) {

		productId++;
		code = productId;
		this.code = code;
		this.price = price;
		this.ammount = ammount;
		this.minStock = minStock;
	}
	
	public static int getProductId() {
		return productId;
	}

	public static void setProductId(int productId) {
		Product.productId = productId;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
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