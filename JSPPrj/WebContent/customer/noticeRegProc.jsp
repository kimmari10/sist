<%@page import="dao.NoticeDao"%>
<%@page import="vo.Notice"%>
<%@page import="dao.NLNoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//	request.setCharacterEncoding("UTF-8");

	String title = request.getParameter("title");
	String file = request.getParameter("file");
	String content = request.getParameter("content");
	
//	title = new String(title.getBytes("ISO-8859-1"), "UTF-8");
//	content = new String(content.getBytes("ISO-8859-1"), "UTF-8");
	
	Notice n = new Notice();
	
	n.setTitle(title);
	n.setContent(content);
	
	NoticeDao dao = new NLNoticeDao();
	
	dao.insert(n);
	
	response.sendRedirect("notice.htm");
	
	


%>
