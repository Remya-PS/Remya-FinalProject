package org.capstore.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class TestClass {
	public static void main(String[] args) {
		AnnotationConfiguration config=new AnnotationConfiguration();
		config.addAnnotatedClass(Cart.class);
		config.addAnnotatedClass(Product.class);
		config.addAnnotatedClass(Customer.class);
		config.configure();
					
		new SchemaExport(config).create(true, true);
				
		SessionFactory factory= config.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		Product product=new Product();
		product.setProduct_name("Laptop");
		product.setSpecification("Black");
		product.setPrice(23000);
		
		Customer customer=new Customer();
		customer.setFirst_name("Remya");		
		
		session.save(product);
		session.save(customer);
		
		session.getTransaction().commit();		
		session.close();
	
		
		
	}

}
