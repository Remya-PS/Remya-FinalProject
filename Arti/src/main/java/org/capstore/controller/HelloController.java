package org.capstore.controller;

import org.capstore.dao.CustomerDaoImpl;
import org.capstore.dao.CustomerDaoInterface;
import org.capstore.service.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/initialize")
public class HelloController {

	@Autowired
	public CustomerServiceInterface service;
	
	@Autowired
	public CustomerDaoInterface dao;
	
	/*@RequestMapping("/hello")
	public ModelAndView sayHello(){
		String message="Hello Spring MVC";
		service.search();

		return service.search();
	}*/
	
	
}
