<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="description" content="Java, spring, .net, 온라인교육, 온라인강의, 온라인강좌, 동영상교육, 동영상강의, 동영상강좌, 웹디자인, 웹마스터, 프로그래밍, 서버, 데이터베이스, 오피스, 캐드, 3D, 멀티미디어, 사이버캠퍼스, 사이버연수원, 사이버아카데미" />
    <meta charset="utf-8" />
    <title>뉴렉처는 IT 전문가들을 위한 배움터입니다.</title>    
 	<link type="text/css" href="../css/style.css" rel="stylesheet" />
 	<link type="text/css" href="../css/layout.css" rel="stylesheet" />
</head>
<body>
    <!-- header 부분 -->
	<header id="header">
    	<div class="top-wrapper">
	        <h1 id="title"><a href="">
	            <img alt="뉴렉처" src="../../images/logo.png" /></a></h1>
	        <section>
	            <h1 class="hidden">바로가기 메뉴</h1>
	            <nav id="pop-menu" class="hr-menu cf">
	                <h1 class="hidden">인기메뉴</h1>
	                <ul>
	                    <li><a href="">학습가이드</a></li>
	                    <li><a href="">과정선택</a></li>
	                    <li><a href="">인기과정</a></li>
	                </ul>
	            </nav>
	            <h2 class="hidden">바로검색</h2>
	            <form id="search-form">
	                <fieldset>
	                    <legend class="hidden">검색필드</legend>
	                    <label for="q">과정검색</label>
	                    <input name="q"/>
	                    <input type="submit" value="검색" />
	                </fieldset>
	            </form>
	            <nav id="member-menu" class="hr-menu cf">
	                <h1 class="hidden">회원메뉴</h1>
	                <ul>
	                    <li><a href="../../index.jsp">HOME</a></li>	                   	
	                    <li><a href="../../joius/login.jsp">로그인</a></li>
	                    <li><a href="../../joius/join.jsp">회원가입</a></li>	                    
	                </ul>
	            </nav>
	            <nav id="customer-menu" class="hr-menu cf">
	                <h1 class="hidden">고객센터메뉴</h1>
	                <ul>
	                    <li><a href="memberList.jsp">
	                        <img alt="마이페이지" src="../../images/txtMyPage.png" /></a></li>
	                    <li><a href="../../customer/notice.jsp">
	                        <img alt="고객센터" src="../../images/txtCustomer.png" /></a></li>
	                </ul>
	            </nav>
	        </section>
        </div>
    </header>
    <!-- visual 부분 -->
 	<div id="visual" class="admin">
		<div class="top-wrapper">
			
		</div>
	</div>
    <div id="body">
    	<div class="top-wrapper cf">
	<!-- aside 부분 -->
			<aside id="aside">
				<h1 class="aside-title">ADMIN PAGE</h1>
				<nav id="aside-menu">
					<h1 class="hidden">관리자 메뉴</h1>
					<ul class="aside-menu">
						<li><a href="">관리자 홈</a></li>
						<li><a href="">관리자 정보</a></li>
					</ul>
                 </nav>
                 <nav id="admin-aside-menu">
		            <h1 class="aside-sub-title">수강관리</h1>
		            <ul class="aside-menu">
		                <li><a href="">입금확인</a></li>
						<li><a href="">환불</a></li>
						<li><a href="">문의게시판</a></li>
						<li><a href="">QnA</a></li>
						<li><a href="">이벤트</a></li>
						<li><a href="">쿠폰</a></li>             
		            </ul>
		        </nav>
                 <nav id="admin-aside-menu">
		            <h1 class="aside-sub-title">공지관리</h1>
		            <ul class="aside-menu">
		                <li><a href="">공지사항</a></li>
						<li><a href="">뉴렉처소식</a></li>
						<li><a href="">팝업공지</a></li>
						<li><a href="">슬라이더</a></li>
						<li><a href="">추천강좌</a></li>             
		            </ul>
		        </nav>
                 <nav id="admin-aside-menu">
		            <h1 class="aside-sub-title">회원관리</h1>
		            <ul class="aside-menu">
		                <li><a href="">역할 그룹</a></li>
						<li><a href="" class="selected">전체회원</a></li>
						<li><a href="">관리자</a></li>
						<li><a href="">선생님</a></li>
						<li><a href="">홍보담당자</a></li>             
		            </ul>
		        </nav>
                 <nav id="recmd-menu">
		         	<h1 class="aside-ext-title">추천사이트</h1>
		            <ul>
		                <li><a href="">
		                    <img alt="answeris" src="../../images/answeris.png" /></a></li>
		                <li><a href="">
		                    <img alt="microsoft" src="../../images/microsoft.png" /></a></li>
		                <li><a href="">
		                    <img alt="w3c" src="../../images/w3c.png" /></a></li>
		            </ul>
		        </nav>
			</aside>
	<!-- content 부분 -->
			<section id="content" class="memberList">
		        <h2 class="content-title">회원목록</h2>
		        <h3 class="hidden">경로</h3>
		        <ul id="breadscrumb" class="cf">
		            <li>HOME</li>
		            <li>관리자</li>
		            <li>회원관리</li>
		            <li>전체회원</li>
		        </ul>
		        <h3 class="content-sub-title">멤버 검색</h3>
		        <form class="member-search-form" action="memberList" method="get">
		            <fieldset>
		                <legend class="hidden">공지사항 검색필드</legend>
		                <label class="hidden" for="f">분류선택</label>
		                <label for="q">검색어</label>
		                <select name="f">
		                
		                    <option <c:if test="${field!=uid }">selected="selected"</c:if> value="uid">아이디</option>
		                    <option <c:if test="${field!=name }">selected="selected"</c:if> value="name">이름</option>
		                </select>		                
		                <input type="text" name="q" value="${query }" placeholder="검색어를 입력하세요" />
		                <input type="submit" value="검색" />
		                <input type="date" name="sd" value="${sday }"/>~<input type="date" name="ed" value="${eday }" />
		            </fieldset>
		        </form>		        
		        <h3 class="hidden">검색 목록</h3>		        
		        <form action="memberList" method="post" class="member-modify-form">		        	
		        	<fieldset>
		        		<legend class="hidden">멤버 역할을 위한 컬럼</legend>
		        		<p class="count">검색된 회원 수 <span>30</span></p>		        		
			        	<p class="error <c:if test="${empty param.err}">hidden</c:if>">오류 : 하나이상의 회원을 선택해야 합니다.</p>
			        	<p class="role-modify">
			        	선택된 멤버를
			        	<select name="role">
			        		<option value="Student">학생</option>
			        		<option value="Teacher">선생님</option>
			        		<option value="Admin">관리자</option>
			        	</select>
			        	으로<input class="btn-admin" type="submit" value="변경">합니다.
			        	</p>
			        	<table>
			        		<thead>
			        			<tr>
			        				<th class="sel"></th>
			        				<th class="uid">이름(아이디)</th>
			        				<th class="role">멤버등급</th>
			        				<th class="regdate">가입일자</th>
			        				<th class="gender">성별</th>
			        				<th class="birth">상태</th>
			        				<th class="last">최종방문일</th>
			        				<th class="phone">전화번호</th>
			        			</tr>
			        		</thead>			        		
				        		<tbody>
				        		<c:forEach var="list" items="${list }">
				        			<tr>
				        				<td class="sel"><input name="uid" type="checkbox" value="${list.uid}" /></td>
				        				<td class="uid">${list.name}(${list.uid})</td>
				        				<td class="role">${list.defaultRole}</td>
				        				<td class="regdate">${list.regDate}</td>
				        				<td class="gender">${list.gender}</td>
				        				<td class="birth">${list.inActivity}</td>
				        				<td class="last">${list.loginTime}</td>
				        				<td class="phone">${list.phone}</td>
				        			</tr>
				        		</c:forEach>
				        		</tbody>
			        	</table>
			        	<p class="buttons">
			        		<span>선택한 회원에게 <a class="btn-admin" href="">쪽지</a></span>
			        		<span>선택한 회원을 <a class="btn-admin" href="">수정</a></span>
			        		<input type="submit" class="btn-admin" name="active" value="활성"/>
			        		<input type="submit" class="btn-admin" name="inactive" value="정지"/>
			        		<input type="submit" class="btn-admin" name="leave" value="탈퇴"/>
			        	</p>
			        </fieldset>
		        </form>
		        
		        <ul>
		        	<li><a href="memberList.jsp?p=1&q=${query }&f=${field }&sd=${sday }&ed=${eday}">1</a></li>
		        	<li><a href="memberList.jsp?p=2&q=${query }&f=${field }&sd=${sday }&ed=${eday}">2</a></li>
		        	<li><a href="memberList.jsp?p=3&q=${query }&f=${field }&sd=${sday }&ed=${eday}">3</a></li>
		        	<li><a href="memberList.jsp?p=4&q=${query }&f=${field }&sd=${sday }&ed=${eday}">4</a></li>
		        	<li><a href="memberList.jsp?p=5&q=${query }&f=${field }&sd=${sday }&ed=${eday}">5</a></li>
		        	<li><a href="memberList.jsp">홈</a></li>
		        </ul>
		        
		
		        
				
		    </section>
	    </div>
    </div>
    <!-- footer 부분 -->
	<footer id="footer">
    	<div class="top-wrapper">
	        <h1>
	            <img alt="뉴렉처" src="../../images/footerLogo.png" /></h1>
	        <dl>
	            <dt>주소</dt>
	            <dd>서울시 동대문구 장안1동 423-4 윤진빌딩 4층</dd>
	            <dt>관리자메일</dt>
	            <dd>admin@newlecture.com</dd>
	        </dl>
	        <p>주소 : 서울시 동대문구 장안1동 423-4 윤진빌딩 4층</p>
	        <p>관리자메일 : admin@newlecture.com</p>
	        <p>전화 : [죄송합니다. 당분간 문의내용은 고개센터 메뉴에서 1:1 문의를 이용해주시기 바랍니다]</p>
	        <p>사업자등록번호 : 132-18-46763 </p>
	        <p>통신판매업신고 : 제 2013-서울강동-0969 호</p>
	        <p>관리자 : 전성일</p>
	        <p>Copyright ⓒ newlecture.com 2012-2013 All Right Reserved. Contact master@newlecture.com for more information</p>
        </div>
    </footer>
</body>
</html>




