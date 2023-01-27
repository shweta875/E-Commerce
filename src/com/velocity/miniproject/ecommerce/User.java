package com.velocity.miniproject.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User {
	PreparedStatement prs = null;
	Connection con = null;
	String ps1;
	String userId;

	public void user_regestration(String userId, String userName, String userPassword, String userAddress,
			String userNumber) {
		DataBaseConnection dataconnection = new DataBaseConnection();

		try {

			con = dataconnection.getConnectionDetails();
			prs = con.prepareStatement(
					"insert into regestered_user(user_id,user_name,user_password,user_address,user_number)"
							+ " values(?,?,?,?,?)");
			prs.setString(1, userId);
			prs.setString(2, userName);
			prs.setString(3, userPassword);
			prs.setString(4, userAddress);
			prs.setString(5, userNumber);

			int i = prs.executeUpdate();
			System.out.println("Regestration Successfull..");

			con.close();
			prs.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void userInput() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the user name");
		String userName = sc.nextLine();
		System.out.println("Enter the user ID");
		String userId = sc.nextLine();
		System.out.println("Enter the user Password");
		String userPassword = sc.nextLine();
		System.out.println("Enter the user Address");
		String userAddress = sc.next();
		System.out.println("Enter the user Number");
		String userNumber = sc.next();
		user_regestration(userId, userName, userPassword, userAddress, userNumber);

		System.out.println("registeration successfully done....");

	}

	public void doLogin() {

		DataBaseConnection dataconnection = new DataBaseConnection();
		System.out.println("please enter login details");
		Scanner sc1 = new Scanner(System.in);
		System.out.println("enter your existing userId ");
		String userid = sc1.next();
		System.out.println("Enter the user Password");
		String ps = sc1.next();
		this.userId = userid;

		// System.out.println("if already exist enter registered userid and password");
		try {
			con = dataconnection.getConnectionDetails();
			prs = con.prepareStatement("select user_password from regestered_user where user_id=?");
			prs.setString(1, userId);

			ResultSet rs = prs.executeQuery();
			String ps1 = " ";

			while (rs.next()) {
				ps1 = rs.getString(1);
				System.out.println(ps1);
				System.out.println("ps1");
			}

			if (ps1.equalsIgnoreCase(ps)) {
				System.out.println("login successfull....");
			} else {
				System.out.println("enter correct password");
			}

		} catch (Exception e) {
			e.getStackTrace();
		}

	}

}
