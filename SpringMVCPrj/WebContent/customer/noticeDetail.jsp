<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<section id="content">
	<h2 class="content-title">공지사항</h2>
	<h3 class="hidden">경로</h3>

	<ul id="breadscrumb" class="cf">
		<li>HOME</li>
		<li>고객센터</li>
		<li>공지사항</li>
	</ul>

	<article class="bbs-detail">
		<h1 class="hidden">공지내용</h1>
		<dl>
			<dt>제목</dt>
			<dd class="strong">${n.title }</dd>
			<dt>작성일</dt>
			<dd>${n.regdate }</dd>
			<dt>작성자</dt>
			<dd class="half">${n.writer }</dd>
			<dt>조회수</dt>
			<dd class="half">${n.hit }</dd>
			<dt>첨부파일</dt>
			<dd>asd.png</dd>
			<dt class="hidden">내용</dt>
			<dd class="full">${n.content}<br /> dasd <br /> dasd <br />
				dasd <br /> dasd <br /> dasd <br /> dasd <br /> dasd <br />
				dasd <br /> dasd <br />

			</dd>
			<dt>첨부파일</dt>
			<dd>asd.png</dd>

		</dl>
	</article>

	<div class="">
		<p>
			<a href="">목록</a>
		</p>
		<p>
			<a href="">수정</a>
		</p>
		<p>
			<a href="">삭제</a>
		</p>
		<p>
			<a href="">이전글</a>
		</p>
		<p>
			<a href="">다음글</a>
		</p>
	</div>
</section>