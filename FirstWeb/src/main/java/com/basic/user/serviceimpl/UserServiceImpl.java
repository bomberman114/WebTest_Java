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
		userDao.account(map);
	}

	// 회원가입 아이디 중복확인
	@Override
	public boolean accountForm(HashMap<String, Object> map) {
		boolean accountForm = userDao.accountForm(map);
		return accountForm;
	}

	// 회원목록
	@Override
	public List<UserVo> list() {
		List<UserVo> list = userDao.list();
		return list;
	}

	// 회원상세
	@Override
	public UserVo detail(String userid) {
		UserVo detail = userDao.detail(userid);
		return detail;
	}

	// 회원삭제
	@Override
	public void delete(String userid) {
		userDao.delete(userid);

	}

	// 회원수정
	@Override
	public void update(String username, String userpw) {
		userDao.update(username, userpw);

	}

	@Override
	public boolean updateForm(String userid, String userpw) {
		boolean updateForm = userDao.updateForm(userid, userpw);
		return updateForm;
	}

}
