package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import models.Client;

public class DbClientController {
	
    private Conection conection;

    private Connection con;
     
    public DbClientController(){
    	conection = new Conection();
      
    }
	 public void insertClient(Client client)
	    {
		 
	   
	        PreparedStatement ps;
	        String sql;
	    
	       
	        try{ //Save personal info
	    
	         	Connection con = conection.getConnection();
	    
	            
	            sql = "insert into Clients( firstname, lastname, dni, Address, birth ) values (?,?,?,?,?)";
	            ps = con.prepareStatement(sql);
	            ps.setString(1, client.getFirstname());
	            ps.setString(2, client.getLastname());
	            ps.setString(3, client.getDni());
	            ps.setString(4, client.getAddress());
	            ps.setDate(5, client.getBirthSQL());
	            
	            ps.executeUpdate();
	        }catch(SQLException e){
	            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
	        }
	        
	        
	        
	    }
	 
	    public void selectClients()
        {
        	Connection con = conection.getConnection();
      
        	try
        	{
        		 
     	   String sql = "select idClient,  firstname, lastname, dni from Clients c inner join personInfo p on c.idInfo = p.idInfo";
   		   PreparedStatement stmtt =  con.prepareStatement(sql);
   		   ResultSet rs = stmtt.executeQuery(sql);
   		  System.out.println("CLIENTS: : ");
   		   while (rs.next()) {
   			
   		   System.out.println("Id: " + rs.getInt("idClient")+ ", Name: " + rs.getString("firstname") + " " + rs.getString("lastname") +", DNI: "+rs.getString("dni") );
   		}
   		  
   		  rs.close();
   	stmtt.close();
   		}
   		catch (Exception e) {
   		  e.printStackTrace();
   		}
        }
}