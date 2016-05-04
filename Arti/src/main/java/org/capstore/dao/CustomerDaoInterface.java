package org.capstore.dao;


import java.util.List;


import org.capstore.pojo.Product;
import org.springframework.web.servlet.ModelAndView;

public interface CustomerDaoInterface {

	public List<Product> searchCustomer(List<Product> allData);
	
	public Product searchWith(Product product1);

	public List<Product> getAllProducts();


	
	
	//public Product searchProducts(Integer employeeId);
	
	
}
