package com.mongodb.mongodb.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.mongodb.database.Dbconector;
import com.mongodb.mongodb.model.PersonModel;

import org.bson.Document;

public class PersonController {
Dbconector connection; 
MongoDatabase mdb;
MongoCollection <Document> persons; 

public PersonController()
{
	connection = new Dbconector("ExampleMongoDB"); 
	mdb = connection.getDb();
	persons = mdb.getCollection("persons");
}
 
public void insertPerson(PersonModel person)
{
	
if(!personExists(person.getDni())) {
	persons.insertOne(new Document("FirstName", person.getFirstname()).append("LastName", person.getLastname()).append("DNI", person.getDni()).append("Address", person.getAddress()));

}
	else
	System.out.println("There is already a person with that DNI");

}

public boolean personExists(String dni)
{
	FindIterable<Document> personD = persons.find().filter(new Document("DNI", dni));
	if(personD.first() == null)
			return false;
	else
		return true;
}

public void getPersons()
{
	MongoCursor<Document> pIterator = persons.find().iterator();
	while(pIterator.hasNext())
	{
		System.out.println(pIterator.next().toJson());
	}



}

public void getPersonDni(String Dni)
{
	FindIterable<Document> personD = persons.find().filter(new Document("DNI", Dni));
	
if(personD.first() != null)
		System.out.println(personD.first().toJson());


}

public void deletePerson(String Dni)
{
	if(personExists(Dni)) {
		persons.deleteOne(new Document("DNI", Dni));
		System.out.println("Deleted");
	}
	else
		System.out.println("Invalid DNI");
	
}
}

