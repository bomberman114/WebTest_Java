package com.basic.menu.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.menu.dao.MenuDao;
import com.basic.menu.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;
	
	@Override
	public void menucreat(String menuname) {
		menuDao.menucreat(menuname);
		
	}

	@Override
	public void update(String menuname) {
		menuDao.update(menuname);
		
	}

	@Override
	public boolean idcheck(String userid) {
		menuDao.idcheck(userid);
		return false;
	}

	
}
