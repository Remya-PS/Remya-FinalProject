package org.capstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.capstore.domain.Cart;
import org.capstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


	@Controller
	public class CartController {
		
	@Autowired
	private CartService cartService;
	private Cart cartList;
	
	@RequestMapping("/addCart")
	public String insertCartTable(Map<String, Object> maps){
		
		List<Cart> cartitems= cartService.getAllCartItems();
		
		maps.put("carts", cartitems);		
		maps.put("cart", new Cart());
		
		return "cartManagement";
	}
	
	@RequestMapping(value={"/saveCartItems","/updateCartItems"}, method=RequestMethod.POST)
	public String showCartDetails(Map<String,Object> map,@Valid @ModelAttribute("cart") Cart cart,BindingResult result){
				
		List<Cart> cartitems =cartService.getAllCartItems();
		
		map.put("cart", cartitems);
		
		if(result.hasErrors())
			{
				return "cartManagement";
			}
		else{
				cartService.saveCartItems(cart);
				return "redirect:/addcart";
			}
	}
	@RequestMapping("/deleteCartItems/{product_id}")
	public String deleteCartItems(@PathVariable("product_id") Integer product_id)
		{
			cartService.deleteCartItems(product_id);
			return "redirect:/addcart";
			
		}
	
	/*@RequestMapping("/updateCartItems/{product_id}")
	public String updateCartItems(@PathVariable("product_id") Integer product_id){
		Cart cart=cartService.search
		
	}*/
			
}
