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
	/*@RequestMapping("/carts")*/
	public class CartController {
		
	@Autowired
	private CartService cartService;
	private Cart cartList;
	private Cart searchCartItems=null;
	
	@RequestMapping(value="/saveToCart",method=RequestMethod.POST)
	public ModelAndView saveCartItems(@Valid @ModelAttribute("cart") Cart cart,
			BindingResult result){
		
		if(!result.hasErrors()){
			System.out.println(cart);
			cartService.saveCartItems(cart);
			return new ModelAndView("redirect:ProductPage");
		}else
		{
			return new ModelAndView("ProductPage");
		}
	
		
	}
	
	@RequestMapping(value="/displayCart",method=RequestMethod.POST)
	public String showCartItems(Map<String, Object> maps,
			@Valid @ModelAttribute("cart") Cart cart, BindingResult result){
		cart.getCustomer();
		List<Cart> cartitems= cartService.getAllCartItems(cart.getCustomer());
		
		maps.put("carts", cartitems);		
		maps.put("cart", new Cart());
		
		return "managementOfCart";
	}
	
	//@RequestMapping(value={"/saveCartItems","/updateCartItems"}, method=RequestMethod.POST)
	/*public String showCartDetails(Map<String,Object> map,@Valid @ModelAttribute("cart") Cart cart,BindingResult result){
				
		List<Cart> cartitems =cartService.getAllCartItems();
		
		map.put("cart", cartitems);
		
		if(result.hasErrors())
			{
				return "cartManagement";
			}
		else{		cartService.saveCartItems(cart);
				return "redirect:/addcart";
			}*/
	//}
	@RequestMapping("/deleteCartItems/{product_id}")
	public String deleteCartItems(@PathVariable("product_id") Integer product_id)
		{
			cartService.deleteCartItems(product_id);
			return "redirect:/managementOfCart";
			
		}
	
	@RequestMapping("/updateCartItems/{product_id}")
	public String updateCartItems(@PathVariable("product_id") Integer product_id){
		Cart cart=cartService.searchCartItems(product_id);
		searchCartItems=cart;
		 //System.out.println(emp);
		return"redirect:/managementOfCart";
	}
			
}
