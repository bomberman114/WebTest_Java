package com.basic.menu.service;

import java.util.List;

import com.basic.menu.vo.MenuVo;

public interface MenuService {

	void menucreat(String menuname);

	void update(String menuname, String newname);

	// 메뉴 정보조회
	MenuVo menuInfo(String menuname);

	// 메뉴목록
	List<MenuVo> list();

	// 메뉴삭제
	void delete(String menuname);

}
