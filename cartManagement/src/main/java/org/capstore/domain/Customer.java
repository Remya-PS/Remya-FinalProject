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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue	
	private int customer_id;
	
	@NotEmpty(message="*Customer name should not be empty!")
	private String first_name;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="product_customer_table",
		joinColumns={@JoinColumn(name="customer_id")},
		inverseJoinColumns={@JoinColumn(name="product_id")})
	private List<Product> product=new ArrayList<Product>();
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="cart_customer_table",
		joinColumns={@JoinColumn(name="customer_id")},
		inverseJoinColumns={@JoinColumn(name="cart_id")})
	private List<Cart> cart=new ArrayList<Cart>();
	

	public Customer(){}
	
	public Customer(int customer_id, String first_name) {
		super();
		this.customer_id = customer_id;
		this.first_name = first_name;
	}


	public int getCustomer_id() {
		return customer_id;
	}



	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", first_name=" + first_name + "]";
	}
		

}
