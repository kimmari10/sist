<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="description" content="Java, spring, .net, 온라인교육, 온라인강의, 온라인강좌, 동영상교육, 동영상강의, 동영상강좌, 웹디자인, 웹마스터, 프로그래밍, 서버, 데이터베이스, 오피스, 캐드, 3D, 멀티미디어, 사이버캠퍼스, 사이버연수원, 사이버아카데미" />
    <meta charset="utf-8" />
    <title>뉴렉처는 IT 전문가들을 위한 배움터입니다.</title>    
 	<link type="text/css" href="css/style.css" rel="stylesheet" />
 	<link type="text/css" href="css/layout.css" rel="stylesheet" />
</head>
<body>
    <!-- header 부분 -->
	<header id="header">
    	<div class="top-wrapper">
	        <h1 id="title"><a href="">
	            <img alt="뉴렉처" src="../images/logo.png" /></a></h1>
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
	                    <li><a href="../index.jsp">HOME</a></li>	                   	
	                    <li><a href="../joinus/login.jsp">로그인</a></li>
	                    <li><a href="../joinus/join.jsp">회원가입</a></li>
	                </ul>
	            </nav>
	            <nav id="customer-menu" class="hr-menu cf">
	                <h1 class="hidden">고객센터메뉴</h1>
	                <ul>
	                    <li><a href="">
	                        <img alt="마이페이지" src="../images/txtMyPage.png" /></a></li>
	                    <li><a href="notice.jsp">
	                        <img alt="고객센터" src="../images/txtCustomer.png" /></a></li>
	                </ul>
	            </nav>
	        </section>
        </div>
    </header>
    <!-- visual 부분 -->
 	<div id="visual">
    	<div class="top-wrapper">
    		<!-- 비주얼방 -->
    	</div>
    </div>
    <div id="body">
    	<div class="top-wrapper cf">
	<!-- aside 부분 -->
			<aside id="aside">
		        <h1 class="aside-title">고객센터</h1>
		        <nav id="aside-menu">
		            <h1 class="hidden">고객센터메뉴</h1>
		            <ul class="aside-menu">
		                <li><a href="">뉴렉처소식</a></li>
		                <li><a href="">공지사항</a></li>
		                <li><a href="">1:1고객센터</a></li>
		                <li><a href="">학습도구</a></li>
		                <li><a href="">학습안내</a></li>
		            </ul>
		        </nav>
		        <nav id="admin-aside-menu">
		            <h1 class="aside-sub-title">관리자</h1>
		            <ul class="aside-menu">
		                <li><a href="">관리자 페이지</a></li>
		                <li><a href="">모모 몰라</a></li>
		            </ul>
		        </nav>
		        <nav id="recmd-menu">
		            <h1 class="aside-ext-title">추천사이트</h1>
		            <ul>
		                <li><a href="">
		                    <img alt="answeris" src="../images/answeris.png" /></a></li>
		                <li><a href="">
		                    <img alt="microsoft" src="../images/microsoft.png" /></a></li>
		                <li><a href="">
		                    <img alt="w3c" src="../images/w3c.png" /></a></li>
		            </ul>
		        </nav>
		    </aside>
	<!-- content 부분 -->
			<section id="content" class="notice-detail">
		        <h2 class="content-title">공지사항</h2>
		        <h3 class="hidden">경로</h3>
		        <ul id="breadscrumb" class="cf">
		            <li>HOME</li>
		            <li>고객센터</li>
		            <li>공지사항수정</li>
		        </ul>
		        <!-- --------------------------------- -->
		        <section class="bbs-detail">
			        <h1 class="hidden">공지 수정</h1>
			        <form action="" method="post">
			        	<fieldset>
			        		<legend>공지 사항 필수 수정 필드</legend>
					        <dl class="cf">       	
					        	<dt><label for="title">제목</label></dt>
					        	<dd>
					        		<input type="text" name="title" />
					        	</dd>			        	
					        	<dt><label for="type">구분</label></dt>
					        	<dd><input type="checkbox" name="type" /><span>공지 고정하기</span></dd>
					        	<dt><label for="content">공지내용</label></dt>
					        	<dd><textarea name="content"></textarea></dd>					        	
					        	<dt><label for="file">파일첨부</label></dt>
					        	<dd><input type="file" name="file" /></dd>					        			        		        	
				        	</dl>
				        	<p>
				        		<input type="submit" value="등록" />
				        		<a href="notice.jsp">취소</a>
				        	</p>
				        </fieldset>       
			        </form>
		        </section>		        
		        <!-- --------------------------------- -->
		    </section>   
	    </div>
    </div>
    <!-- footer 부분 -->
	<footer id="footer">
    	<div class="top-wrapper">
	        <h1>
	            <img alt="뉴렉처" src="${pageContext.request.contextPath}/images/footerLogo.png" /></h1>
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




