<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	int x = 0;
	int y = 0;
	
	if(request.getMethod().equals("POST"));
	{
		String sx = request.getParameter("x");
		String sy = request.getParameter("y");
		
		x = Integer.parseInt(sx);
		y = Integer.parseInt(sy);
	}
%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<form action="calc.jsp" method="post">
		<ul>
			<li> <label for="x">X : </label> <input name ="x" /> </li>
			<li> <label for="y">Y : </label> <input name ="y" /> </li>
		</ul>
		<p><input type="submit" value="덧셈" /></p>
		<p> result <%=x+y %></p>
	</form>
</body>

</html>