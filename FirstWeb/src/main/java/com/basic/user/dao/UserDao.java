package com.basic.user.dao;

import java.util.HashMap;
import java.util.List;

import com.basic.user.vo.UserVo;

public interface UserDao {

	// 회원가입
	void account(HashMap<String, Object> map);

	// 회원목록
	List<UserVo> list();

	// 회원삭제
	void delete(HashMap<String, Object> map);

	// 회원수정
	void update(HashMap<String, Object> map);
}
