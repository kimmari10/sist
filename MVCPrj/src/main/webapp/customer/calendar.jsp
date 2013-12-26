<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/reset.css" rel="stylesheet" type="text/css">
<style>
	.calendar
	{
	
	}
		
	.calendar thead th
	{
		width : 102px;
		height:37px;
		background: #8cba35;
		text-align:center;
	}
	
	.calendar thead th span
	{
		font-family:Arial;
		font-size:11px;
		font-weight:bold;
		color:#909090;
		display:inline-block;
		width:92px;
		height: 23px;
		line-height:23px;
		background: #ffffff;
		border: 1px solid #9f9f9f;
	}
	
	.calendar tbody td
	{
		vertical-align:top;
		
		padding:5px;
		font-family: 맑은 고딕;
		font-size: 11px;
		font-weight:bold;
		color:#ffffff;
		/* color:#8cba35; */
		
		width: 92px;/* 102px-10px(td패딩); */
		height: 72px;/* 88px-10px(td패딩); */
		border-right: 1px solid #8cba35;/* d9e8bc */
		border-bottom: 1px solid #8cba35;
	}
	
	.calendar tbody td p
	{
		width:100%;
	}
	
	.calendar tbody td p.day
	{
		height: 25px;
	}
	
	.calendar tbody td p.day span
	{
		display:inline-block;
		width:25px;		
		height:25px;
		background: #8cba35;
		
		vertical-align:top;
		text-align:center;
		line-height:25px;
	}
	
	.calendar tbody td p.report
	{
		margin-top:5px;
		height: 26px;/* 18px+8px; */
	}
	
	.calendar tbody td p.report span
	{		
		padding:4px;
		background: #222222;
	}
	
	
	
	.calendar tbody td:last-child
	{
		border-right: 0px solid #ffffff;/* d9e8bc */		
	}
	
	.calendar tbody tr:last-child td
	{
		border-bottom: 0px solid #ffffff;/* d9e8bc */
	}
	
</style>
</head>
<body>
<table class="calendar">
		<thead>
			<tr>
				<th><span>Sunday</span></th>
				<th><span>Monday</span></th>
				<th><span>Tuesday</span></th>
				<th><span>Wednesday</span></th>
				<th><span>Thursday</span></th>
				<th><span>Friday</span></th>
				<th><span>Saturday</span></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="w" begin="0" end="5">
			<tr>
				<c:forEach var="d" begin="0" end="6">
				<td>
					<p class="day"><span>${w*7+d+1}</span></p>
					<p class="report"><span>과제없음</span></p>
					<p><span>제출</span></p>
				</td>
				</c:forEach>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>