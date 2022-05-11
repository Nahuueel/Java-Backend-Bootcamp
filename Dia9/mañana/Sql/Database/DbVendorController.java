package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


import models.Vendor;

public class DbVendorController {
    private Conection conection;

    private Connection con;
     
    public DbVendorController(){
    	conection = new Conection();
      
    }
    
    
    public void insertVendor(Vendor vendor)
    {
        PreparedStatement ps;
        PreparedStatement ps2;
        String sql;
    
       
        try{ //Save personal info
        	
         	Connection con = conection.getConnection();
            
            sql = "insert into Vendor( firstname, lastname, dni, Address, birth ,salary) values (?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, vendor.getFirstname());
            ps.setString(2, vendor.getLastname());
            ps.setString(3, vendor.getDni());
            ps.setString(4, vendor.getAddress());
            ps.setDate(5, vendor.getBirthSQL());
            
 
            ps.setDouble(6, vendor.getSalary());
  
            
            ps.executeUpdate();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
    }
    
    
    public void selectVendors()
    {
    	Connection con = conection.getConnection();
  
    	try
    	{
    		 
 	   String sql = "select idVendor,  firstname, lastname, dni from Vendor c inner join personInfo p on c.idInfo = p.idInfo";
		   PreparedStatement stmtt =  con.prepareStatement(sql);
		   ResultSet rs = stmtt.executeQuery(sql);
	
		   System.out.println("VENDORS: ");
		   while (rs.next()) {
			
		   System.out.println("Id: " + rs.getInt("idVendor")+ ", Name: " + rs.getString("firstname") + " " + rs.getString("lastname") +", DNI: "+rs.getString("dni") );
		}
		  
		  rs.close();
	stmtt.close();
		}
		catch (Exception e) {
		  e.printStackTrace();
		}
    }
    
    
}