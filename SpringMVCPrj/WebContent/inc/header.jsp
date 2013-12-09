<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<header id="header">
    	<div class="top-wrapper">
	        <h1 id="title"><a href=""> 
	            <img alt="뉴렉처" src="<c:url value="/images/logo.png"/>" /></a></h1>
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
	                    <li><a href="../index.htm">HOME</a></li>
	                    
	                    <li>
	                    	<c:if test="${empty sessionScope.uid }">
		                    	<a href="<c:url value="/joinus/login.htm"/>">로그인</a>
	                    	</c:if>
	                    	<c:if test="${not empty sessionScope.uid }">
		                    	<a href="<c:url value="/joinus/logoutProc.htm"/>">로그아웃</a>
	                    	</c:if>
	                    </li>
	                    <li><a href="<c:url value="/joinus/join.htm"/>">회원가입</a></li>	                    
	                </ul>
	            </nav>
	            <nav id="customer-menu" class="hr-menu cf">
	                <h1 class="hidden">고객센터메뉴</h1>
	                <ul>
	                
	                    <li><a href="<c:url value="/joinus/join.htm"/>">
	                        <img alt="마이페이지" src="<c:url value="/images/txtMyPage.png"/>" /></a></li>
	                    <li><a href="<c:url value="/customer/notice.htm"/>">
	                        <img alt="고객센터" src="<c:url value="/images/txtCustomer.png"/>" /></a></li>
	                </ul>
	            </nav>
	        </section>
        </div>
    </header>