package com.basic.navervo;

public class SearchVo {

	private String keyword; //검색 키워드
	private String title; // 책제목
	private String link; //네이버 도서정보URL
	private String image; //섬네일 이미지URL
	private String author; //저자이름
	private String price;// 가격
	private String discount; //판매가격
	private String publisher; //출판사
	private String pubdate; //출간일
	private String isbn; //ISBN
	private String description; //네이버 도서의 책소개
	private int display; //한번에 표시할 검색결과 갯수(기본:10, 최대:100)
	private int start; //검색시작위치(기본:1, 최대 1000)

	public SearchVo() {
	}

	public SearchVo(String keyword, String title, String link, String image, String author, String price,
			String discount, String publisher, String pubdate, String isbn, String description, int display,
			int start) {
		super();
		this.keyword = keyword;
		this.title = title;
		this.link = link;
		this.image = image;
		this.author = author;
		this.price = price;
		this.discount = discount;
		this.publisher = publisher;
		this.pubdate = pubdate;
		this.isbn = isbn;
		this.description = description;
		this.display = display;
		this.start = start;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDisplay() {
		return display;
	}

	public void setDisplay(int display) {
		this.display = display;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	@Override
	public String toString() {
		return "SearchVo [keyword=" + keyword + ", title=" + title + ", link=" + link + ", image=" + image + ", author="
				+ author + ", price=" + price + ", discount=" + discount + ", publisher=" + publisher + ", pubdate="
				+ pubdate + ", isbn=" + isbn + ", description=" + description + ", display=" + display + ", start="
				+ start + "]";
	}


}
