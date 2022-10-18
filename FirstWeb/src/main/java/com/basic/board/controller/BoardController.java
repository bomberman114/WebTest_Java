package com.basic.board.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.basic.board.service.BoardService;
import com.basic.board.vo.BoardVo;
import com.basic.menu.vo.MenuVo;
import com.basic.page.vo.PageVo;
import com.basic.reply.vo.ReplyVo;
import com.basic.user.vo.UserVo;

@Controller
@RequestMapping("Board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping("/First")
	public ModelAndView first(String userid) {
		System.out.println("보드 컨트롤러 - 로그인 후 메인화면 함수 도착");
		ModelAndView mv = new ModelAndView();
		System.out.println("유저 아이디:"+userid);
		// 로그인 유저 확인
		UserVo loginUser = boardService.userInfo(userid);
		System.out.println("로그인 유저:"+loginUser);
		// 관리자 예외처리
		if (loginUser.getUserid().equals("admin")) {
			loginUser.setAdminToken("1");
			System.out.println("로그인한 계정은 관리자입니다.");
		} else if (!loginUser.getUserid().equals("admin")) {
			loginUser.setAdminToken("0");
			System.out.println("로그인한 계정은 일반 유저입니다.");
		}

		mv.addObject("loginUser", loginUser);
		mv.setViewName("board/first");
		return mv;
	}

	// 동시에 반드시 화면에서 넘어올 필요는 없으며(required = false) 
	// 데이터가 없을 경우 기본값으로 "1"을 셋팅(defaultValue="1") 합니다.
	@RequestMapping("/List")
	public ModelAndView list(@RequestParam String userid, String menuname, String searchType, String searchText,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range,
			@RequestParam(required = false, defaultValue = "10") int listSize) {
		System.out.println("보드 컨트롤러 - 게시글 조회 함수 도착");
		ModelAndView mv = new ModelAndView();

		if (userid.equals("")) {
			UserVo user = new UserVo();
			mv.addObject("user", user);
		} else if (!userid.equals("")) {

			// 로그인 유저 확인
			UserVo loginUser = boardService.userInfo(userid);

			// 관리자 예외처리
			if (loginUser.getUserid().equals("admin")) {
				loginUser.setAdminToken("1");
				System.out.println("로그인한 계정은 관리자입니다.");
			} else if (!loginUser.getUserid().equals("admin")) {
				loginUser.setAdminToken("0");
				System.out.println("로그인한 계정은 일반 유저입니다.");
			}

			mv.addObject("user", loginUser);
		}

		// 메뉴 조회하기
		List<MenuVo> menuList = boardService.menuList();
		mv.addObject("menu", menuList);

		// menuname 값이 jsp에서 ""으로 보내면 null로 바꿔주기
		if (menuname != null) {
			if (menuname.equals("")) {
				menuname = null;
			}
		}

		// 전체 게시글 개수
		int listCnt = boardService.listCnt(menuname, searchType, searchText);
		System.out.println("리스트 갯수:"+listCnt);

		// 페이징 기능 실행
		// Pagination 객체생성
		PageVo pagination = new PageVo();
		pagination.setListSize(listSize);
		pagination.pageInfo(page, range, listCnt);
		System.out.println(page + "," + range);

		System.out.println(pagination);
		mv.addObject("pagination", pagination);

		// 게시글 조회하기
		List<BoardVo> boardList = boardService.boardList(menuname, pagination, searchType, searchText);
		mv.addObject("board", boardList);
		// 각종 정보를 jsp로 보내기
		mv.addObject("listSize", listSize); // 리스트 개수 골랐을 때를 고려
		mv.addObject("menuname", menuname); // 메뉴 골랐을 때를 고려
		mv.addObject("searchType", searchType); // 검색 했을 때를 고려
		mv.addObject("searchText", searchText); // 검색 했을 때를 고려

		mv.setViewName("board/list");
		return mv;
	}

	@RequestMapping("/Detail")
	public ModelAndView detail(@RequestParam String userid, String boardidx) {
		System.out.println("보드 컨트롤러 - 게시글 상세 페이지 함수 도착");
		ModelAndView mv = new ModelAndView();

		// 비 로그인 체크
		if (userid.equals("")) {
			UserVo user = new UserVo();
			mv.addObject("user", user);

		} else if (!userid.equals("")) {

			// 로그인 유저 확인
			UserVo loginUser = boardService.userInfo(userid);

			// 관리자 예외처리
			if (loginUser.getUserid().equals("admin")) {
				loginUser.setAdminToken("1");
				System.out.println("로그인한 계정은 관리자입니다.");
			} else if (!loginUser.getUserid().equals("admin")) {
				loginUser.setAdminToken("0");
				System.out.println("로그인한 계정은 일반 유저입니다.");
			}

			mv.addObject("user", loginUser);
		}

		// 게시글 정보 확인
		BoardVo detail = boardService.detail(boardidx);

		// 조회수 체크
		String countInfo = detail.getReadcount();
		int readcount = Integer.parseInt(countInfo);

		readcount = readcount + 1;
		String newcount = String.valueOf(readcount);
		detail.setReadcount(newcount);

		// 조회수 체크 후 DB 수정
		boardService.readCount(newcount, boardidx);
		mv.addObject("detail", detail);

		// 댓글 정보 확인
		List<ReplyVo> reply = boardService.reply(boardidx);
		mv.addObject("reply", reply);

		mv.setViewName("board/detail");
		return mv;
	}

	@RequestMapping("UpdateForm")
	public ModelAndView updateForm(@RequestParam String userid, String boardidx) {
		System.out.println("보드 컨트롤러 - 게시글 수정 함수 도착");
		ModelAndView mv = new ModelAndView();

		// 로그인 유저 확인
		UserVo loginUser = boardService.userInfo(userid);
		mv.addObject("user", loginUser);

		// 메뉴 조회하기
		List<MenuVo> menuList = boardService.menuList();
		mv.addObject("menu", menuList);

		// 기존의 보드 정보를 보여주기 위한 보드 정보조회
		BoardVo updateBoard = boardService.detail(boardidx);
		mv.addObject("update", updateBoard);
		mv.setViewName("board/updateForm");

		return mv;
	}

	@RequestMapping("Update")
	public ModelAndView update(@RequestParam HashMap<String, Object> map) {
		System.out.println("보드 컨트롤러 - 게시글 수정 입력 함수 도착");
		ModelAndView mv = new ModelAndView();

		boardService.update(map);

		// detail()에 매개변수 userid 전달
		String userid = (String) map.get("userid");
		mv.addObject("userid", userid);

		// detail()에 매개변수 boardidx 전달
		String boardidx = (String) map.get("boardidx");
		mv.addObject("boardidx", boardidx);

		mv.setViewName("redirect:/Board/Detail");
		return mv;
	}

	@RequestMapping("/Delete")
	public ModelAndView delete(@RequestParam String userid, String boardidx) {
		ModelAndView mv = new ModelAndView();

		boardService.delete(boardidx);

		// list()에 매개변수 userid 전달
		mv.addObject("userid", userid);
		mv.setViewName("redirect:/Board/List");
		return mv;
	}

	@RequestMapping("/WriteForm")
	public ModelAndView writeForm(@RequestParam String userid) {
		System.out.println("보드 컨트롤러 - 게시글 작성 함수 도착");
		ModelAndView mv = new ModelAndView();

		// 로그인 유저 확인
		UserVo loginUser = boardService.userInfo(userid);
		mv.addObject("user", loginUser);

		// 메뉴 조회하기
		List<MenuVo> menuList = boardService.menuList();
		mv.addObject("menu", menuList);

		mv.setViewName("board/writeForm");
		return mv;
	}

	@RequestMapping("/Write")
	public ModelAndView write(@RequestParam HashMap<String, Object> map) {
		System.out.println("보드 컨트롤러 - 게시글 작성 완료 함수 도착");
		ModelAndView mv = new ModelAndView();
		boardService.write(map);

		// list()에 매개변수 userid 전달
		String userid = (String) map.get("boardwriter");
		mv.addObject("userid", userid);
		mv.setViewName("redirect:/Board/List");
		return mv;
	}

}