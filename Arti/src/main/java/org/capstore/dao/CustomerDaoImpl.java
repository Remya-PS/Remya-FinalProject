package org.capstore.dao;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

import org.capstore.pojo.Product;
import org.capstore.service.CustomerServiceInterface;
import org.hibernate.SessionFactory;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("customerdao")
public class CustomerDaoImpl  implements CustomerDaoInterface{

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private CustomerServiceInterface service;
	

	//Method to retrieve all the product list from the database
	@Override
	public List<Product> getAllProducts() {
		System.out.println("Entered into Customer Dao");
		List<Product> productList=new ArrayList<>();
		
		productList=sessionFactory.getCurrentSession().createQuery("from Product").list();
		
		System.out.println("List got from DB is"+productList.size());
		return productList;
	}

	
	//Method to get all DataBase Data
	@Override
	public List<Product> searchCustomer(List<Product> allData) {
		
		List<Product> gotAllData=allData;
		
	
		return gotAllData;
	}
	
	


	public Product searchWith(Product product1) {
		Product searchObject=product1;
		Product resultObj=new Product();
		List<Product> productList=service.getAllProducts();
		
		for(Product pro1:productList){
			
			if(pro1.getProduct_name().equals(searchObject.getProduct_name())){
				System.out.println("Matched:"+pro1);
				resultObj=pro1;
				break;
			}
			
		}
		
		//Insert Code to compare the searchObject and pro1
		
		return resultObj;
	}
	
	

}
