<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>index</title>

<link href="css/layout.css" type="layout/css" rel="stylesheet" />
<link href="css/style.css" type="style/css" rel="stylesheet" />

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
