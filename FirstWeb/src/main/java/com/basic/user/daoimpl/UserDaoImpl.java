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
		// System.out.println("UserDaoImpl acoount response map= " + map);
		System.out.println("UserDaoImpl 바티스 전");

		sqlSession.insert("User.accountUser", map);
		System.out.println("UserDaoImpl 바티스 후");
	}

	@Override
	public List<UserVo> list() {
		System.out.println("Dao 회원목록 조회 전");
		List<UserVo> userlist = sqlSession.selectList("User.userList");
		System.out.println(userlist);
		// UserVo a = sqlSession.selectOne(null); 한사람만 들고오는 셀렉트
		// sqlSession.delete("User.userDelete", username); //삭제 담는(돌려주는) 값이 없다면 변수만들지
		// 마라.
		// select * from aaa where username = #{username};
		return userlist; // Daoimpl를 생략할때 리턴문에 sql세션을 바로 넣을 수있음
	}

	@Override
	public void delete(HashMap<String, Object> map) {
		System.out.println("다오임플 삭제전");
		System.out.println("deletemap : " + map);
		sqlSession.delete("User.deleteUser", map);
		System.out.println("다오임플 삭제후");

	}

	// 회원수정
	@Override
	public void update(HashMap<String, Object> map) {
		System.out.println("다오임플 유저수정 전");
		System.out.println("updatemap : " + map);
		sqlSession.update("User.updateUser", map);
		System.out.println("다오임플 유저수정 후");

	}

}