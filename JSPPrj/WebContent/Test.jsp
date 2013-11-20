<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="cf.css" type="text/css" rel="stylesheet" />
</head>
<body style="background-color: teal;">


<div>
<center>
<br/><br/>
<br/><br/>
<br/><br/>
</center>
<form action="../adminPage/loginProc.htm" method="post">
	<center>
						<dl>
							<dt style="font-size: 15px; color: white; font-family: 바탕체;">
								ID
							</dt>
							<dd >
								&nbsp;<input style="margin-left : -40px;  padding: 10px 10px; font-size: 15px;" name="id" value=""/>
							</dd>
						</dl>	
						<br/>
						<dl>
							<dt style="font-size: 15px; color: white; font-family: 바탕체;">
								PW
							</dt>
							<dd>
								&nbsp;<input style="margin-left : -40px; padding: 10px 10px; font-size: 15px;" type="password" name="pwd" value=""/>
							</dd>
						</dl>
						<br/>
						<input type="submit" class="button" value="로그인"></input>
							
	</center>
</form>
</div>
<br/><br/><br/>
<center>
<div style="font-size: 100px; color: red; font-family: 궁서체; ">
	
</div>
</center>
</body>
</html>