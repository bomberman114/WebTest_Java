package com.basic.login.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.basic.loginvo.LoginVo;
import com.github.scribejava.core.model.OAuth2AccessToken;

@Controller
@RequestMapping("Login")
public class LoginController {

	/* NaverLoginBO */
	private LoginVo loginVo;
	private String apiResult = null;

	@Autowired
	private void setLoginVo(LoginVo loginVo) {
		this.loginVo = loginVo;
	}

	// 로그인 첫 화면 요청 메소드
	@RequestMapping("/login")
	public ModelAndView login(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = loginVo.getAuthorizationUrl(session);

		// https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		// redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		System.out.println("네이버:" + naverAuthUrl);

		// 네이버
		mv.addObject("url", naverAuthUrl);
		mv.setViewName("/login/login");
		return mv;
	}

	// 네이버 로그인 성공시 callback호출 메소드
	@RequestMapping("/callback")
	public ModelAndView callback(@RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException, ParseException {

		ModelAndView mv = new ModelAndView();
		System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
		oauthToken = loginVo.getAccessToken(session, code, state);

		// 1. 로그인 사용자 정보를 읽어온다.
		apiResult = loginVo.getUserProfile(oauthToken); // String형식의 json데이터

		/**
		 * apiResult json 구조 {"resultcode":"00", "message":"success",
		 * "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
		 **/

		// 2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;

		// 3. 데이터 파싱
		// Top레벨 단계 _response 파싱
		JSONObject response_obj = (JSONObject) jsonObj.get("response");
		// response의 nickname값 파싱
		String nickname = (String) response_obj.get("nickname");

		System.out.println(nickname);

		// 4.파싱 닉네임 세션으로 저장
		session.setAttribute("sessionId", nickname); // 세션 생성
		  // 세션 유지시간 설정(초단위)
	    // 60 * 30 = 30분
		//앞의 숫자가 초단위이다.
	    session.setMaxInactiveInterval(60*30); 	
		

		System.out.println("callback정보:"+apiResult);
		mv.addObject("result", apiResult);
		mv.setViewName("/login/login");
		return mv;
	}

	// 로그아웃
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) throws IOException {
		ModelAndView mv = new ModelAndView();
		System.out.println("여기는 logout");
		session.invalidate();

		mv.setViewName("redirect:/");
		return mv;
	}

}