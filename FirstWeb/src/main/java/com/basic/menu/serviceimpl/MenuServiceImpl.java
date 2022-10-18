package com.basic.menu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.menu.dao.MenuDao;
import com.basic.menu.service.MenuService;
import com.basic.menu.vo.MenuVo;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;

	@Override
	public void menucreat(String menuname) {
		menuDao.menucreat(menuname);

	}

	@Override
	public void update(String menuname, String newname) {
		menuDao.update(menuname, newname);

	}

	@Override
	public List<MenuVo> list() {
		System.out.println("메뉴목록 - Service 바티스 전");
		List<MenuVo> list = menuDao.list();
		System.out.println("메뉴목록 - Service 바티스 후");
		System.out.println("서비스임플:" + list);
		return list;
	}

	@Override
	public void delete(String menuname) {
		System.out.println("메뉴삭제 - Service 바티스 전");
		menuDao.delete(menuname);
		System.out.println("메뉴삭제 - Service 바티스 후");
	}

	@Override
	public MenuVo menuInfo(String menuname) {
		System.out.println("서비스임플 : " + menuname);
		MenuVo menuInfo = menuDao.menuInfo(menuname);
		System.out.println("서비스임플후 : " + menuname);
		return menuInfo;
	}

}
