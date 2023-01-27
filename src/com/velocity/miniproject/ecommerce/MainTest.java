package com.velocity.miniproject.ecommerce;

import java.util.Scanner;

public class MainTest {
	int grant_total;
	
	    public void continueShopping() {
	    	
	    	ShoppingCart shopCart=new ShoppingCart();
	   
	    	 System.out.println("Do you want any product from above list");
        	 System.out.println("Enter 'YES' for continue shopping");
        	 System.out.println("Otherwise 'No'");
        	 Scanner sc1=new Scanner(System.in);
        	 String wish=sc1.next();
        if(wish.equalsIgnoreCase("yes")) {
            
          Product p1 = shopCart.doshopping();
           grant_total=grant_total+p1.total;
         continueShopping();
	    }else {
	    	
	    	System.out.println("Grand Total"+grant_total);
	    	System.out.println("Thank u visit again");
	    	
	    }
	    }
	   

    public static void main(String[] args) {
    	System.out.println("*******Welcome to MyStore Electronics**********");
    	
    	System.out.println("~please do registration to enter in Mystore's  world~");
    	System.out.println();
    	System.out.println(" Enter 1 => for Registration");
    	System.out.println(" Enter 2 => for User Login");
    	System.out.println(" Enter 3 => for Admin Login");
    	Scanner sc=new Scanner(System.in);
    	int select =sc.nextInt();
    	 User u =new User();
    	 Product p=new Product();
    	 ShoppingCart shc=new ShoppingCart();
    	 MainTest mt=new MainTest();
    	 Admin a=new Admin();
         switch(select) {
         case 1:
          u.userInput();
         case 2:
        	 u.doLogin();
        	 p.getPoductlist();
        	mt.continueShopping();
        	
        	 
        	 		
        	 
        	 
        	 break;
         case 3:
        	 a.adminLogin();
        	 System.out.println(" Enter 1 => To get Registered user list");
         	System.out.println(" Enter 2 => to get quantity of product ");
         	System.out.println(" Enter 3 => to history of Registered user");
         	 int select1=sc.nextInt();
         	 if(select1==1) {
         		 a.reg_userList();
         		}
         	 else if(select1==2) {
         		 System.out.println("Enter product id");
         		 int productid=sc.nextInt();
         		 p.getProductQuantity(productid);
         	 }else if(select1==3) {
         		 System.out.println("user history");
         	 }
        	 break;
        	 
        	 
        	 
        	
         }
    	
}
	
}
