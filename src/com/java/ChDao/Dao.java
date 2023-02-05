package com.java.ChDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.java.Chemist.Chemist;
import com.java.co.Cont;

public class Dao {
	
	Connection con;
	Cont c;
	PreparedStatement prs;
	ResultSet rs;
	Scanner sc,sc1;
	
	public Dao()
	{
		con=Cont.getconnection();
		sc=new Scanner(System.in);
		sc1=new Scanner(System.in);
	}

	public boolean addDetails(Chemist c) 
	{
		boolean f=false;
		try
		{
			prs=con.prepareStatement("insert into medtab(name,price,stock) values (?,?,?)");
			prs.setString(1, c.getName());
			prs.setDouble(2, c.getPrice());
			prs.setInt(3, c.getStock());
			
			prs.executeUpdate();
			f=true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return f;
	}

	public void showDetails() {
		
		try
		{
			prs=con.prepareStatement("select * from medtab;");
			rs=prs.executeQuery();
			
			while(rs.next())
			{
				System.out.print("Med_ID:  "+rs.getInt(1));
				System.out.print(" |  Med_Name: "+rs.getString(2));
				System.out.print(" | Price: "+rs.getDouble(3));
				System.out.print(" | Stock: "+rs.getInt(4));
				System.out.println(" ");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public void remove(String nm) 
	{
			try
			{
				prs=con.prepareStatement("select name from medtab");
				rs=prs.executeQuery();
				boolean flag=false;
				while(rs.next())
				{
					if(rs.getString(1).equals(nm))
					{	
						flag=true;
						prs=con.prepareStatement("delete from medtab where name=?");
						prs.setString(1, nm);
						prs.executeUpdate();
						System.out.println("Record removed Successfully.");
					}
				}
				if(flag==false)
				{
					System.out.println("Record Not Found.... Try Again.");
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
	}

	public void showParticularMedDetail(String nm)
	{
		try
		{
			prs=con.prepareStatement("select name from medtab");
			rs=prs.executeQuery();
			boolean flag=false;
			while(rs.next())
			{
				if(rs.getString(1).equals(nm))
				{	
					flag=true;
					prs=con.prepareStatement("select * from medtab where name=?");
					prs.setString(1, nm);
					ResultSet rs1=prs.executeQuery();
					
					while(rs1.next())
					{
						System.out.print("Med_ID: "+rs1.getInt(1));
						System.out.print(" |Name: "+rs1.getString(2));
						System.out.print(" | Price: "+rs1.getDouble(3));
						System.out.println(" | Stock: "+rs1.getInt(4));
						
					}
				}
			}
			if(flag==false)
			{
				System.out.println("Record Not Found.... Try Again.");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}

	public void updateName(String nm)
	{	
		try
		{
			prs=con.prepareStatement("select name from medtab");
			rs=prs.executeQuery();
			boolean flag=false;
			while(rs.next())
			{
				if(rs.getString(1).equals(nm))
				{	
					flag=true;
					System.out.println("Enter the New Name:");
					String n=sc.nextLine();
					
					prs=con.prepareStatement("update medtab set name=? where name=?");
					prs.setString(1, n);
					prs.setString(2, nm);
					prs.executeUpdate();
					
					System.out.println("Name Updated Successfully from '"+nm+"' to '"+n+"'.");
				}
			}
			if(flag==false)
			{
				System.out.println("Record Not Found.... Try Again.");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	public void updatePrice(String nm) {
		try
		{
			prs=con.prepareStatement("select name from medtab");
			rs=prs.executeQuery();
			boolean flag=false;
			while(rs.next())
			{
				if(rs.getString(1).equals(nm))
				{	
					flag=true;
					System.out.println("Enter the New Price:");
					Double p=sc.nextDouble();
					
					prs=con.prepareStatement("update medtab set price=? where name=?");
					prs.setDouble(1, p);
					prs.setString(2, nm);
					prs.executeUpdate();
					
					System.out.println("Price Updated Successfully.");
				}
			}
			if(flag==false)
			{
				System.out.println("Record Not Found.... Try Again.");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	public void addStock(String nm) 
	{
		try
		{
			prs=con.prepareStatement("select name from medtab");
			rs=prs.executeQuery();
			boolean flag=false;
			while(rs.next())
			{
				if(rs.getString(1).equals(nm))
				{	
					flag=true;
					System.out.println("Enter the Quantity:");
					int q=sc.nextInt();
					
					prs=con.prepareStatement("update medtab set stock=stock+? where name=?");
					prs.setInt(1, q);
					prs.setString(2, nm);
					prs.executeUpdate();
					
					System.out.println("Stock Updated Successfully.");
				}
			}
			if(flag==false)
			{
				System.out.println("Record Not Found.... Try Again.");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public void order(String nm) 
	{
		
		try
		{
			prs=con.prepareStatement("select name from medtab");
			rs=prs.executeQuery();
			boolean flag=false;
			while(rs.next())
			{
				if(rs.getString(1).equals(nm))
				{	
					flag=true;
					System.out.println("Enter how much Quantity you want:");
					int q=sc.nextInt();
					
					prs=con.prepareStatement("select stock from medtab where name=?");
					prs.setString(1, nm);
					ResultSet rs1=prs.executeQuery();
					boolean f=false;
					
					while(rs1.next())
					{
						if(q<=rs1.getInt(1))
						{
							f=true;
							System.out.println("Stock Availble ..");
							
							
							while(true)
							{
								System.out.println("PRESS 1 to confirm order OR PRESS 2 to cancel:");
								int ch=sc.nextInt();
								if(ch==1)
								{
									System.out.println("Enter your Name :");
									String cname=sc1.nextLine();
									
									prs=con.prepareStatement("update medtab set stock=stock-? where name=?");
									prs.setInt(1, q);
									prs.setString(2, nm);
									prs.executeUpdate();
									
									prs=con.prepareStatement("select price from medtab where name=?");
									prs.setString(1, nm);
									ResultSet priceRS=prs.executeQuery();
									
									while(priceRS.next())
									{
										Double pr=priceRS.getDouble(1);
										Double bill=q*pr;
										/*System.out.println("MY CHEMIST SHOP");
										System.out.println("INVOICE");
										System.out.println("Medicine Name : "+nm+ " | Quantity : "+q+" | Price : "+pr+" | Total Amount : "+bill);
										System.out.println("Thank You ........ Visit Again.");*/
										
										prs=con.prepareStatement("insert into myorder(CustName,MedName,qty,price,totalPrice) values (?,?,?,?,?)");
										prs.setString(1, cname);
										prs.setString(2, nm);
										prs.setInt(3, q);
										prs.setDouble(4, pr);
										prs.setDouble(5, bill);
										prs.executeUpdate();
										
									}
									
									prs=con.prepareStatement("select * from myorder where CustName=?");
									prs.setString(1, cname);
									rs=prs.executeQuery();
									while(rs.next())
									{
										System.out.println("MY CHEMIST SHOP");
										System.out.println("INVOICE");
										
										System.out.println("Bill No. : "+rs.getInt(1)+"  | Customer Name : "+rs.getString(2) +" | Medicine Name : "+rs.getString(3)+
												" | Quantity : "+rs.getInt(4)+" | Price : "+rs.getDouble(5)+" | Total Amount : "+rs.getDouble(6));
										System.out.println("Thank You ........ Visit Again.");
									}
									
									
									
									break;
									
									
								}
								else if(ch==2)
								{
									System.out.println("Cancelled");
									break;
								}
								else
								{
									System.out.println("Enter the valid Input:");
								}
							}
						}
					}
					if(f==false)
					{
						System.out.println("Medicine Out of Stock....");
					}
				}
				
				
			}
			if(flag==false)
			{
				System.out.println("Medicine Not Found");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
		

	
}
