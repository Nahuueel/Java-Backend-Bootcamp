package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import models.Product;

public class DbProductController {

    private Conection conection;

    private Connection con;
     
    public DbProductController(){
    	conection = new Conection();
      
    }
	
	   public void insertProduct(Product prod)
       {
       
           PreparedStatement ps;
    
           String sql;
       
          
           try{ 
           	
            	Connection con = conection.getConnection();
               sql = "insert into Products(price, ammount, minStock) values (?,?,?)";
               ps = con.prepareStatement(sql);

            ps.setDouble(1, prod.getPrice());
            ps.setInt(2, prod.getAmmount());
            ps.setInt(3, prod.getMinStock());
        	
               ps.executeUpdate();
              
           }catch(SQLException e){
               JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
           }
       
       
   }
	   
       public void selectProducts()
       {
       	Connection con = conection.getConnection();
     
       	try
       	{
       		 
    	   String sql = "select *  from Products";
  		   PreparedStatement stmtt =  con.prepareStatement(sql);
  		   ResultSet rs = stmtt.executeQuery(sql);
  	
  		   System.out.println("PRODUCTS: : ");
  		   while (rs.next()) {
  			
  		   System.out.println("Id: " + rs.getInt("idProduct")+ ", Price: " + rs.getDouble("price") + " " + rs.getInt("ammount") +", minStock: "+rs.getString("minStock") );
  		}
  		  
  		  rs.close();
  	stmtt.close();
  		}
  		catch (Exception e) {
  		  e.printStackTrace();
  		}
       }
}