package org.capstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.capstore.dao.CustomerDaoImpl;
import org.capstore.dao.CustomerDaoInterface;
import org.capstore.pojo.Product;
import org.capstore.service.CustomerServiceImpl;
import org.capstore.service.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/searching")
public class SearchController {

	
	@Autowired
	CustomerServiceInterface service;
	
	@Autowired
	CustomerDaoInterface dao;
	
	
	@RequestMapping("/search")
	public String showSearchCustomer(Map<String, Object> maps){
		maps.put("product", new Product());
		List<Product> allData=service.getAllProducts();
		service.search(allData);
		System.out.println("Got this all data"+allData);
		return "searchResult";
	}
	
	
	@RequestMapping(value="/searching1",method=RequestMethod.POST)
	public String showSearchResults(@ModelAttribute("product") Product product1, BindingResult result,Map<String, Object> maps){
		
		System.out.println(product1);
	
		Product resultNew=service.searchWith(product1);
		maps.put("result", resultNew);
		return "showSerRes";
	}
	
	
}
