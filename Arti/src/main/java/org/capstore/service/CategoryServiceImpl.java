package org.capstore.service;

import java.util.List;

import org.capstore.dao.CategoryDao;
import org.capstore.dao.CategoryDaoImpl;
import org.capstore.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Controller("categoryservice")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao=new CategoryDaoImpl();
	
	
	@Transactional
	public List<Category> getAllCategories() {
		
		return categoryDao.getAllCategories();
	}

}
