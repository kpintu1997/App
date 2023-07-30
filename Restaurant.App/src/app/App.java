package app;




import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	
	static{
		
		System.out.println("                                 WELCOME TO BAWARCHI         ");
		System.out.println("                                    Eat and Dream            "+"\n"+"\n");
		System.out.println("                             Veg and Non-Veg Restaurant            "+"\n\n\n\n\n");
		
		
		System.out.println("Please Select    "+"\n"
		                  +"1. ADMIN (Select To Change Menu)"+"\n"
		                  +"2. Customer (Select To Order Yummy Food)"+"\n");
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter Response(1 or 2): ");
		int res=sc.nextInt();
		
		if(res==1) {
			
			if(Admin.authenticate()) {
				
			}else {
				System.out.println("Authentication Failed...... ");
				System.out.println("Redirecting User to Home Page........................................");
			}
		
		}else if(res==2) {
			Customer c=new Customer();
			
		}
		
		

	}

}
