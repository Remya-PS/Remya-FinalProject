package org.capstore.dao;

import java.util.ArrayList;
import java.util.List;

import org.capstore.pojo.Brand;
import org.capstore.pojo.Category;
import org.capstore.pojo.Merchant;

import org.capstore.pojo.Sub_category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller("productdao")
public class ProductDaoImpl implements ProductDao{

	

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public List<Brand> getAllBrands() {
		List< Brand> brands=sessionFactory.getCurrentSession().createQuery("from Brand").list();
		
		System.out.println(brands);
		
		return brands;
	}

	@Override
	public List<Merchant> getAllMerchants() {
		
	List< Merchant> merchants=sessionFactory.getCurrentSession().createQuery("from Merchant").list();
		
		System.out.println(merchants);
		
		return merchants;
	}
 
	@Override
	public List<Sub_category> getAllSub_category() {
	List< Sub_category> sub_category=sessionFactory.getCurrentSession().createQuery("from Sub_category").list();
		
		System.out.println(sub_category);
		
		return sub_category;
	}

	
}
