package com.basic.user.daoimpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.basic.user.dao.UserDao;
import com.basic.user.vo.UserVo;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void account(HashMap<String, Object> map) {
		System.out.println("UserDaoImpl acoount response map= " + map);
		sqlSession.insert("User.accountUser", map);
	}

	// 회원가입 아이디 중복확인
	@Override
	public boolean idcheck(String userid) {
		System.out.println(userid);
		boolean result = false;

		int count = sqlSession.selectOne("User.checkAccount", userid);
		if (count == 1) {
			// 있는개 확인이 되면 중복이기 때문에 일부러 false값을 준것이다.
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	@Override
	public List<UserVo> list() {
		List<UserVo> list = sqlSession.selectList("User.List");
		// UserVo a = sqlSession.selectOne(null); 한사람만 들고오는 셀렉트
		// sqlSession.delete("User.userDelete", username); //삭제 담는(돌려주는) 값이 없다면 변수만들지
		// 마라.
		// select * from aaa where username = #{username};
		return list; // Daoimpl를 생략할때 리턴문에 sql세션을 바로 넣을 수있음
	}

	@Override
	public UserVo detail(String userid) {
		UserVo detail = sqlSession.selectOne("User.detail", userid);
		return detail;
	}

	@Override
	public void delete(String userid) {
		sqlSession.delete("User.delete", userid);

	}

	// 회원수정
	@Override
	public void update(String userid, String username, String userpw) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("userpw", userpw);
		map.put("userid", userid);
		System.out.println(map);
		sqlSession.update("User.update", map);

	}

	@Override
	public boolean updateForm(String userid, String userpw) {
		boolean result = false;
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("userpw", userpw);
		int count = sqlSession.selectOne("User.check", map);
		if (count == 1) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

}
