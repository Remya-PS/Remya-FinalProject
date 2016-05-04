package org.capstore.service;

import java.util.List;

import org.capstore.dao.ProductDao;
import org.capstore.dao.ProductDaoImpl;
import org.capstore.pojo.Brand;
import org.capstore.pojo.Merchant;

import org.capstore.pojo.Sub_category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller("productservice")
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productdao=new ProductDaoImpl();
	
	@Transactional
	public List<Brand> getAllBrands() {
		
		return productdao.getAllBrands();
	}

	@Transactional
	public List<Merchant> getAllMerchants() {
		// TODO Auto-generated method stub
		return productdao.getAllMerchants();
	}

	@Transactional
	public List<Sub_category> getAllSub_category() {
		// TODO Auto-generated method stub
		return productdao.getAllSub_category();
	}

	

}
