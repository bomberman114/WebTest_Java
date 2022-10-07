package com.basic.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.basic.menu.service.MenuService;
import com.basic.user.service.UserSerivice;

@Controller
@RequestMapping("Menu")
public class MenuController {
	@Autowired
	private MenuService menuService;

	@RequestMapping("CreatForm")
	public ModelAndView menuForm(String username, String adminToken) {
		ModelAndView mv = new ModelAndView();
		System.out.println(username +","+ adminToken );
		mv.addObject("adminToken", adminToken);
		mv.addObject("userid", username);
		mv.setViewName("menu/creatForm");
		return mv;
	}

	@RequestMapping("Creat")
	public ModelAndView menu(@RequestParam String menuname, String username, String adminToken, String userid) {
		ModelAndView mv = new ModelAndView();
		boolean result = menuService.idcheck(userid);
		System.out.println("메뉴이름 : " + menuname);
		System.out.println(username +","+ adminToken );
		menuService.menucreat(menuname);
		System.out.println(username +","+ adminToken );
		mv.addObject("adminToken", adminToken);
		mv.addObject("userid", username);
		mv.setViewName("/board/first");
		return mv;
	}

	@RequestMapping("UpdateForm")
	public ModelAndView updateForm() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("menu/updateForm");
		return mv;
	}

	@RequestMapping("Update")
	public ModelAndView update(String menuname) {
		ModelAndView mv = new ModelAndView();
		menuService.update(menuname);
		mv.setViewName("board/menu");

		return mv;
	}

}
