package com.garyhu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController{

	@RequestMapping("/index")
	public ModelAndView handleRequest(HttpServletRequest res, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("message","Hello Spring MVC");
		return mav;
	}
	
	@RequestMapping("/jump")
	public ModelAndView jump() {
		ModelAndView mav = new ModelAndView("redirect:/index");
		return mav;
	}
	
	@RequestMapping("/check")
	public ModelAndView check(HttpSession session) {
		Integer i = (Integer)session.getAttribute("count");
		if(i==null)
			i = 0;
		i++;
		session.setAttribute("count", i);
		ModelAndView mav = new ModelAndView("check");
		return mav;
	}

}
