package org.capstore.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class MainClass {

	public static void main(String[] args) {
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(Cart.class);
		config.addAnnotatedClass(Product.class);
		config.addAnnotatedClass(Customer.class);
		
		config.configure();
		
		new SchemaExport(config).create(true,true);
		
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
				
		Product product=new Product("Laptop", "Hp Black", 23000);
		Product product1=new Product("DiningSet","Induction", 2500);
		Product product2=new Product("SofaSet", "Teak", 30000);
		Product product3=new Product("Fridge", "Samsung", 20000);
		
		Customer customer=new Customer(111, "Remya");
		Customer customer1=new Customer(222, "Padma");
		Customer customer2=new Customer(333, "Jayaraj");
		Customer customer3=new Customer(444, "Subi");
		
		session.beginTransaction();
		session.save(product);
		session.save(product1);
		session.save(product2);
		session.save(product3);
		session.save(customer);
		session.save(customer1);
		session.save(customer2);
		session.save(customer3);
	
		session.getTransaction().commit();
		session.close();
		
		
	}

}
