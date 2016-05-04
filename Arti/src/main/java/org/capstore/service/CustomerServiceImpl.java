package org.capstore.service;

import java.util.List;

import org.capstore.dao.CustomerDaoImpl;
import org.capstore.dao.CustomerDaoInterface;
import org.capstore.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

@Controller("customerservice")
public class CustomerServiceImpl implements CustomerServiceInterface {

	@Autowired
	CustomerDaoImpl dao;

	
	@Transactional
	public List<Product> getAllProducts() {
		
		return dao.getAllProducts();
	}


	@Override
	@Transactional
	public List<Product> search(List<Product> allData) {
		
		return dao.searchCustomer(allData);
	}


	@Override
	public Product searchWith(Product product1) {
		
		return dao.searchWith(product1);
	}
	 
} 
