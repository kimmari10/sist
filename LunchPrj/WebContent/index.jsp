<%@page import="com.newlecture.mvcprj.vo.Menu"%>
<%@page import="com.newlecture.mvcprj.dao.MenuDaoImp"%>
<%@page import="com.newlecture.mvcprj.dao.MenuDao"%>
<%@page import="com.newlecture.mvcprj.vo.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.mvcprj.dao.OrderDaoImp"%>
<%@page import="com.newlecture.mvcprj.dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	OrderDao dao = new OrderDaoImp();
	MenuDao mdao = new MenuDaoImp();
	
	if(request.getParameter("order") != null)
	{
		String n = request.getParameter("name");
		String m = request.getParameter("menu");
		dao.order(n,m);
	}
	
	if(request.getParameter("add") != null)
	{
		String item = request.getParameter("i");
		String shop = request.getParameter("s");
		String price = request.getParameter("p");
	  	mdao.add(item, shop, price);
	}
	
	List<Menu> mlist = mdao.getMenus();
	List<Order> list = dao.getOrders();
	pageContext.setAttribute("list",  list);
	pageContext.setAttribute("mlist",  mlist);
	
%>

<!DOCTYPE html>
<html>
<head>
</head>
	<body>
		<form action="index.jsp" method="post">
			<fieldset>
				<legend>메뉴추가</legend>
				<label>음식이름</label><input type="text" name="i" />
				<label>가게이름</label><input type="text" name="s" />
				<label>가격</label><input type="text" name="p" />
				<input type="submit" name="add" value="메뉴추가" />
			</fieldset>
			
		</form>
	
	
		<form action="index.jsp" method="post">
			<fieldset>
				<legend>주문 화면</legend>
				<label>이름</label>
				<input type="text" name="name" />
					<select name="menu">
					<c:forEach var="m" items="${mlist }">
						<option value="${m.item }">${m.item }(${m.price }원)</option>
					</c:forEach>
					</select>
					<input type="submit" name="order" value="메뉴신청"/>
			</fieldset>
		</form>
		<p>오늘의 메뉴신청 목록</p>
		<dl>
		<dt>이름</dt><dd>메뉴</dd>
			<c:forEach var="list" items="${list }">
			<dt>${list.name }</dt><dd>${list.ordermenu }</dd>
			</c:forEach>
		</dl>
	</body>
</html>		
