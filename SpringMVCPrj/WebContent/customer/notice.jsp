<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<section id="content">
		        <h2 class="content-title">공지사항</h2>
		        <h3 class="hidden">경로</h3>
		        <ul id="breadscrumb" class="cf">
		            <li>HOME</li>
		            <li>고객센터</li>
		            <li>공지사항목록</li>
		        </ul>
		        <h3 class="hidden">공지사항검색</h3>
		        <form class="bbs-search-form" action="" method="post">
		            <fieldset>
		                <legend class="hidden">공지사항 검색필드</legend>
		                <label class="hidden" for="f">분류선택</label>
		                <select name="f">
		                    <option value="TITLE">제목</option>
		                    <option value="WRITER">작성자</option>
		                </select>
		                <label class="hidden" for="q">검색어</label>
		                <input type="text" name="q" value="ok good fine" />
		                <input type="submit" value="검색" />
		            </fieldset>
		        </form>
		        <h3 class="hidden">공지사항목록</h3>
		        <table id="notice-list" class="bbs-list">
		            <thead>
		                <tr>
		                    <th class="seq">번호</th>
		                    <th class="title">제목</th>
		                    <th class="writer">작성자</th>
		                    <th class="regdate">작성일</th>
		                    <th class="hit">조회수</th>
		                </tr>
		            </thead>
		            <tbody>
		            <c:forEach var="n" items="${list}">
		                <tr>
		                    <td class="seq">${n.seq}</td>
		                    <td class="title"><a href="noticeDetail.htm?seq=${n.seq }">${n.title}</a></td>
		                    <td class="writer">${n.writer}</td>
		                    <td class="regdate">${n.regdate}</td>
		                    <td class="hit">${n.hit}</td>
		                </tr>		                
		            </c:forEach>
		            </tbody>
		        </table>
		
		        <p id="bbs-status"><span class="strong">1</span> / 2 pages</p>
				
				<p>
					<a href="noticeReg.htm">글쓰기</a>
				</p>
		
				<div id="bbs-pager">					
			        <p>
			            <img alt="이전" src="../images/btnPrev.png" /></p>
			        <ul>
			            <li><a href="" class="strong">1</a></li>
			            <li><a href="">2</a></li>
			            <li><a href="">3</a></li>
			            <li><a href="">4</a></li>
			            <li><a href="">5</a></li>
			        </ul>
			        <p>
			            <img alt="다음" src="../images/btnNext.png" />
			        </p>			        
		       	</div>
		    </section>