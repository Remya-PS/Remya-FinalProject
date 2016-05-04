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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private int customer_id;
	
	@NotEmpty(message="*Cart Id should be generated for each Customer")
	private int cart_id;
	
	@NotNull(message="*Customer Name is must")
	private String customer_name;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	/*@JoinColumn(name="CustCart_FK")*/
	private Cart cart;
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,
			targetEntity=Product.class,mappedBy="customer")
	@JoinTable(name="product_customer_table",
	joinColumns={@JoinColumn(name="customer_id")},
	inverseJoinColumns={@JoinColumn(name="product_id")})
	private List<Product> product=new ArrayList<Product>();
	/*@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="product_customer_table",
		joinColumns={@JoinColumn(name="customer_id")},
		inverseJoinColumns={@JoinColumn(name="product_id")})
	private List<Product> product=new ArrayList<Product>();*/

//--------------------------------------------POJO-----------------------------------------
	
	
	public Customer(){}


	public Customer(int cart_id, String customer_name) {
	super();
	this.cart_id = cart_id;
	this.customer_name = customer_name;
	
}


	public Customer(int customer_id, int cart_id, String customer_name, Cart cart, List<Product> product) {
		super();
		this.customer_id = customer_id;
		this.cart_id = cart_id;
		this.customer_name = customer_name;
		this.cart = cart;
		this.product = product;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", cart_id=" + cart_id + ", customer_name=" + customer_name
				+ ", cart=" + cart + ", product=" + product + "]";
	}
	
}

