package com.basic.search.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.basic.navervo.SearchVo;

@Service("SearchService")
public class SearchService

{

	private static String clientID = "90qYXg5ocmYZBSUUgGrc";
	private static String clientSecret = "aVh1gplt9H";

	public List<SearchVo> search(String keyword, int display, int start)
			throws ParseException, UnsupportedEncodingException {

		List<SearchVo> search = new ArrayList<SearchVo>();
		System.out.println("서비스 display:" + display + ", start:" + start);

		String apiURL = ("https://openapi.naver.com/v1/search/" + "book.json?query="
				+ URLEncoder.encode(keyword, "UTF-8") + (display != 0 ? "&display=" + display : "")
				+ (start != 0 ? "&start=" + start : ""));

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientID);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		String responseBody = get(apiURL, requestHeaders);
		// System.out.println("47번줄 :" + apiURL);

		JSONParser parser = new JSONParser();
		// JSON데이터를 넣어 JSON Object 로 만들어 준다.
		Object obj = parser.parse(responseBody);
		JSONObject jsonObj = (JSONObject) obj;
		// json Object로 파싱한뒤에 jsonArraylist 형태로 다시 파싱한뒤에 안에서 필요한 정보를 꺼낸다.
		JSONArray bookInfoArray = (JSONArray) jsonObj.get("items");

		for (int i = 0; i < bookInfoArray.size(); i++) {
			// 계속해서 Vo 새롭게 할당해줘야한다 그렇지 않으면 계속해서 들어오는 정보가 이미있는 정보를 덮어 버린다.
			SearchVo searchVo = new SearchVo();

			System.out.println("=BOOK_" + i + " ===========================================");

			// 배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
			JSONObject bookObject = (JSONObject) bookInfoArray.get(i);

			// JSON name으로 추출
			System.out.println("bookInfo: price==>" + bookObject.get("title"));

			searchVo.setTitle((String) bookObject.get("title"));
			searchVo.setLink((String) bookObject.get("link"));
			searchVo.setImage((String) bookObject.get("image"));
			searchVo.setAuthor((String) bookObject.get("author"));
			searchVo.setPrice((String) bookObject.get("price"));
			searchVo.setDiscount((String) bookObject.get("discount"));
			searchVo.setPublisher((String) bookObject.get("publisher"));
			searchVo.setPubdate((String) bookObject.get("pubdate"));
			searchVo.setIsbn((String) bookObject.get("isbn"));
			searchVo.setDescription((String) bookObject.get("description"));

			search.add(i, searchVo);

		}

		return search;

	}

	private static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 오류 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
		}
	}

	public int total(String keyword, int display, int start) throws UnsupportedEncodingException, ParseException {

		String apiURL = ("https://openapi.naver.com/v1/search/" + "book.json?query="
				+ URLEncoder.encode(keyword, "UTF-8") + (display != 0 ? "&display=" + display : "")
				+ (start != 0 ? "&start=" + start : ""));

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientID);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		String responseBody = get(apiURL, requestHeaders);

		JSONParser parser = new JSONParser();
		// JSON데이터를 넣어 JSON Object 로 만들어 준다.
		Object obj = parser.parse(responseBody);
		JSONObject jsonObj = (JSONObject) obj;
		// json Object로 파싱한뒤에 Object 형태로 다시 파싱한뒤에 안에서 필요한 정보를 꺼낸다.
		// Object 형태말고 그냥 int 형태로 꺼낼려했지만 되지않는다.

		// int 타입으로 꺼낼때 아래코드를 이용
		int total = Integer.parseInt(String.valueOf(jsonObj.get("total")));

		// System.out.println(jsonObj.toString());

		return total;
	}

}
