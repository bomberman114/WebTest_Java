package com.basic.user.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; //어노테이션이 주입되었다.
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.basic.user.service.UserSerivice;
import com.basic.user.vo.UserVo;

@Controller
@RequestMapping("User")

public class UserController {

	@Autowired // 임포트 하고 나머지 만들기 의존성을 주입한다.
	private UserSerivice userService;

	@RequestMapping("/AccountForm") // ModelAndView 역할 MAV 컨트롤 스페이바 마브,
	public ModelAndView userAccountForm() {
		ModelAndView mv = new ModelAndView();
		System.out.println("유저회원가입 함수 도착");
	
		mv.setViewName("user/accountForm");
		return mv;
	}

	@RequestMapping("/Account") // ModelAndView 역할 MAV 컨트롤 스페이바 마브, @RequestParam이 해시맵형식으로 받는것
	public ModelAndView userAccount(@RequestParam HashMap<String, Object> map) {
		ModelAndView mv = new ModelAndView();
		boolean result = userService.accountForm(map);
		System.out.println("유저아이디:" + map.get("userid"));
		System.out.println(result);
		String msg = "";
		if (result) {
			System.out.println("트루까지 왔다.");
			System.out.println(map);
			userService.account(map);
			mv.setViewName("redirect:/User/List");
			return mv;
		} else if (result = false) {
			msg = "중복된 ID입니다. 다른 ID를 입력해주세요";
			String result1 = "false";
			mv.addObject("result1", result1);
			mv.addObject("msg", msg);
			mv.setViewName("redirect:/User/AccountForm");
			return mv;	
		}
		
		return mv;

	}

	// UserList 조회
	@RequestMapping("/List")
	public ModelAndView List() {
		ModelAndView mv = new ModelAndView();

		// DB에서 리스트를 가져온다.
		List<UserVo> List = userService.list();

		// 가져온 리스트를 화면에 전달한다.
		// .addAttribute("userList", userList);
		mv.addObject("List", List);
		mv.setViewName("user/list");
		return mv;
	}

	// 회원 상세목록
	@RequestMapping("/Detail")
	public ModelAndView detail(String userid) {
		System.out.println("유저 컨트롤러 - 회원 상세정보 함수 도착");
		ModelAndView mv = new ModelAndView();
		UserVo detail = userService.detail(userid);
		mv.addObject("detail", detail);
		mv.setViewName("user/detail");
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
	@RequestMapping("Delete")
	public ModelAndView delete(String userid) {
		System.out.println("유저 컨트롤러 딜리트 함수 도착");
		ModelAndView mv = new ModelAndView();
		userService.delete(userid);
		mv.setViewName("redirect:/User/List");
		return mv;
	}

	@RequestMapping("UpdateForm")
	public ModelAndView updateForm(String userid, String userpw) {
		System.out.println("유저업데이트 함수 도착");
		ModelAndView mv = new ModelAndView();
		System.out.println("유저아이디:" + userid + "유저비번 : " + userpw);
		boolean result = userService.updateForm(userid, userpw);
		System.out.println(result);
		if (result) {
			mv.setViewName("user/updateForm");
			return mv;
		} else {
			mv.setViewName("redirect:/User/List");
			return mv;
		}
	}

	@RequestMapping("Update")
	public ModelAndView update(String username, String userpw) {
		System.out.println("유저업데이트 입력 함수 도착");
		ModelAndView mv = new ModelAndView();
		userService.update(username, userpw);
		mv.setViewName("redirect:/User/List");
		return mv;
	}

}
