package models;

public class Client extends Person {
	private static int clientId;
private int idClient;
	public Client(String firstname, String lastname, String dni, String address, int day, int month, int year) {
		super(firstname, lastname, dni, address, day, month, year);
		clientId++;
		idClient = clientId;
	}
	public Client() {
		clientId++;
		idClient = clientId;
	}
	public static int getClientId() {
		return clientId;
	}

	public static void setClientId(int clientId) {
		Client.clientId = clientId;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
}