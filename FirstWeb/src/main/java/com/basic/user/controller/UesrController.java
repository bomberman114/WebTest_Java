package com.basic.user.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; //어노테이션이 주입되었다.
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.basic.user.service.UserSerivice;
import com.basic.user.vo.UserVo;

@Controller
@RequestMapping("User")

public class UesrController {

	@Autowired // 임포트 하고 나머지 만들기 의존성을 주입한다.
	private UserSerivice userService;

	@RequestMapping("/AccountForm") // ModelAndView 역할 MAV 컨트롤 스페이바 마브,
	public ModelAndView userAccountForm() {
		ModelAndView mv = new ModelAndView();
		System.out.println("유저 컨트롤러 회원가입 함수 도착");
		mv.setViewName("user/accountForm");
		return mv;

	}

	@RequestMapping("/Account") // ModelAndView 역할 MAV 컨트롤 스페이바 마브, @RequestParam이 해시맵형식으로 받는것
	public ModelAndView userAccount(@RequestParam HashMap<String, Object> map) {
		System.out.println("UserController Account map=" + map);
		ModelAndView mv = new ModelAndView();
		System.out.println("유저 컨트롤러 회원가입  입력 페이지 함수 도착");
		userService.account(map);
		mv.setViewName("redirect:/User/UserList");
		return mv;

	}

	// UserList 조회
	@RequestMapping("/UserList")
	public ModelAndView userList() {
		ModelAndView mv = new ModelAndView();
		System.out.println("유저 컨트롤러 - 회원목록 조회 함수 도착");

		// DB에서 리스트를 가져온다.
		List<UserVo> userList = userService.list();
		System.out.println("유저 컨트롤러 - 회원목록 조회 후 리스트에 입력");

		// 가져온 리스트를 화면에 전달한다.
		// .addAttribute("userList", userList);
		System.out.println("유저 컨트롤러 - 회원목록 리스트 화면 전달");
		mv.addObject("userList", userList);
		System.out.println("유저 컨트롤러 add함수 도착");
		mv.setViewName("user/userList");
		System.out.println("유저 컨트롤러 setView 함수 도착");
		return mv;
	}

	// 회원 상세목록
	@RequestMapping("/DetailUser")
	public ModelAndView detailUser(@RequestParam HashMap<String, Object> map) {
		System.out.println("유저 컨트롤러 - 회원 상세정보 함수 도착");
		System.out.println("detail map = " + map);
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> detailUser = userService.detail(map);
		mv.addObject("detailUser", detailUser);
		mv.setViewName("user/detailuser");
		return mv;
	}

	@RequestMapping("/Test")
	public ModelAndView test(@RequestParam HashMap<String, Object> map) {
		System.out.println("Test에 왔습니다..");
		System.out.println("test map =" + map);
		ModelAndView mv = new ModelAndView();
		return mv;
	}

	// 회원 삭제
	@RequestMapping("DeleteUser")
	public ModelAndView deleteUser(@RequestParam HashMap<String, Object> map) {
		System.out.println("유저 컨트롤러 딜리트 함수 도착");
		System.out.println("유저 컨트롤러삭제 함수map : " + map);
		ModelAndView mv = new ModelAndView();
		
		
		userService.delete(map);
		mv.setViewName("redirect:/User/UserList");
		return mv;
	}

	@RequestMapping("UserUpdateForm")
	public ModelAndView userUpdateForm(@RequestParam HashMap<String, Object> map) {
		System.out.println("유저업데이트 함수 도착");
		ModelAndView mv = new ModelAndView();
		System.out.println("유저업데이트함수 map : " + map);
		mv.addObject("userUpdate", map);
		mv.setViewName("user/userUpdate");
		return mv;
	}

	@RequestMapping("UserUpdate")
	public ModelAndView userUpdate(@RequestParam HashMap<String, Object> map) {
		System.out.println("유저업데이트 입력 함수 도착");
		ModelAndView mv = new ModelAndView();
		System.out.println("유저업데이트함수 map : " + map);
		userService.update(map);
		mv.setViewName("redirect:/User/UserList");
		return mv;
	}

}
