package com.mongodb.mongodb.UI;

import java.util.Scanner;

import com.mongodb.mongodb.controller.PersonController;
import com.mongodb.mongodb.model.PersonModel;  

public class UserInterface {

public UserInterface(){
}

public void menu()
{
	PersonController pc = new PersonController();
	Scanner scan = new Scanner(System.in);
	
	boolean flag = true;
	while(flag)
	{
		System.out.println("1- Data Register");
		System.out.println("2- Data Query");
		System.out.println("3- Data Delete");
		System.out.println("4- Data List");
		System.out.println("5- Exit");
		int option = scan.nextInt();
		
		switch(option) {
	
		case 1:
			
			System.out.println("First Name: ");
			scan.nextLine();
			String fn = scan.nextLine();
			System.out.println("Last Name: ");
			String ln = scan.nextLine();
			System.out.println("DNI: ");
			String dni = scan.nextLine(); 
			System.out.println("Address: ");
			String add = scan.nextLine();

			PersonModel person = new PersonModel(fn,ln,dni,add);

			pc.insertPerson(person);
			break;
		case 2:
	
			System.out.println("Enter Dni: ");
			scan.nextLine();
			
			pc.getPersonDni(scan.nextLine());
			
			break;
		case 3:

		
			System.out.println("Enter DNI: ");
			scan.nextLine();
			
			pc.deletePerson(scan.nextLine());
			
			break;
		case 4:
	
			
			pc.getPersons();
			
			break;
		case 5: flag = false;
		break;
		default: System.out.println("Invalid Option");
		break;
		}
	}

}
}

