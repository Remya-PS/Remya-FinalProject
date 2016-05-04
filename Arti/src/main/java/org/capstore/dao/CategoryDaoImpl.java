package org.capstore.dao;

import java.util.List;

import org.capstore.pojo.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
@Controller("categorydao")
public class CategoryDaoImpl implements CategoryDao{

	
	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public List<Category> getAllCategories() {
		
		
		List<Category> cat=sessionFactory.getCurrentSession().createQuery("from Category").list();
		
		System.out.println(cat);
		return cat;
}
	
	
}
