package org.capstore.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Cart {
		
	private int cart_id;
	private int product_id;
		
	@NotEmpty(message="*Atleast one item shold be purchased")
	private int quantity;
	
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="customer_id_FK")
	private Customer customer;
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,
			targetEntity=Product.class,mappedBy="cart")
	@JoinColumn(name="product_id_FK")
	private List<Product> product=new ArrayList<Product>();



	//--------------------------------------------POJO-----------------------------------------

	
	public Cart(){}
	
	public Cart(int cart_id, int product_id, int quantity, Customer customer, List<Product> product) {
		super();
		this.cart_id = cart_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.customer = customer;
		this.product = product;
	}


	public Cart(int cart_id, int product_id, int quantity) {
		super();
		this.cart_id = cart_id;
		this.product_id = product_id;
		this.quantity = quantity;
	}
		

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}


	public int getProduct_id() {
		return product_id;
	}


	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public List<Product> getProduct() {
		return product;
	}


	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", product_id=" + product_id + ", quantity=" + quantity + ", customer="
				+ customer + ", product=" + product + "]";
	}
	
}
