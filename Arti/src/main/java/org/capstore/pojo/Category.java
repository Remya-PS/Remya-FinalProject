package org.capstore.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Generated;

@Entity
public class Category {
	

	@Id
	@GeneratedValue
	private int category_id;
	private String category_name;
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,
			targetEntity=Product.class,mappedBy="category")
	private List<Product> products;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,
			targetEntity=Brand.class,mappedBy="category")
	private List<Brand> brands;
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,
			targetEntity=Sub_category.class,mappedBy="category")
	private List<Sub_category> sub_category;
	
	
	//no argument constructors
	public Category(){}


	public Category(String category_name, List<Product> products, List<Brand> brands,
			List<Sub_category> sub_category) {
		super();
		
		this.category_name = category_name;
		this.products = products;
		this.brands = brands;
		this.sub_category = sub_category;
	}

	
	
	public Category(int category_id, String category_name, List<Product> products, List<Brand> brands,
			List<Sub_category> sub_category) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.products = products;
		this.brands = brands;
		this.sub_category = sub_category;
	}


	public int getCategory_id() {
		return category_id;
	}


	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}


	public String getCategory_name() {
		return category_name;
	}


	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public List<Brand> getBrands() {
		return brands;
	}


	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}


	public List<Sub_category> getSub_category() {
		return sub_category;
	}


	public void setSub_category(List<Sub_category> sub_category) {
		this.sub_category = sub_category;
	}


	/*@Override
	public String toString() {
		return "Category [category_name=" + category_name + "]";
	}
*/
	
	
}
