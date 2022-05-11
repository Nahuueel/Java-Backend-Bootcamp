package com.mongodb.mongodb;

import com.mongodb.mongodb.UI.UserInterface; 

@SpringBootApplication
public class MongodbApplication {

	public static void main(String[] args) {
//	SpringApplication.run(MongodbApplication.class, args);
	UserInterface userInterface = new UserInterface();    
	userInterface.menu();   
	}

}
