package com.java.Imp;

import java.util.Scanner;

import com.java.ChDao.Dao;
import com.java.ChService.Service;
import com.java.co.Cont;

public class Main {

	public static void main(String[] args) {
		
		Service s=new Service();
		Scanner sc=new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1...To add Medicine Details");
			System.out.println("2...To See all Medicine Details");
			System.out.println("3...To remove a particular medicine");
			System.out.println("4...To See Details of a particular medicine");
			System.out.println("5...To Update Name of medicine");
			System.out.println("6...To Update Price of medicine");
			System.out.println("7...To Add Stock");
			System.out.println("8...To Order");
			System.out.println("9...To Exit");
			int ch=sc.nextInt();
				
			
			if(ch==1)
			{
				s.toInsertDetails();
			}
			
			else if(ch==2)
			{
				s.toShowall();
			}
			else if(ch==3)
			{
				s.toRemove();
			}
			else if(ch==4)
			{
				s.toshowDetailofParticularMed();
			}
			else if(ch==5)
			{
				s.toUpdateName();
			}
			else if(ch==6)
			{
				s.toUpdatePrice();
			}
			else if(ch==7)
			{
				s.toUpdateStock();
			}
			else if(ch==8)
			{
				s.toOrder();
			}
			else if(ch==9)
			{
				System.out.println("Thank For Using My Chemist Shop Application");
				break;
			}
			else
			{
				
			}
		}
		
	}

}
