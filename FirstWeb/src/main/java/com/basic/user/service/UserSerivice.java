package com.basic.user.service;

import java.util.HashMap;
import java.util.List;

import com.basic.user.vo.UserVo;


public interface UserSerivice {
	// 회원가입
	void account(HashMap<String, Object> map);

	//회원목록
	List<UserVo> list();

}
