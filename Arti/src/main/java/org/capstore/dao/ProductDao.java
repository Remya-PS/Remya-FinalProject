package org.capstore.dao;

import java.util.List;

import org.capstore.pojo.Brand;
import org.capstore.pojo.Merchant;

import org.capstore.pojo.Sub_category;

public interface ProductDao {

	
	public List<Brand> getAllBrands();
	public List<Merchant> getAllMerchants();
	public List<Sub_category> getAllSub_category();
	
}
