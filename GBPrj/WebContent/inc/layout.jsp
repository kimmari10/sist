<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gong bang</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="../css/reset.css" rel="stylesheet" media="screen">
<link href="../css/prj.css" rel="stylesheet" media="screen">
</head>

<body>
	<div id="wrapper" class="cf">
	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="aside"/>
	<tiles:insertAttribute name="content"/>
	</div>

	
</body>

</html>