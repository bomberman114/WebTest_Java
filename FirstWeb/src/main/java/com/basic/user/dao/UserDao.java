package com.basic.user.dao;

import java.util.HashMap;
import java.util.List;

import com.basic.user.vo.UserVo;

public interface UserDao {

	// 회원가입
	void account(HashMap<String, Object> map);

	// 회원목록
	List<UserVo> list();

	// 회원상세
	UserVo detail(String userid);

	// 회원삭제
	void delete(String userid);

	// 회원수정
	void update(String userid, String username, String userpw);

	// 회원수정값 있는지 확인
	boolean updateForm(String userid, String userpw);

	// 회원가입 아이디 중복확인
	boolean idcheck(String userid);

}
