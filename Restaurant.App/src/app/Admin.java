package app;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Admin {
	
	static{
		
		System.out.println("                         WELCOME to BAWARCHI ADMIN PAGE        ");
		System.out.println("                                  Eat and Dream            "+"\n"+"\n");
		System.out.println("                             Veg and Non-Veg Restaurant            "+"\n\n\n\n\n");

		
	}
	
	public static boolean authenticate() {
		boolean auth=true;
		Scanner sc= new Scanner(System.in);
		String username;
		String password;
		
		//Authenticating User
		System.out.println("         Please Authenticate yourself");
		System.out.println("Enter Username and Password (Case sensitive)");
		System.out.println("Username: ");		
		username=sc.nextLine();
		System.out.println("Password: ");
		password=sc.nextLine();
		
		//Validating
		if(username.equals("kpintu1997") && password.equals("1234")) {
			//validation Successful
			System.out.println("\n"+"Authenticattion Successful..........................."+"\n");
			System.out.println("Please select What you want to do : "+"\n" 
			+"1. ADD Menu"+"\n"
		    +"2. Edit Menu "+"\n");
			int adminResp=sc.nextInt();
			if(adminResp==1) {
				Admin.add();
			}			
			return true;
		}
		else {
			//Validation Failed
			System.out.println("Authentication Failed...... ");
			
			//Re-Validating 
			System.out.println("Entered Username and Password is Incorrect. Want to try again (True/False).................");
			auth=sc.nextBoolean();
			if(auth) {			
			Admin.authenticate();
			}
			return false;
			
		}
			
		
	}

public static void add() {
	//Hibernate related code
	SessionFactory factory=new Configuration().configure().addAnnotatedClass(Menu.class).buildSessionFactory();	
	Session session=factory.openSession();
	Transaction tx=session.beginTransaction();
	/////////////////////////////////////////////////
	
	    
		Scanner sc=new Scanner(System.in);
		Menu menu=new Menu();
		
		//take user input
		System.out.println("Please enter name of Item : ");
		menu.itemName=sc.nextLine();
		System.out.println("Please enter Rate of Item : ");
		menu.rate=sc.nextFloat();
		sc.nextLine();
		
		//commit menu object in DB
		session.save(menu);
		tx.commit();
		session.close();
		factory.close();
		
		//asking user if more menu to be added
		System.out.println("Do you want to add more (YES/NO)");		
		String resp=sc.nextLine();
		System.out.println("Value: "+resp);
		if(resp.equals("YES")) {
			System.out.println("\n"+"**************************************");
			Admin.add();
		}
		
		//Display what new menu has been added in this transaction
		System.out.println("\n"+"Thank You Below Items Has been added successfully ");
		System.out.println(menu);
		
		
		
	
		
	}
}
