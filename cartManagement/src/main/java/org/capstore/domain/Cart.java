package org.capstore.domain;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Controller;

@Entity
public class Cart {

	@Id
	@GeneratedValue	
	private int serialNo;
	
	@NotNull	
	private int cart_id;
	
	@NotNull	
	private int product_id;
	
	@NotNull	
	private int customer_id;
	
	@NotEmpty(message="*Please select atleast one item!")
	private int quantity;
	
	@NotEmpty
	private double discountedPrice;
	
	@NotEmpty
	private double total;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="cart_customer_table",
		joinColumns={@JoinColumn(name="cart_id")},
		inverseJoinColumns={@JoinColumn(name="customer_id")})
	private List<Customer> customer=new ArrayList<Customer>();
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="cart_product_table",
		joinColumns={@JoinColumn(name="cart_id")},
		inverseJoinColumns={@JoinColumn(name="product_id")})
	private List<Product> product=new ArrayList<Product>();
	
	
	public Cart(){}


	public Cart(int serialNo, int cart_id, int product_id, int customer_id, int quantity, double discountedPrice,
			double total, List<Customer> customer, List<Product> product) {
		super();
		this.serialNo = serialNo;
		this.cart_id = cart_id;
		this.product_id = product_id;
		this.customer_id = customer_id;
		this.quantity = quantity;
		this.discountedPrice = discountedPrice;
		this.total = total;
		this.customer = customer;
		this.product = product;
	}


	public int getSerialNo() {
		return serialNo;
	}


	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
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


	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getDiscountedPrice() {
		return discountedPrice;
	}


	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public List<Customer> getCustomer() {
		return customer;
	}


	public void setCustomer(List<Customer> customer) {
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
		return "Cart [serialNo=" + serialNo + ", cart_id=" + cart_id + ", product_id=" + product_id + ", customer_id="
				+ customer_id + ", quantity=" + quantity + ", discountedPrice=" + discountedPrice + ", total=" + total
				+ ", customer=" + customer + ", product=" + product + "]";
	};
	
	
	
}