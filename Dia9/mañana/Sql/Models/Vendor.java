package models;

public class Vendor extends Person {
	private static int vendorId;
	private int ownId;
	private double salary;

	public Vendor(String firstname, String lastname, String dni, String address, int day, int month, int year,
			double salary) {
		super(firstname, lastname, dni, address, day, month, year);
		vendorId++;
		ownId = vendorId;
		this.salary = salary;
	}
	public Vendor() {

		vendorId++;
		ownId = vendorId;

	}
	public static int getVendorId() {
		return vendorId;
	}

	public static void setVendorId(int vendorId) {
		Vendor.vendorId = vendorId;
	}

	public int getIdVendor() {
		return ownId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setIdVendor(int ownId) {
		this.ownId = ownId;
	}

	public int getOwnId() {
		return ownId;
	}

	public void setOwnId(int ownId) {
		this.ownId = ownId;
	}
	
}