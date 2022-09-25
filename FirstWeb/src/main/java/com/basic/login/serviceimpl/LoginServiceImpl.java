package com.basic.login.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.login.dao.LoginDao;
import com.basic.login.service.LoginService;
import com.basic.user.vo.UserVo;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;

	@Override
	public UserVo login(String userid, String userpw) {
		
		
		System.out.println("LoginService1 userid= " + userid +", userpw= " + userpw);
		UserVo loginUser = loginDao.login(userid, userpw);
	
		System.out.println("LoginService2 userid= " + userid +", userpw= " + userpw);
		return loginUser;

	}

}
