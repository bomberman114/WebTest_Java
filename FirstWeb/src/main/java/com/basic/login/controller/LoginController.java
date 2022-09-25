package com.basic.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.basic.login.service.LoginService;
import com.basic.user.vo.UserVo;

@Controller
@RequestMapping("Login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping("Login")
	public ModelAndView login(String userid, String userpw) { // 파라미터
		
		System.out.println("LoginController userid= " + userid +", userpw= " + userpw);
		
		UserVo loginUser = loginService.login(userid, userpw); // 아규먼트
		
		System.out.println("LoginController2 userid= " + userid +", userpw= " + userpw);

		System.out.println("loginUser B-batis= " + loginUser);
		
		
		if( loginUser.getUserid().equals("admin") ) {
			loginUser.setAdminToken("1");
			System.out.println("로그인한 계정은 관리자입니다.");
		}else if( !loginUser.getUserid().equals("admin") ) {
			loginUser.setAdminToken("0");
			System.out.println("로그인한 계정은 일반 계정입니다.");
		}
		
		String adminTest = "";
		if( loginUser.getAdminToken().equals("1") ) {
			adminTest = "관리자";
			System.out.println("로그인유저 userid=" + loginUser.getUserid() + ", username= " + loginUser.getUsername());
			System.out.println("권한: " + adminTest + "입니다.");
		}else {
			System.out.println("일반유저다.");
		}
		
	
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("loginUser", loginUser);
		mv.setViewName("redirect:http://localhost:9090/");
		
		return mv;

	}

}
