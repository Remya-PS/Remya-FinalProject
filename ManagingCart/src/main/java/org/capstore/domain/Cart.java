package org.capstore.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

public class Cart {
	
	@Id
	@GeneratedValue
	private int serial_no;
	
	private int cart_id;;
	private int product_id;
	private int customer_id;
	
	@NotEmpty(message="*Atleast one item shold be purchased")
	private int quantity;
	@NotEmpty(message="*Product discountedPrice should not be empty")
	private double discountedPrice;
	@NotEmpty(message="*Total price should not be empty")
	private double total;
	
	private Customer customer;
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,
			targetEntity=Product.class,mappedBy="cart")
	private List<Product> product=new ArrayList<Product>();

	//--------------------------------------------POJO-----------------------------------------

	
	public Cart(){}
	
	public Cart(int serial_no, int cart_id, int product_id, int customer_id, int quantity, double discountedPrice,
			double total, Customer customer, List<Product> product) {
		super();
		this.serial_no = serial_no;
		this.cart_id = cart_id;
		this.product_id = product_id;
		this.customer_id = customer_id;
		this.quantity = quantity;
		this.discountedPrice = discountedPrice;
		this.total = total;
		this.customer = customer;
		this.product = product;
	}
	
	public int getSerial_no() {
		return serial_no;
	}	


	public void setSerial_no(int serial_no) {
		this.serial_no = serial_no;
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
		return "Cart [serial_no=" + serial_no + ", cart_id=" + cart_id + ", product_id=" + product_id + ", customer_id="
				+ customer_id + ", quantity=" + quantity + ", discountedPrice=" + discountedPrice + ", total=" + total
				+ ", customer=" + customer + ", product=" + product + "]";
	}	
	

}
