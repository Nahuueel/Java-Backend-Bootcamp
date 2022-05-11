package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.CallableStatement;

import models.Billing;

public class DbBillingsController {

	
    private Conection conection;

    private Connection con;
     
    public DbBillingsController(){
    	conection = new Conection();
      
    }
	
	   public void insertBilling(Billing billing)
       {
			int lastId = -1;
           java.sql.CallableStatement ps;
	        PreparedStatement ps2;

           String sql;

        	Connection con = conection.getConnection();
          
           try{ 
           	
        
                  
                   sql = "{CALL BillingAdd(?,?, ?)}";
                   ps = con.prepareCall(sql);
                   ps.setInt(1, billing.getClient());
                   ps.setInt(2, billing.getVendor());
                   ps.registerOutParameter(3, java.sql.Types.INTEGER);
                  ps.executeUpdate();
                  
            int id = ps.getInt(3);
       
        	for(int i = 0; i<billing.getProducts().length; i++)
     	{
        
        		 sql = "insert into BillProd (idBilling, idProd) values (?,?)";
                 ps2 = con.prepareCall(sql);
                 ps2.setInt(1, id);
                 ps2.setInt(2, billing.getOneProduct(i));
   
                ps2.executeUpdate();
     	}

           }catch(SQLException e){
               JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
           }
       
       
   }
	   
	   public void selectBillings()
       {
     
		  	Connection con = conection.getConnection();
       	try
       	{
       		 
    	   String sql = "select idBilling, datesql, idClient, idVendor, idProd from BillProd bp inner join Billings b on bp.idBilling = b.idBilling";
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
	   
	   public void selectBillingsVendor(int id)
	   {
		
		  	Connection con = conection.getConnection();
	       	try
	       	{
	       		 
	    	   String sql = "select firstname, lastname, dni, salary, idBilling from Vendor v inner join Billings b on b.idVendor = v.idVendor where v.idVendor = " + id;
	  		   PreparedStatement stmtt =  con.prepareStatement(sql);
	  		   ResultSet rs = stmtt.executeQuery(sql);
	  	
	  		
	  		   while (rs.next()) {
	  			
	  		   System.out.println("Id Billing: " + rs.getInt("idBilling")+ ", Name: " + rs.getString("firstname") +" " + rs.getString("lastname") + ", DNI: " + rs.getString("dni") + ", Salary: " + rs.getDouble("salary") );
	  		}
	  		  
	  		  rs.close();
	  	stmtt.close();
	  		}
	  		catch (Exception e) {
	  		  e.printStackTrace();
	  		}
	   }
	   
	   public void selectBillingsByDate(int year, int month, int day)
	   {
		
		  	Connection con = conection.getConnection();
	       	try
	       	{
	       		 
	    	   String sql = "select * from Billings b where DATE(datesql) = " + " '" + year + "-" + month + "-" + day +"'";
	  		   PreparedStatement stmtt =  con.prepareStatement(sql);
	  		   ResultSet rs = stmtt.executeQuery(sql);
	  	
	  		
	  		   while (rs.next()) {
	  			
	  		   System.out.println("Id Billing: " + rs.getInt("idBilling")+ ", Date: " + rs.getDate("datesql") +", idClient: " + rs.getInt("idClient") + ", idVendor: " + rs.getInt("idVendor"));
	  		}
	  		  
	  		  rs.close();
	  	stmtt.close();
	  		}
	  		catch (Exception e) {
	  		  e.printStackTrace();
	  		}
	   }

}