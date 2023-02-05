package com.java.ChService;

import java.util.Scanner;

import com.java.ChDao.Dao;
import com.java.Chemist.Chemist;

public class Service {
	
	Dao d;
	Scanner sc,sc1;
	
	Chemist c;
	
	public Service()
	{
		sc=new Scanner(System.in);
		sc1=new Scanner(System.in);
		d=new Dao();
		c=new Chemist();
		
	}
	
	public void toInsertDetails()
	{
		
		System.out.println("Enter Medicine Name :");
		String nm=sc1.nextLine();
		System.out.println("Enter the Price :");
		Double pr=sc.nextDouble();
		System.out.println("Enter Stock :");
		int st=sc.nextInt();
		
		c.setName(nm);
		c.setPrice(pr);
		c.setStock(st);
		
		boolean k=d.addDetails(c);
		
		if(k==true)
		{
			System.out.println("Details inserted Successfully..");
		}
		else
		{
			System.out.println("Something went wrong........Try again");
		}
			
	}
	
	public void toShowall()
	{
		d.showDetails();
	}
	
	public void toshowDetailofParticularMed()
	{
		System.out.println("Enter the Medicine Name to get Details:");
		String nm=sc1.nextLine();
		d.showParticularMedDetail(nm);
		
	}
	
	public void toRemove()
	{
		System.out.println("Enter the Medicine Name you want to remove:");
		String nm=sc1.nextLine();
		d.remove(nm);
		
	}
	
	public void toUpdateName()
	{
		System.out.println("Enter the Medicine Name you want to update :");
		String nm=sc1.nextLine();
		d.updateName(nm);
		
	}
	
	public void toUpdatePrice()
	{
		System.out.println("Enter the Medicine Name to update Price:");
		String nm=sc.nextLine();
		d.updatePrice(nm);
		
	}
	
	public void toUpdateStock()
	{
		System.out.println("Enter the Medicine Name to add Stock:");
		String nm=sc.nextLine();
		d.addStock(nm);
		
	}
	
	public void toOrder()
	{
		System.out.println("Enter Medicine Name:");
		String nm=sc1.nextLine();
		
		d.order(nm);
	}
}
