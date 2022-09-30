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
		String userid = (String) map.get("userid");
		boolean result = userService.idcheck(userid);
		System.out.println("유저아이디:" + userid);
		System.out.println(result);
		String msg = "";
		if (result == true) {
			System.out.println("트루까지 왔다.");
			System.out.println(map);
			userService.account(map);
			mv.setViewName("redirect:/Login/LoginForm");
			return mv;
		} else if (result == false) {
			System.out.println("펠까지 왔다");
			msg = "중복된 ID입니다. 다른 ID를 입력해주세요";
			System.out.println(msg);
			String result1 = "false";
			mv.addObject("result1", result1);
			mv.addObject("msg", msg);
			mv.setViewName("user/accountForm");
			return mv;
		}
		mv.setViewName("redirect:/");
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

	@RequestMapping("/Detail")
	public ModelAndView detailUser(@RequestParam String userid) {
		System.out.println("유저 컨트롤러 - 일반 유저기준 상세정보 함수 도착");
		System.out.println("detail userid = " + userid);
		ModelAndView mv = new ModelAndView();

		// DB에서 정보를 가져온다.
		UserVo detail = userService.detail(userid);
		System.out.println("유저 컨트롤러 - 일반 유저기준 상세정보 조회 후 UserVo에 입력");
		System.out.println(detail);

		// 일반 유저임을 나타내기 위한 토큰 발급
		detail.setAdminToken("0");
		System.out.println("로그인한 계정은 일반 유저입니다.");

		// 가져온 정보를 화면에 전달한다.
		mv.addObject("detail", detail);
		mv.setViewName("user/detail");
		System.out.println("유저 컨트롤러 - 일반 유저기준 상세정보 화면 전달");
		return mv;
	}

	// 관리자 - 회원 상세정보
	@RequestMapping("/DetailAdmin")
	public ModelAndView detailAdmin(@RequestParam String userid) {
		System.out.println("유저 컨트롤러 - 관리자 기준 상세정보 함수 도착");
		System.out.println("detail userid = " + userid);
		ModelAndView mv = new ModelAndView();

		// DB에서 정보를 가져온다.
		UserVo detail = userService.detail(userid);
		System.out.println("유저 컨트롤러 - 관리자 기준 상세정보 조회 후 UserVo에 입력");
		System.out.println(detail);

		// 관리자임을 나타내기 위한 토큰 발급
		detail.setAdminToken("1");
		System.out.println("로그인한 계정은 관리자입니다.");

		// 가져온 정보를 화면에 전달한다.
		mv.addObject("detail", detail);
		mv.setViewName("user/detail");
		System.out.println("유저 컨트롤러 - 관리자 기준 상세정보 화면 전달");
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
	@RequestMapping("/Delete")
	public ModelAndView deleteUser(@RequestParam String userid) {
		System.out.println("유저 컨트롤러 - 일반 유저기준 탈퇴 함수 도착");
		System.out.println("탈퇴 id = " + userid);
		ModelAndView mv = new ModelAndView();
		userService.delete(userid);
		mv.setViewName("redirect:/Login/LoginForm");
		return mv;
	}

	// 관리자 회원삭제
	@RequestMapping("/DeleteAdmin")
	public ModelAndView deleteAdmin(@RequestParam String userid) {
		System.out.println("유저 컨트롤러 - 관리자 기준 추방 함수 도착");
		System.out.println("추방 id = " + userid);
		ModelAndView mv = new ModelAndView();
		userService.delete(userid);
		mv.setViewName("redirect:/User/List");
		return mv;
	}

	@RequestMapping("/UpdateForm")
	public ModelAndView updateUserForm(@RequestParam String userid) {
		System.out.println("유저 컨트롤러 - 회원정보 수정 함수 도착");
		System.out.println("update userid = " + userid);
		ModelAndView mv = new ModelAndView();

		// DB에서 정보를 가져온다.
		UserVo updateUser = userService.detail(userid);
		System.out.println("유저 컨트롤러 - 회원 상세정보 조회 후 UserVo에 입력");
		System.out.println(updateUser);

		// 가져온 정보를 화면에 전달한다.
		mv.addObject("update", updateUser);
		mv.setViewName("user/updateForm");
		return mv;
	}

	@RequestMapping("Update")
	public ModelAndView update(@RequestParam String userid, String username, String userpw) {
		System.out.println("유저업데이트 입력 함수 도착");
		ModelAndView mv = new ModelAndView();
		userService.update(userid ,username, userpw);
		mv.setViewName("redirect:/User/List");
		return mv;
	}

}
