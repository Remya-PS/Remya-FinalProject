package org.capstore.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private int product_id;
	
	@NotNull
	private String product_name;
	@NotNull
	private String specification;
	
	@NotEmpty(message="*Price is mandatory!")
	private double price;

	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="product_customer_table",
		joinColumns={@JoinColumn(name="product_id")},
		inverseJoinColumns={@JoinColumn(name="customer_id")})
	private List<Customer> customer=new ArrayList<Customer>();
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="product_cart_table",
		joinColumns={@JoinColumn(name="product_id")},
		inverseJoinColumns={@JoinColumn(name="cart_id")})
	private List<Cart> cart=new ArrayList<Cart>();
		
	public Product(){}
	
	
	public Product(int product_id, String product_name, String specification, double price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.specification = specification;
		this.price = price;
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
		return specification;
	}


	public void setSpecification(String specification) {
		this.specification = specification;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", specification="
				+ specification + ", price=" + price + "]";
	}
	
	
	}
