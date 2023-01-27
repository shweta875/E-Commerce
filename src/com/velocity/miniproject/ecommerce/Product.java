package com.velocity.miniproject.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Product {
	PreparedStatement prs=null;
	Connection con=null;

	public void getPoductlist() {
		DataBaseConnection dataconnection=new DataBaseConnection();
		con=dataconnection.getConnectionDetails();
        try {
			prs=con.prepareStatement("select * from productlist ");
			
			ResultSet rs=prs.executeQuery();
		       while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+":"+"\t"+"price >>"+rs.getInt(4));
				System.out.println(rs.getString(3));
        System.out.println("---------------------------------------------------");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void  getProductQuantity(int productId) {
		DataBaseConnection dataconnection=new DataBaseConnection();
		con=dataconnection.getConnectionDetails();
        try {
			prs=con.prepareStatement("select quantity from productlist where product_id=? ");
		     prs.setInt(1,productId);
			ResultSet rs=prs.executeQuery();
		       while(rs.next())
			{
				
				System.out.println("Quantity of Product :: " +rs.getInt(1));
        System.out.println("---------------------------------------------------");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
		

}
