package org.capstore.controller;

import java.util.Map;

import org.capstore.pojo.Product;
import org.capstore.service.CategoryService;
import org.capstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/creating")
public class ProductController {

	@Autowired
	public CategoryService categoryService;
	
	@Autowired
	public ProductService productservice;
	
	@RequestMapping("/ProductForm")
	public String showProductForm(Map<String, Object> maps){
	/*	SimpleDateFormat myFormat=new SimpleDateFormat("dd-MMM-yyyy");
		List<Employee> employees= employeeService.getAllEmployees();
		maps.put("emps",employees);
		maps.put("empSearch",searchEmployee);*/
		maps.put("prod",new Product());
		maps.put("category", categoryService.getAllCategories());
		maps.put("brands", productservice.getAllBrands());
		maps.put("merchants", productservice.getAllMerchants());
		maps.put("sub_categories", productservice.getAllSub_category());
	
		 return "Product";
	}
	
	
	
	
}
