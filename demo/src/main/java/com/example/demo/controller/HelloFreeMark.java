package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/freemark")
public class HelloFreeMark {

	@RequestMapping("/say")
	public ModelAndView say() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("message","你好，spring boot");
		modelAndView.setViewName("hello");
		
		return modelAndView;
	}
}
