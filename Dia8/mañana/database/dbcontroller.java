package database;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import models.*;

public class dbcontroller {
    private Conection conection;

    private Connection con;
     
    public dbController(){
    	conection = new Conection();
      
    }
    
    //INSERTS
    
    public void insertClient(Client client)
    {
        PreparedStatement ps;
        PreparedStatement ps2;
        String sql;
    
       
        try{ //Save personal info
        	
         	Connection con = conection.getConnection();
            sql = "insert into personInfo( idInfo, firstname, lastname, dni, Address, birth) values (?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, client.getId());
            ps.setString(2, client.getFirstname());
            ps.setString(3, client.getLastname());
            ps.setString(4, client.getDni());
            ps.setString(5, client.getAddress());
            ps.setDate(6, client.getBirthSQL());
            
            ps.executeUpdate();
            
            sql = "insert into Clients( idClient, idInfo) values (?,?)";
            ps2 = con.prepareStatement(sql);
            ps2.setInt(1, client.getIdClient());
            ps2.setInt(2, client.getId());
            
            ps2.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
        
        
        
    }
    public void insertVendor(Vendor vendor)
    {
        PreparedStatement ps;
        PreparedStatement ps2;
        String sql;
    
       
        try{ //Save personal info
        	
         	Connection con = conection.getConnection();
            sql = "insert into personInfo( idInfo, firstname, lastname, dni, Address, birth) values (?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, vendor.getId());
            ps.setString(2, vendor.getFirstname());
            ps.setString(3, vendor.getLastname());
            ps.setString(4, vendor.getDni());
            ps.setString(5, vendor.getAddress());
            ps.setDate(6, vendor.getBirthSQL());
            
            ps.executeUpdate();
            
            sql = "insert into Vendor( idVendor, salary, idInfo) values (?,?,?)";
            ps2 = con.prepareStatement(sql);
            ps2.setInt(1, vendor.getOwnId());
            ps2.setDouble(2, vendor.getSalary());
            ps2.setInt(3, vendor.getId());
            
            ps2.executeUpdate();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
        }
    }
    
    
        public void insertProduct(Product prod)
        {
            PreparedStatement ps;
            PreparedStatement ps2;
            String sql;
        
           
            try{ 
            	
             	Connection con = conection.getConnection();
                sql = "insert into Products( idProduct, price, ammount, minStock) values (?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, prod.getCode());
                ps.setDouble(2, prod.getPrice());
                ps.setInt(3, prod.getAmmount());
                ps.setInt(4, prod.getMinStock());
                ps.executeUpdate();
            
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
            }
        
        
    }
        
        
        public void insertBilling(Billing billing)
        {
            PreparedStatement ps;
            PreparedStatement ps2;
            String sql;
        
           
            try{ 
            	
             	Connection con = conection.getConnection();
                sql = "insert into Billings( idBilling, datesql, idClient, idVendor, idProd) values (?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, billing.getId());
                ps.setDate(2, billing.getDateSQL());
                ps.setInt(3, billing.getClient().getIdClient());
                ps.setInt(4, billing.getVendor().getIdVendor());
                ps.setInt(5, billing.getProduct().getCode());
           
                ps.executeUpdate();
            
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
            }
        
        
    }
    
  //SELECTS
        
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
        
        public void selectBillings()
        {
        	Connection con = conection.getConnection();
      
        	try
        	{
        		 
     	   String sql = "select * from Billings";
   		   PreparedStatement stmtt =  con.prepareStatement(sql);
   		   ResultSet rs = stmtt.executeQuery(sql);
   	
   		   System.out.println("BIILINGS:  ");
   		   while (rs.next()) {
   			
   		   System.out.println("Id: " + rs.getInt("idBilling")+ ", Date: " + rs.getDate("datesql") + ", Client id:  " + rs.getInt("idClient") +", Vendor id: : "+rs.getString("idVendor") + ", Product id: " + rs.getInt("idProd") );
   		}
   		  
   		  rs.close();
   	stmtt.close();
   		}
   		catch (Exception e) {
   		  e.printStackTrace();
   		}
        }
        
        //DELETES
        
        public void deletePerson(int idInfo)
        {
        	Connection con = conection.getConnection();
            
        	try
        	{
        		 
     	   String sql = "Delete from personInfo where idInfo = " +idInfo +";";
   		   PreparedStatement stmtt =  con.prepareStatement(sql);
   		   stmtt.executeUpdate();
   	
  
   		
   	stmtt.close();
   		}
   		catch (Exception e) {
   		  e.printStackTrace();
   		}
        }
        
        
        public void deleteProduct(int idProduct)
        {
        	Connection con = conection.getConnection();
            
        	try
        	{
        		 
     	   String sql = "Delete from Products where idProduct = " +idProduct +";";
   		   PreparedStatement stmtt =  con.prepareStatement(sql);
   		   stmtt.executeUpdate();
   	
  
   		
   	stmtt.close();
   		}
   		catch (Exception e) {
   		  e.printStackTrace();
   		}
        	
        }
    
        public void deleteBilling(int idBilling)
        {
        	Connection con = conection.getConnection();
            
        	try
        	{
        		 
     	   String sql = "Delete from Billings  where idBilling = " +idBilling +";";
   		   PreparedStatement stmtt =  con.prepareStatement(sql);
   		   stmtt.executeUpdate();
   	
  
   		
   	stmtt.close();
   		}
   		catch (Exception e) {
   		  e.printStackTrace();
   		}
        	
        }
        
        
        //UPDATES
        
        public void updatePerson(int idPerson, String firstName, String lastname, String dni, String Address, Date date)
        {
	Connection con = conection.getConnection();
            
        	try
        	{
        		 
     	   String sql = "Update personInfo  " + "SET firstname = ?, lastname = ?, dni = ?, Address = ? ,birth = ?" + "where idPerson =?;";
   		   PreparedStatement stmtt =  con.prepareStatement(sql);
   		   
   		   stmtt.setString(1, firstName);
   		   stmtt.setString(2, lastname);
   		   stmtt.setString(3, dni);
   		   stmtt.setString(4, Address);
   		   stmtt.setDate(5, date);
   		   stmtt.setInt(6, idPerson);
   		   
   		   stmtt.executeUpdate();
   	
  
   		
   	stmtt.close();
   		}
   		catch (Exception e) {
   		  e.printStackTrace();
   		}
        }
        
        public void updateProduct(int idProduct, double price, int ammount, int minStock)
        {
	Connection con = conection.getConnection();
            
        	try
        	{
        		 
     	   String sql = "Update Products  "	+ "SET price = ?, ammount = ?, minStock = ?" + "where idProduct = ?;";
   		   PreparedStatement stmtt =  con.prepareStatement(sql);
   		
   		   stmtt.setDouble(1, idProduct);
   		   stmtt.setInt(2, ammount);
   		 stmtt.setInt(3, minStock);
   		 stmtt.setInt(4, idProduct);
   	
   	   stmtt.executeUpdate();
   		
   	stmtt.close();
   		}
   		catch (Exception e) {
   		  e.printStackTrace();
   		}
        }
        
        
        public void updateBilling(int idBilling, Date datesql, int idClient, int idVendor, int idProd)
        {
	Connection con = conection.getConnection();
            
        	try
        	{
        		 
     	   String sql = "Update Billings  " + "SET datesql =  ? , idClient = ?  , idVendor = =  , idProd= ?" + "where idBilling = ?;";
   		   PreparedStatement stmtt =  con.prepareStatement(sql);
   		   stmtt.setDate(1, datesql);
   		   stmtt.setInt(2, idClient);
   		   stmtt.setInt(3, idVendor);
   		   stmtt.setInt(4, idProd);
   		   stmtt.setInt(5, idBilling);
   		   stmtt.executeUpdate();
   	
  
   		
   	stmtt.close();
   		}
   		catch (Exception e) {
   		  e.printStackTrace();
   		}
        }

	

    
}