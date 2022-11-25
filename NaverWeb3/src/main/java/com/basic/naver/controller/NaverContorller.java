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
import com.basic.search.serviceimpl.SearchServiceimpl;

@Controller
@RequestMapping("Naver")
public class NaverContorller {

	@Autowired
	private SearchServiceimpl searchServiceimpl;

	// private static String clientID = "90qYXg5ocmYZBSUUgGrc";
	// private static String clientSecret = "aVh1gplt9H";

	@RequestMapping("/SearchForm")
	public ModelAndView searchForm() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("/naver/searchBookForm");
		return mv;

	}

	@RequestMapping("/Search")
	public ModelAndView search(String keyword) throws UnsupportedEncodingException, ParseException {
		ModelAndView mv = new ModelAndView();
		PageVo pg = new PageVo();
		int display = 10;
		int listSize = display;
		int page;
		int range = 1;
		pg.setListSize(listSize);

		if (keyword == null || keyword.equals("")) {
			System.out.println("에외처리 도착");
			mv.setViewName("redirect:/Naver/SearchForm");

		} else if (keyword != null) {
			int start = 1;
			page = start;
			System.out.println("search 컨트롤러 keyword:" + keyword);
			int total = searchServiceimpl.total(keyword, display, start);
			System.out.println("search 컨트롤러 total:" + total);
			List<SearchVo> search = searchServiceimpl.search(keyword, display, start);

			pg.setListCnt(total);
			pg.pageInfo(page, range, total);
			System.out.println("네이버컨트롤러 :" + pg);

			mv.addObject("listSize", listSize);
			mv.addObject("page", page);
			mv.addObject("range", range);
			mv.addObject("pagination", pg);
			mv.addObject("book", search);
			mv.addObject("keyword", keyword);
			mv.addObject("pa", page);
			mv.setViewName("/naver/searchBookForm");
		}
		mv.setViewName("/naver/searchBookForm");
		return mv;
	}

	@RequestMapping("/SearchSize") // 10,20,30,40개씩 보여주기위한 컨트롤러
	public ModelAndView searchSize(String keyword, int page, int range, int listSize)
			throws UnsupportedEncodingException, ParseException {
		ModelAndView mv = new ModelAndView();
		PageVo pg = new PageVo();
		int display = listSize;
		pg.setListSize(listSize);

		if (keyword == null || keyword.equals("")) {
			mv.setViewName("redirect:/Naver/SearchForm");

		} else if (keyword != null) {
			int tenplace = (int) listSize / 10;
			int start = 1 + 10 * (tenplace) * (page - 1);
			page = start;

			int total = searchServiceimpl.total(keyword, display, start);
			List<SearchVo> search = searchServiceimpl.search(keyword, display, start);

			pg.setListCnt(total);
			pg.pageInfo(page, range, total);
			System.out.println("네이버컨트롤러 :" + pg);
			int pa = ((int) Math.floor(page / (10 * tenplace))) + 1; // 나누고 나머지는 버림으로 값구하기
			System.out.println("106줄:" + pa);// 현재 페이지
			mv.addObject("listSize", listSize);
			mv.addObject("page", page);
			mv.addObject("pa", pa);
			mv.addObject("pagination", pg);
			mv.addObject("book", search);
			mv.addObject("keyword", keyword);
			mv.setViewName("/naver/searchBookForm");
		}
		mv.setViewName("/naver/searchBookForm");
		return mv;
	}

	@RequestMapping("/SearchPage") // 페이징을 위해서 따로 만든 컨트롤러
	public ModelAndView searchpage(String keyword, int page, int range, int clikpage, int listSize)
			throws UnsupportedEncodingException, ParseException {
		ModelAndView mv = new ModelAndView();
		PageVo pg = new PageVo();
		int display;
		display = listSize;
		page = clikpage;
		pg.setListSize(listSize);

		if (keyword == null || keyword.equals("")) {
			mv.setViewName("redirect:/Naver/SearchForm");

		} else if (keyword != null) {
			int tenplace = (int) listSize / 10;
			int start = 1 + (10 * tenplace) * (page - 1);
			page = start;

			int total = searchServiceimpl.total(keyword, display, start);
			System.out.println("search 컨트롤러 total:" + total);
			List<SearchVo> search = searchServiceimpl.search(keyword, display, start);

			pg.setListCnt(total);
			pg.pageInfo(page, range, total);
			System.out.println("네이버컨트롤러 :" + pg);
			int pa = ((int) Math.floor(page / (10 * tenplace))) + 1; // 나누고 나머지는 버림으로 값구하기
			System.out.println("106줄:" + pa);// 현재 페이지
			mv.addObject("listSize", listSize);
			mv.addObject("pa", pa);
			mv.addObject("pagination", pg);
			mv.addObject("book", search);
			mv.addObject("keyword", keyword);
			mv.addObject("page", page);
			mv.setViewName("/naver/searchBookForm");
		}
		mv.setViewName("/naver/searchBookForm");
		return mv;
	}

	@RequestMapping("/SearchNext") // next 를위해서 따로 만든 컨트롤러
	public ModelAndView searchnext(String keyword, int page, int range, boolean next, int listSize)
			throws UnsupportedEncodingException, ParseException {
		ModelAndView mv = new ModelAndView();
		PageVo pg = new PageVo();
		int display;
		display = listSize;
		pg.setListSize(listSize);
		System.out.println("next 167번줄page:" + page);

		if (keyword == null || keyword.equals("")) {
			mv.setViewName("redirect:/Naver/SearchForm");

		} else if (keyword != null) {
			if (next = true) {
				int tenplace = (int) listSize / 10; 
				int start = page + 10 * tenplace;
				page = start;
				if (1 <= page) {
					if (page <= 91 + 90 * (tenplace - 1)) {
						range = 1;
						int total = searchServiceimpl.total(keyword, display, start);

						List<SearchVo> search = searchServiceimpl.search(keyword, display, start);

						pg.setListCnt(total);
						pg.pageInfo(page, range, total);
						System.out.println("네이버컨트롤러 :" + pg);
						int pa = ((int) Math.floor(page / (10 * tenplace))) + 1; // 나누고 나머지는 버림으로 값구하기
						System.out.println("152번줄:" + pa);// 현재 페이지
						mv.addObject("listSize", listSize);
						mv.addObject("pa", pa);
						mv.addObject("pagination", pg);
						mv.addObject("book", search);
						mv.addObject("keyword", keyword);
						mv.setViewName("/naver/searchBookForm");
					} else if (page > 91 + 90 * (tenplace - 1)) {

						// System.out.println("126번줄:" + page);
						int lo = (int) Math.log10(page);// 자릿수구하기(실제 자릿수보다 -1이된 결과가 나온다.)
						// System.out.println("128줄:" + lo);
						int po = (int) Math.pow(10, lo); // 제곱구하기
						// System.out.println("130줄:" + po);
						int fl = (int) Math.floor(page / po); // 나누고 나머지는 버림으로 값구하기
						// System.out.println("132줄:" + fl);
						int flnew = (int) Math.floor(fl / tenplace);
						// System.out.println("range NEW:" + rangen);
						range = 1 + flnew;
						// System.out.println("range NEW!:" + range);

						// System.out.println("search 컨트롤러 keyword3:" + keyword);
						int total = searchServiceimpl.total(keyword, display, start);

						List<SearchVo> search = searchServiceimpl.search(keyword, display, start);

						pg.setListCnt(total);
						pg.pageInfo(page, range, total);
						// System.out.println("네이버컨트롤러 :" + pg);
						int pa = ((int) Math.floor(page / (10 * tenplace))) + 1; // 나누고 나머지는 버림으로 값구하기
						// System.out.println("152번줄:" + pa);// 현재 페이지
						mv.addObject("listSize", listSize);
						mv.addObject("pa", pa);
						mv.addObject("pagination", pg);
						mv.addObject("book", search);
						mv.addObject("keyword", keyword);
						mv.setViewName("/naver/searchBookForm");

					}
				}
			}
		}
		mv.setViewName("/naver/searchBookForm");
		return mv;
	}

	@RequestMapping("/SearchPrev") // prev 를위해서 따로 만든 컨트롤러
	public ModelAndView searchprev(String keyword, int page, int range, boolean next, int listSize)
			throws UnsupportedEncodingException, ParseException {
		ModelAndView mv = new ModelAndView();
		PageVo pg = new PageVo();
		int display;
		display = listSize;
		pg.setListSize(listSize);

		if (keyword == null || keyword.equals("")) {
			mv.setViewName("redirect:/Naver/SearchForm");

		} else if (keyword != null) {
			int tenplace = (int) listSize / 10;
			int start = page - 10 * tenplace;
			page = start;
			if (1 <= page) {
				if (page <= 91 + 90 * (tenplace - 1)) {
					range = 1;
					int total = searchServiceimpl.total(keyword, display, start);

					List<SearchVo> search = searchServiceimpl.search(keyword, display, start);

					pg.setListCnt(total);
					pg.pageInfo(page, range, total);
					// System.out.println("네이버컨트롤러 :" + pg);
					int pa = ((int) Math.floor(page / (10 * tenplace))) + 1; // 나누고 나머지는 버림으로 값구하기
					// System.out.println("252번줄:" + pa);// 현재 페이지
					mv.addObject("listSize", listSize);
					mv.addObject("pa", pa);
					mv.addObject("pagination", pg);
					mv.addObject("book", search);
					mv.addObject("keyword", keyword);
					mv.setViewName("/naver/searchBookForm");
				} else if (page > 91 + 90 * (tenplace - 1)) {

					// System.out.println("126번줄:" + page);
					int lo = (int) Math.log10(page);// 자릿수구하기(실제 자릿수보다 -1이된 결과가 나온다.)
					// System.out.println("128줄:" + lo);
					int po = (int) Math.pow(10, lo); // 제곱구하기
					// System.out.println("130줄:" + po);
					int fl = (int) Math.floor(page / po); // 나누고 나머지는 버림으로 값구하기
					// System.out.println("132줄:" + fl);
					int flnew = (int) Math.floor(fl / tenplace);
					// System.out.println("range NEW:" + rangen);
					range = 1 + flnew;
					// System.out.println("range NEW!:" + range);

					int total = searchServiceimpl.total(keyword, display, start);

					List<SearchVo> search = searchServiceimpl.search(keyword, display, start);

					pg.setListCnt(total);
					pg.pageInfo(page, range, total);
					// System.out.println("네이버컨트롤러 :" + pg);
					int pa = ((int) Math.floor(page / (10 * tenplace))) + 1; // 나누고 나머지는 버림으로 값구하기
					// System.out.println("152번줄:" + pa);// 현재 페이지
					mv.addObject("listSize", listSize);
					mv.addObject("pa", pa);
					mv.addObject("pagination", pg);
					mv.addObject("book", search);
					mv.addObject("keyword", keyword);
					mv.setViewName("/naver/searchBookForm");

				}
			}
		}
		mv.setViewName("/naver/searchBookForm");
		return mv;
	}
}
