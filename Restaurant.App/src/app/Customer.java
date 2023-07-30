package app;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Customer {
    
	static List<Menu> menuList;
	
static{
		
		System.out.println("                         WELCOME to BAWARCHI CUSTOMER PAGE        ");
		System.out.println("                                  Eat and Dream            "+"\n"+"\n");
		System.out.println("                             Veg and Non-Veg Restaurant            "+"\n\n\n\n\n");

}
	
	int tableNo;
	String cName;
	
	public Customer() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter You Name: ");
		this.cName=sc.nextLine();
		System.out.println("Please Enter your Table Number: ");
		this.tableNo=sc.nextInt();
		sc.nextLine();		
	
	
		
		//Hibernate related code
		SessionFactory factory=new Configuration().configure().addAnnotatedClass(Menu.class).buildSessionFactory();	
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		/////////////////////////////////////////////////
		
		List<Menu> menuList=session.createQuery("from Menu", Menu.class).list();
	
		if(menuList.size() > 1) {
			System.out.println("\n\n\n"+"Hi"+" "+this.cName);
			System.out.println("Please Check our Menu, Delicious Food Will be Dilevered at Your Table no."+tableNo+" Soon....");
			for(Menu menu: menuList) {
				System.out.println(menu);
			}
			Customer.menuList=menuList;
			
			System.out.println("\n"+"Are you ready to Place order ? please Enter response (YES/NO)");
			String res=sc.nextLine();
			
			if(res.equals("YES")) {
				this.placeOrder();
			}else if(res.equals("NO")) {
				System.out.println("ohoo...........You didn't ordered anything");
			}
		}else {
			
			System.out.println("Soory Nothing to display........Please contact Admin");
		}
	
    }
	
	public void placeOrder() {
		
		//Hibernate related code
		SessionFactory factory=new Configuration().configure().addAnnotatedClass(Order.class).buildSessionFactory();	
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		/////////////////////////////////////////////////
		
		Order order=new Order();
		order.customerName=this.cName;
		order.tableNo=this.tableNo;
		
		System.out.println("Please enter Item Code one by one(0,1,2,3....) ");
		Scanner sc=new Scanner(System.in);
		int oI=sc.nextInt();
		for(Menu menu:Customer.menuList) {
			if(menu.sn==oI) {
				order.orderedItem=menu.itemName;
			}
		}
		System.out.println("Please Enter Quatity for "+order.orderedItem+" :");
		order.quantity=sc.nextInt();
		sc.nextLine();
		session.save(order);
		tx.commit();
		System.out.println("Do you want to order More ? (YES/NO)");
		String res=sc.nextLine();
		if(res.equals("YES")) {
			placeOrder();
		}else if(res.equals("NO")) {
			
			System.out.println("Thank You ! For your Order. We will deliver your Order Soon..........");
		
		}
		System.out.println(order);
		session.close();
		factory.close();
		
		
		
	}
	
	
}
