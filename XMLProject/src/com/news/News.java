package com.news;
//vo:기사 1건의 정보를 저장하는 객체
public class News {
	private String title;
	private String pubDate;
	
	public News() {
		
	}

	public News(String title, String pubDate) {
		this.title = title;
		this.pubDate = pubDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	@Override
	public String toString() {
		return title + " - " + pubDate;
	}
	
	
}
