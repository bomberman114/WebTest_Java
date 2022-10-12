package com.basic.write.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.basic.write.service.WriteService;

@Controller
@RequestMapping("Write")
public class WriteController {
	
	@Autowired
	//private WriteService wriService;
	
	@RequestMapping("WriteForm")
	public ModelAndView writeForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/writeForm");
		return mv;
	}
	
}
