package com.basic.user.serviceimpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.user.dao.UserDao;
import com.basic.user.service.UserSerivice;
import com.basic.user.vo.UserVo;

@Service("userService")
public class UserServiceImpl implements UserSerivice {
	@Autowired
	private UserDao userDao;

	// 회원가입
	@Override
	public void account(HashMap<String, Object> map) {
		// System.out.println("UserServiceImpl acoount response map= " + map);
		System.out.println("UserServiceImpl 바티스 전");
		System.out.println("유저 서비스 임플 map : " + map);
		userDao.account(map);
		System.out.println("UserServiceImpl 바티스 후");
	}

	// 회원목록
	@Override
	public List<UserVo> list() {
		System.out.println("UserList Service 바티스전");
		List<UserVo> userlist = userDao.list();
		System.out.println(userlist);
		return userlist;
	}

	// 회원상세
	@Override
	public HashMap<String, Object> detail(HashMap<String, Object> map) {
		System.out.println("유저서비스상세 임플 바티스전");
		System.out.println(map);
		HashMap<String, Object> detailUser = userDao.detail(map);
		System.out.println("유저서비스상세 임플 바티스후");
		return detailUser;
	}

	// 회원삭제
	@Override
	public void delete(HashMap<String, Object> map) {
		System.out.println("서비스임플 삭제전");
		System.out.println("deletemap : " + map);
		userDao.delete(map);
		System.out.println("서비스임플 삭제후");

	}

	// 회원수정
	@Override
	public void update(HashMap<String, Object> map) {
		System.out.println("유저업데이트 전");
		System.out.println("update map : " + map);
		userDao.update(map);
		System.out.println("유저업데이트 후");

	}

	// 로그인 체크
	@Override
	public HashMap<String, Object> loginCheck(HashMap<String, Object> map) {
		System.out.println("유저서비스상세 임플 로그인체크 바티스전");
		System.out.println(map);
		HashMap<String, Object> userinfo = userDao.loginCheck(map);
		System.out.println("유저서비스상세 임플 로그인 체크 바티스후");
		return userinfo;
	}

}
