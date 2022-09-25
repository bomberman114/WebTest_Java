package com.basic.login.daoimpl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.basic.login.dao.LoginDao;
import com.basic.user.vo.UserVo;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public UserVo login(String userid, String userpw) {
	
		System.out.println("LoginDaoImpl1 userid= " + userid +", userpw= " + userpw);
		
		HashMap<String, Object> user = new HashMap<String, Object>();
		
		user.put("userid", userid);
		user.put("userpw", userpw);
		
		
		UserVo loginUser = sqlSession.selectOne("Login.LoginUser", user);
		
		
		System.out.println("LoginDaoImpl2 userid= " + userid +", userpw= " + userpw);
		
		return loginUser;

	}

}
