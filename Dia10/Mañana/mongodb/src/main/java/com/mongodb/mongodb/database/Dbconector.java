package com.mongodb.mongodb.database;

//import java.util.ArrayList;
//import java.util.List;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

//import org.bson.Document;


public class Dbconector {
	private String dbName;
	private  MongoClient mongoClient;
//	private List<Document> database;
	
	public Dbconector(String db){
		
	mongoClient = MongoClients.create();
//	database = mongoClient.listDatabases().into(new ArrayList<Document>());
	dbName = db;

	}

	public  MongoDatabase getDb()
	{
		return mongoClient.getDatabase(dbName);
	}
	
}

