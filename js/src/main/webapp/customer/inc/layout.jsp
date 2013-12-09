<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
	<Meta name="description" content="Java, spring, .net, 온라인교육, 온라인강의, 온라인강좌, 동영상교육, 동영상강의, 동영상강좌, 웹디자인, 웹마스터, 프로그래밍, 서버, 데이터베이스, 오피스, 캐드, 3D, 멀티미디어, 사이버캠퍼스, 사이버연수원, 사이버아카데미">
    <meta charset="utf-8" />
    <title>뉴렉처는 IT 전문가들을 위한 배움터입니다.</title>    
 	<link type="text/css" href="css/style.css" rel="stylesheet" />
 	<link type="text/css" href="css/layout.css" rel="stylesheet" />
</head>
<body>
    <!-- header 부분 -->
    <tiles:insertAttribute name="header" />
    <!-- visual 부분 -->
    <tiles:insertAttribute name="visual" />
    <div id="body">
    	<div class="top-wrapper cf">
		    <!-- aside 부분 -->
		    <tiles:insertAttribute name="aside" />
		    <!-- content 부분 -->
		    <tiles:insertAttribute name="content" />
	    </div>
    </div>
    <!-- footer 부분 -->
    <tiles:insertAttribute name="footer" />
</body>
</html>




