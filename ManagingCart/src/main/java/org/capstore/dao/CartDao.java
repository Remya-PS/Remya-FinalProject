package org.capstore.dao;

import java.util.List;

import org.capstore.domain.Cart;
import org.capstore.domain.Customer;

public interface CartDao {

	public void saveCartItems(Cart cart);
	
	public List<Cart> getAllCartItems(Customer customer);
	
	public void deleteCartItems(Integer product_id);
	
	public Cart searchCartItems(Integer product_id);
	
}
