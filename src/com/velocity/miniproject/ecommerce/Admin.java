package com.velocity.miniproject.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin {
	     public void adminLogin(){
	    	 
	    	String  adminId="MYSTORE@2208";
	    	int adminPin=7552;
	    	Scanner sc=new Scanner(System.in);
	    	System.out.println("enter correct id");
	    	String ad_id=sc.next();
	    	System.out.println("enter pin");
	    	int pin=sc.nextInt();
	    	if(adminId.equalsIgnoreCase(ad_id)&&adminPin==pin) {
	    		System.out.println("admin login successfully");
	    	}
	    	else {
	    		System.out.println("enter correct details");
	    		
	    	}
	     }
	     
	     
	     
	     
	     public void reg_userList() {
	    	 PreparedStatement prs=null;
	    		Connection con=null;
	    	 DataBaseConnection dataconnection=new DataBaseConnection();
	 		
	 		try {
	 			
	 			con=dataconnection.getConnectionDetails();
	 			prs=con.prepareStatement("select user_name,user_address,user_number from regestered_user ");
	 			
				
				ResultSet rs=prs.executeQuery();
				
				
				while(rs.next())
				{
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
					
				}
				con.close();
	 	        prs.close();
	 			
	 	      }
	 		            
	 		 catch (Exception e) {
	 			e.printStackTrace();
	 		}                               
	 		
	 		}
	   




		public void getUserHistory(String name1) {
			 PreparedStatement prs=null;
	    		Connection con=null;
			 DataBaseConnection dataconnection=new DataBaseConnection();
				con=dataconnection.getConnectionDetails();
		        try {
					prs=con.prepareStatement("select product_id,product_price,product_quantity, total" + 
							"from purchaced_product" + 
							"where user_name=?");
					prs.setString(1,name1 );
					ResultSet rs=prs.executeQuery();
				       while(rs.next())
					{
						System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4)); 
					}
				       
					 
				       
				      
				       
				       
				} catch (SQLException e) {
					// TODO Auto-generated catch bloc
					e.printStackTrace();
				}
			
		}
	 		
	     

	
}
