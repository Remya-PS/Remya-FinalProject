package org.capstore.service;

import java.util.List;

import org.capstore.pojo.Brand;
import org.capstore.pojo.Merchant;

import org.capstore.pojo.Sub_category;

public interface ProductService {

	
	public List<Brand> getAllBrands();
	
	public List<Merchant> getAllMerchants();
	public List<Sub_category> getAllSub_category();

}
