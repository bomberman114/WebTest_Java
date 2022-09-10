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
		userDao.account(map);
		System.out.println("UserServiceImpl 바티스 후");
	}
	@Override
	public List<UserVo>  list(){
		System.out.println("UserList Service 바티스전");
		List<UserVo>  userlist = userDao.list();
		System.out.println(userlist);
		return  userlist;
	}

}
