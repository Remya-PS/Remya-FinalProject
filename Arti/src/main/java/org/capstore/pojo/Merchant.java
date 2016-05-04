package org.capstore.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Merchant {

	@Id
	@GeneratedValue
	private int merchant_id;
	private String merchant_name;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,
			targetEntity=Product.class,mappedBy="merchant")
	List<Product> products;

	public Merchant(){}
	
	public Merchant(String merchant_name) {
		super();
		
		this.merchant_name = merchant_name;
	
	}
	
	
	public Merchant(int merchant_id, String merchant_name, List<Product> products) {
		super();
		this.merchant_id = merchant_id;
		this.merchant_name = merchant_name;
		this.products = products;
	}

	public int getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(int merchant_id) {
		this.merchant_id = merchant_id;
	}

	public String getMerchant_name() {
		return merchant_name;
	}

	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}


	/*@Override
	public String toString() {
		return "Merchant [ products=" + products
				+ "]";
	}*/
	
	
	
}
