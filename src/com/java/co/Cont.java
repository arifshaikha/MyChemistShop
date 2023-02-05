package com.java.co;

import java.sql.Connection;
import java.sql.DriverManager;

public class Cont {
	
		private static Connection con;
		public Cont() 
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mychemistshop","root","root");
				//System.out.println("hogaya");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				//System.out.println("Nahi hua ");
			}
		}
		
		public static Connection getconnection()
		{
			Cont c=new Cont();
			return (con);
		}
}
