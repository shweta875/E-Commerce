package com.velocity.miniproject.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class User {
	PreparedStatement prs=null;
	Connection con=null;
	
	public String user_regestration(String userId,String userName,String userPassword,String userAddress,String userNumber) {
		DataBaseConnection dataconnection=new DataBaseConnection();
		
		try {
			
			con=dataconnection.getConnectionDetails();
			prs=con.prepareStatement("insert into regestered_user(user_id,user_name,user_password,user_address,user_number)"
					+ "                 values(?,?,?,?,?)");
			prs.setString(1, userId);
			prs.setString(2, userName);
			prs.setString(3, userPassword);
			prs.setString(4, userAddress);
			prs.setString(5, userNumber);
			
			int i=prs.executeUpdate();
			System.out.println("Regestration Successfull..."+i);
			
			prs=con.prepareStatement("Select user_password from regestered_user where user_id=? ");
			prs.setString(1, userId);
			        ResultSet rs= prs.executeQuery();
			        while(rs.next()) {
			        	userPassword=rs.getString(3);
			        	
			        	
			        	
			        }con.close();
			        prs.close();
			        rs.close();
			        
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	return userPassword;	
	
	}
		
		public void userInput() {
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the user name");
			String userName=sc.next();
			System.out.println("Enter the user ID");
			String userId=sc.next();
			System.out.println("Enter the user Password");
			String userPassword=sc.next();
			System.out.println("Enter the user Address");
			String userAddress=sc.next();
			System.out.println("Enter the user Number");
			String userNumber=sc.next();
			
			
			String x=user_regestration(userName, userId, userPassword, userAddress, userNumber);
			System.out.println(x);
			}

}
