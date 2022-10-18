package com.basic.menu.dao;

import java.util.List;

import com.basic.menu.vo.MenuVo;

public interface MenuDao {

	void menucreat(String menuname);

	void update(String menuname, String newname);

	MenuVo menuInfo(String menuname);

	List<MenuVo> list();

	void delete(String menuname);

}
