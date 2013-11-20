<%@page import="dao.NLNoticeDao"%>
<%@page import="dao.NoticeDao"%>
<%@page import="vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String seq = request.getParameter("seq");
	
	
	NoticeDao dao = new NLNoticeDao();
	
	dao.delete(seq);
	
	response.sendRedirect("notice.jsp");
	




%>