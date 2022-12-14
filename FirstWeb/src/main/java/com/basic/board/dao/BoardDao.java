package com.basic.board.dao;

import java.util.HashMap;
import java.util.List;

import com.basic.board.vo.BoardVo;
import com.basic.menu.vo.MenuVo;
import com.basic.page.vo.PageVo;
import com.basic.reply.vo.ReplyVo;
import com.basic.user.vo.UserVo;

public interface BoardDao {
	// 로그인 유저 확인
	UserVo userInfo(String userid);

	// 메뉴 조회
	List<MenuVo> menuList();

	// 게시글 조회
	List<BoardVo> boardList(String menuname, PageVo pagination, String searchText, String searchType);
	
	//총 게시글 개수 확인
	int listCnt(String menuname, String searchType, String searchText);


	// 게시글 상세 페이지
	BoardVo detail(String boardidx);

	// 조회수 체크 후 DB 수정
	void readCount(String newcount, String boardidx);

	// 게시글 수정
	void update(HashMap<String, Object> map);

	// 게시글 삭제
	void delete(String boardidx);

	// 게시글 작성
	void write(HashMap<String, Object> map);

	List<ReplyVo> reply(String boardidx);

}
