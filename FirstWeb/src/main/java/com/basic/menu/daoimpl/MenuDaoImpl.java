package com.basic.menu.daoimpl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.basic.menu.dao.MenuDao;

@Repository("menuDao")
public class MenuDaoImpl implements MenuDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void menucreat(String menuname) {
		sqlSession.insert("Menu.Menucreat", menuname);
	}

	@Override
	public void update(String menuname) {
		sqlSession.update("Menu.Update",menuname);
		
	}

	@Override
	public boolean idcheck(String userid) {
		System.out.println(userid);
		boolean result = false;

		int count = sqlSession.selectOne("Menu.check", userid);
		if (count == 1) {
			// 있는개 확인이 되면 중복이기 때문에 일부러 false값을 준것이다.
			result = false;
		} else {
			result = true;
		}
		return result;
	}
}
