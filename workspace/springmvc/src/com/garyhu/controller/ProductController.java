package com.garyhu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.garyhu.pojo.Product;

@Controller
public class ProductController {

//	@RequestMapping("/index")
//	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//		ModelAndView mav = new ModelAndView("showProduct");
//		Product product = new Product();
//		String name = req.getParameter("name");
//		float price = Float.parseFloat(req.getParameter("price"));
//		product.setName(name);
//		product.setPrice(price);
//		mav.addObject("product",product);
//		return mav;
//	}
	
	@RequestMapping("/addProduct")
	public ModelAndView add(Product product) throws Exception {
		ModelAndView mav = new ModelAndView("showProduct");
		return mav;
	}
	
}
