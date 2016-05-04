package org.capstore.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sub_category {
	
	@Id
	@GeneratedValue
	private int sub_category_id;
	private String sub_category_name;
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="category_id_FK")
	private Category category;

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,
			targetEntity=Product.class,mappedBy="sub_category")
	private List<Product> product;
	
	
	public Sub_category(){}


	

	public Sub_category(String sub_category_name, Category category, List<Product> product) {
		super();
		
		this.sub_category_name = sub_category_name;
		this.category = category;
		this.product = product;
	}
	
	public Sub_category(int sub_category_id, String sub_category_name, Category category, List<Product> product) {
		super();
		this.sub_category_id = sub_category_id;
		this.sub_category_name = sub_category_name;
		this.category = category;
		this.product = product;
	}




	public int getSub_category_id() {
		return sub_category_id;
	}




	public void setSub_category_id(int sub_category_id) {
		this.sub_category_id = sub_category_id;
	}




	public String getSub_category_name() {
		return sub_category_name;
	}




	public void setSub_category_name(String sub_category_name) {
		this.sub_category_name = sub_category_name;
	}




	public Category getCategory() {
		return category;
	}




	public void setCategory(Category category) {
		this.category = category;
	}




	public List<Product> getProduct() {
		return product;
	}




	public void setProduct(List<Product> product) {
		this.product = product;
	}




	/*@Override
	public String toString() {
		return "Sub_category [sub_category_id=" + sub_category_id + ", sub_category_name=" + sub_category_name
				+ ", category=" + category + "]";
	}*/
	
	
	
	
	
	
}
