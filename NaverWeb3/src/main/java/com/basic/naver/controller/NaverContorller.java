package com.basic.naver.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.basic.navervo.SearchVo;
import com.basic.page.vo.PageVo;
import com.basic.search.service.SearchService;

@Controller
@RequestMapping("Naver")
public class NaverContorller {

	@Autowired
	private SearchService searchService;

	// private static String clientID = "90qYXg5ocmYZBSUUgGrc";
	// private static String clientSecret = "aVh1gplt9H";

	@RequestMapping("/SearchForm")
	public ModelAndView searchForm() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("/naver/searchForm");
		return mv;

	}

	@RequestMapping("/Search")
	public ModelAndView search(String keyword) throws UnsupportedEncodingException, ParseException {
		ModelAndView mv = new ModelAndView();
		PageVo pg = new PageVo();
		int display = 10;
		int listSize = display;
		int page = 1;
		int range = 1;
		pg.setListSize(listSize);

		if (keyword == null || keyword.equals("")) {
			System.out.println("에외처리 도착");
			mv.setViewName("redirect:/Naver/SearchForm");

		} else if (keyword != null) {
			int start = 1;

			page = start;
			System.out.println("search 컨트롤러 keyword:" + keyword);
			int total = searchService.total(keyword, display, start);
			System.out.println("search 컨트롤러 total:" + total);
			List<SearchVo> search = searchService.search(keyword, display, start);

			pg.setListCnt(total);
			pg.pageInfo(page, range, total);
			System.out.println("네이버컨트롤러 :" + pg);

			mv.addObject("page", page);
			mv.addObject("range", range);
			mv.addObject("pagination", pg);
			mv.addObject("book", search);
			mv.addObject("keyword", keyword);
			mv.addObject("pa", page);
			mv.setViewName("/naver/searchForm");
		}
		mv.setViewName("/naver/searchForm");
		return mv;
	}

	@RequestMapping("/SearchPage") // 페이징을 위해서 따로 만든 컨트롤러
	public ModelAndView searchpage(String keyword, int page, int range, int clikpage)
			throws UnsupportedEncodingException, ParseException {
		ModelAndView mv = new ModelAndView();
		PageVo pg = new PageVo();
		int display = 10;
		int listSize = display;
		page = clikpage;
		pg.setListSize(listSize);

		if (keyword == null || keyword.equals("")) {
			System.out.println("에외처리2 도착");
			mv.setViewName("redirect:/Naver/SearchForm");

		} else if (keyword != null) {
			int start = 1 + 10 * (clikpage - 1);
			System.out.println("컨트롤러 88번줄:" + clikpage);
			page = start;

			System.out.println("search 컨트롤러 keyword2:" + keyword);
			int total = searchService.total(keyword, display, start);
			System.out.println("search 컨트롤러 total:" + total);
			List<SearchVo> search = searchService.search(keyword, display, start);

			pg.setListCnt(total);
			pg.pageInfo(page, range, total);
			System.out.println("네이버컨트롤러 :" + pg);
			int pa = ((int) Math.floor(page / 10)) + 1; // 나누고 나머지는 버림으로 값구하기
			System.out.println("106줄:" + pa);// 현재 페이지
			mv.addObject("pa", pa);
			mv.addObject("pagination", pg);
			mv.addObject("book", search);
			mv.addObject("keyword", keyword);
			mv.addObject("page", page);
			mv.setViewName("/naver/searchForm");
		}
		mv.setViewName("/naver/searchForm");
		return mv;
	}

	@RequestMapping("/SearchNext") // next 위해서 따로 만든 컨트롤러
	public ModelAndView searchnext(String keyword, int page, int range, boolean next)
			throws UnsupportedEncodingException, ParseException {
		ModelAndView mv = new ModelAndView();
		PageVo pg = new PageVo();
		int display = 10;
		int listSize = display;
		pg.setListSize(listSize);

		if (keyword == null || keyword.equals("")) {
			System.out.println("에외처리3 도착");
			mv.setViewName("redirect:/Naver/SearchForm");

		} else if (keyword != null) {
			if (next = true) {
				int start = page + 10;
				page = start;
				if (1 <= page) {
					if (page < 91) {
						range = 1;
						int total = searchService.total(keyword, display, start);
						System.out.println("search 컨트롤러 total:" + total);

						List<SearchVo> search = searchService.search(keyword, display, start);

						pg.setListCnt(total);
						pg.pageInfo(page, range, total);
						System.out.println("네이버컨트롤러 :" + pg);
						int pa = ((int) Math.floor(page / 10)) + 1; // 나누고 나머지는 버림으로 값구하기
						System.out.println("152번줄:" + pa);// 현재 페이지
						mv.addObject("pa", pa);
						mv.addObject("pagination", pg);
						mv.addObject("book", search);
						mv.addObject("keyword", keyword);
						mv.setViewName("/naver/searchForm");
					} else if (page >= 91) {

						System.out.println("126번줄:" + page);
						int lo = (int) Math.log10(page);// 자릿수구하기
						System.out.println("128줄:" + lo);
						int po = (int) Math.pow(10, lo); // 제곱구하기
						System.out.println("130줄:" + po);
						int fl = (int) Math.floor(page / po); // 나누고 나머지는 버림으로 값구하기
						System.out.println("132줄:" + fl);

						range = 1 + fl;
						System.out.println("135번줄:" + range);

						System.out.println("search 컨트롤러 keyword3:" + keyword);
						int total = searchService.total(keyword, display, start);
						System.out.println("search 컨트롤러 total:" + total);

						List<SearchVo> search = searchService.search(keyword, display, start);

						pg.setListCnt(total);
						pg.pageInfo(page, range, total);
						System.out.println("네이버컨트롤러 :" + pg);
						int pa = ((int) Math.floor(page / 10)) + 1; // 나누고 나머지는 버림으로 값구하기
						System.out.println("152번줄:" + pa);// 현재 페이지
						mv.addObject("pa", pa);
						mv.addObject("pagination", pg);
						mv.addObject("book", search);
						mv.addObject("keyword", keyword);
						mv.setViewName("/naver/searchForm");

					}
				}
			}
		}
		mv.setViewName("/naver/searchForm");
		return mv;
	}
}
