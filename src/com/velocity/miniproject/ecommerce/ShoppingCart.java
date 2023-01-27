package com.velocity.miniproject.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ShoppingCart {
	PreparedStatement prs=null;
	Connection con=null;
	
	 Product p1;
	
  
	  public Product doshopping() {
		 
		  
		  System.out.println("enter product id u wants");
	 Scanner sc=new Scanner(System.in);
	 int p_Id =sc.nextInt();
	System.out.println("how many product u wants");
	int userQty=sc.nextInt();
	 
			DataBaseConnection dataconnection=new DataBaseConnection();
			con=dataconnection.getConnectionDetails();
	        try {
				prs=con.prepareStatement("select price from productlist where product_id=?");
				prs.setInt(1,p_Id );
				ResultSet rs=prs.executeQuery();
				int store_price=0;
			       while(rs.next())
				{
					  store_price=rs.getInt(1);
				}
			      
				int total=userQty*store_price;
			
			      
			       
			        p1=new Product(p_Id,store_price,userQty,total);
			        System.out.println(p1);
			       
			} catch (SQLException e) {
				// TODO Auto-generated catch bloc
				e.printStackTrace();
			}
			return p1;
			}


	public int calculate_Qty() {
		ShoppingCart shopCart=new ShoppingCart();
	     
	     int store_qty=0;
	     int remain_qty=0;
	     DataBaseConnection dataconnection=new DataBaseConnection();
			con=dataconnection.getConnectionDetails();
	        try {
				prs=con.prepareStatement("select quantity from productlist where product_id=?");
				prs.setInt(1,p1.productId );
				ResultSet rs=prs.executeQuery();
			       while(rs.next())
				{
					 store_qty=rs.getInt(1);
				}
			       
				 remain_qty=store_qty-p1.quantity;
			       
			      
			       
			       
			} catch (SQLException e) {
				// TODO Auto-generated catch bloc
				e.printStackTrace();
			}
		
	             return remain_qty;
		
		}
	 public void storeHistory(String user ) {
		   
		  DataBaseConnection dataconnection=new DataBaseConnection();
			con=dataconnection.getConnectionDetails();
			try {
				prs=con.prepareStatement("insert into purchaced_product(user_name,product_id,product_price,product_quantity, total) values(?,?,?,?,?)");
				
				prs.setString(1,user);
				prs.setInt(2,p1.productId);
				prs.setInt(3,p1.price );
				prs.setInt(4,p1.quantity);
               prs.setInt(5, p1.total);				
				
				prs.execute();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	 public void update_qty() {
		 int qty=calculate_Qty();
		 
	     DataBaseConnection dataconnection=new DataBaseConnection();
			con=dataconnection.getConnectionDetails();
	        try {
				prs=con.prepareStatement("update productlist set quantity=? where product_id=?");
				prs.setInt(1,qty);
				prs.setInt(2,p1.productId);
				prs.execute();
			      
			      } catch (SQLException e) {
				// TODO Auto-generated catch bloc
				e.printStackTrace();
			}
	 }
	 
	 
	 
	 
}
	 



