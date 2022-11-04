package com.basic.naver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("Naver")
public class NaverContorller {

	@Autowired
	
	//private static String clientID = "90qYXg5ocmYZBSUUgGrc";
	//private static String clientSecret = "aVh1gplt9H";
	
	
	@RequestMapping("SearchForm")
	public ModelAndView searchForm() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("/naver/searchForm");
		return mv;

	}

	@RequestMapping("Search")
	public ModelAndView search(String keyword) {
		ModelAndView mv = new ModelAndView();
		
		
		mv.setViewName("");
		return mv;
	}
	
	

}
