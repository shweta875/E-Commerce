package com.velocity.miniproject.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ShoppingCart {
	
	PreparedStatement prs=null;
	Connection con=null;

  void purchaseProduct() {
	  DataBaseConnection dataconnection=new DataBaseConnection();
		con=dataconnection.getConnectionDetails();
		try {
			prs=con.prepareStatement("SELECT * FROM productlist order by product_name,price,quantity");
			ResultSet rs=prs.executeQuery();
		       while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+":"+"\t"+"price >>"+rs.getInt(4));
				System.out.println(rs.getString(3));
     System.out.println("---------------------------------------------------");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		}
  
		public void addTocart()
		{
			try {
			prs=con.prepareStatement("SELECT * FROM productlist ");
			ResultSet rs=prs.executeQuery();
			while(rs.next())
			{
				Product p=new Product();
				
				}
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		}
	  
  }


