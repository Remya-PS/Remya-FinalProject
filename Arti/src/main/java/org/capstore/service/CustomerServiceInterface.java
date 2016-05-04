package org.capstore.service;

import java.util.List;

import org.capstore.pojo.Product;
import org.springframework.web.servlet.ModelAndView;import antlr.debug.Event;

public interface CustomerServiceInterface {

	
	public List<Product> search(List<Product> allData);
	public List<Product> getAllProducts();
	public Product searchWith(Product product1);
	
	
}
