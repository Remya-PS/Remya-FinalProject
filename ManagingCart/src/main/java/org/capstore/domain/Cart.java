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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Cart {
		
	/*private int cart_id;
	private int product_id;*/
	@Id
	@GeneratedValue
	private int serialNo;
	
	@NotNull(message="*Quantity cannot be null")
	@NotEmpty(message="*Atleast one item should be purchased")
	private int quantity;
	
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="cart_id")
	private Customer customer;
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,
			targetEntity=Product.class,mappedBy="cart")
	@JoinColumn(name="product_id")
	private List<Product> product=new ArrayList<Product>();


	//--------------------------------------------POJO-----------------------------------------

	public Cart(){}
	
	public Cart(int quantity) {
		super();
		this.quantity = quantity;
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
		return "Cart [quantity=" + quantity + ", customer=" + customer + ", product=" + product + "]";
	}

	
	
}
