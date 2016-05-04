package org.capstore.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private int product_id;
	private String product_name;
	
	
	private String Specification;
	private double price;
	private Date date_of_posting;
	
	private int no_of_times_product_visited;
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,
			targetEntity=Category.class)
	@JoinColumn(name="category_id")
	private Category category;


	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,
			targetEntity=Brand.class)
	@JoinColumn(name="brand_id")
	private Brand brand;
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="sub_category_id_FK")
	private Sub_category sub_category;
	

	public Sub_category getSub_category() {
		return sub_category;
	}


	public void setSub_category(Sub_category sub_category) {
		this.sub_category = sub_category;
	}


	public Merchant getMerchant() {
		return merchant;
	}


	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}


	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="merchant_id_FK")
	private Merchant merchant;
	
	public Product(){}


	public Product( String product_name, String specification, double price, Date date_of_posting,
			int no_of_times_product_visited, Category category, Brand brand, Sub_category sub_category,
			Merchant merchant) {
		super();
		
		this.product_name = product_name;
		Specification = specification;
		this.price = price;
		this.date_of_posting = date_of_posting;
		this.no_of_times_product_visited = no_of_times_product_visited;
		this.category = category;
		this.brand = brand;
		this.sub_category = sub_category;
		this.merchant = merchant;
	}



	public Product(int product_id, String product_name, String specification, double price, Date date_of_posting,
			int no_of_times_product_visited, Category category, Brand brand, Sub_category sub_category,
			Merchant merchant) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		Specification = specification;
		this.price = price;
		this.date_of_posting = date_of_posting;
		this.no_of_times_product_visited = no_of_times_product_visited;
		this.category = category;
		this.brand = brand;
		this.sub_category = sub_category;
		this.merchant = merchant;
	}


	public int getProduct_id() {
		return product_id;
	}


	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public String getSpecification() {
		return Specification;
	}


	public Brand getBrand() {
		return brand;
	}


	public void setBrand(Brand brand) {
		this.brand = brand;
	}


	public void setSpecification(String specification) {
		Specification = specification;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Date getDate_of_posting() {
		return date_of_posting;
	}


	public void setDate_of_posting(Date date_of_posting) {
		this.date_of_posting = date_of_posting;
	}


	public int getNo_of_times_product_visited() {
		return no_of_times_product_visited;
	}


	public void setNo_of_times_product_visited(int no_of_times_product_visited) {
		this.no_of_times_product_visited = no_of_times_product_visited;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", Specification="
				+ Specification + ", price=" + price + ", date_of_posting=" + date_of_posting
				+ ", no_of_times_product_visited=" + no_of_times_product_visited + ", category=" + category + ", brand="
				+ brand + ", sub_category=" + sub_category + ", merchant=" + merchant + "]";
	}
	 
	
	
	
	
}
