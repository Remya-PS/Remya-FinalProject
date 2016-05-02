package org.capstore.dao;

import java.util.List;

import org.capstore.domain.Cart;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDaoImpl implements CartDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveCartItems(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		
	}
	

	public List<Cart> getAllCartItems() {		
		return sessionFactory.getCurrentSession().createQuery("FROM Product P where P.product_id=1").list();
	}

	public void deleteCartItems(Integer product_id) {
		Cart cart=(Cart)sessionFactory.getCurrentSession().get(Cart.class, product_id);
		if(cart!=null)
			sessionFactory.getCurrentSession().delete(cart);
		
		
	}


	public Cart searchCartItems(Integer product_id) {
		Cart cart=(Cart) sessionFactory.getCurrentSession().get(Cart.class, product_id);		
		return cart;
	}

	
	/*public void updateCartItems(Cart cart) {
		// TODO Auto-generated method stub
		
	}
*/
	

}
