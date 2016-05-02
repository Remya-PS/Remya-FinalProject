package org.capstore.service;

import java.util.List;

import org.capstore.dao.CartDao;
import org.capstore.domain.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao cartDao;
	
	@Transactional
	public void saveCartItems(Cart cart) {
		cartDao.saveCartItems(cart);
		
	}

	@Transactional
	public List<Cart> getAllCartItems() {
		return cartDao.getAllCartItems();
	}

	@Transactional
	public void deleteCartItems(Integer product_id) {
		cartDao.deleteCartItems(product_id);
		
	}

	public Cart searchCartItems(Integer product_id) {
		return cartDao.searchCartItems(product_id);
	}

	//@Transactional
	/*public void updateCartItems(Cart cart) {
		cartDao.updateCartItems(cart);
		
	}*/

	

}
