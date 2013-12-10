package com.gongbang.vo;

import java.sql.Date;

public class BBS {
	String seq;
	String title;
	String content;
	int sell;
	String writer;
	String regdate;
	int hit;
	String catenum; 	//카테고리
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSell() {
		return sell;
	}
	public void setSell(int sell) {
		this.sell = sell;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getCatenum() {
		return catenum;
	}
	public void setCatenum(String catenum) {
		this.catenum = catenum;
	}
	
	
	
}
