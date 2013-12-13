<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<section id="content" class="notice-reg">
	<h2 class="content-title">공지사항</h2>
	<h3 class="hidden">경로</h3>

	<ul id="breadscrumb" class="cf">
		<li>HOME</li>
		<li>마이페이지</li>
		<li>공지사항</li>
	</ul>

<section class="bbs-detail">
	<form action="noticeRegProc.htm" method="get">
		<fieldset>
			<legend class="hidden">공지 필수 입력 사항</legend>
			<dl class="cf">
				<dt>
					<label for="title">제목</label>
				</dt>
				<dd>
					<input type="text" name="title">
				</dd>
				<dt>
					<label for="type">구분</label>
				</dt>
				<dd>
					<input type="checkbox" name="type"><span>공지 고정하기</span>
				</dd>
				<dt class="content">
					<label for="content">공지내용</label>
				</dt>
				<dd class="content">
					<textarea name="content"></textarea>
				</dd>
				<dt>
					<label for="file">파일첨부</label>
				</dt>
				<dd>
					<input type="file" name="file">
				</dd>
			</dl>
			
			<p>
				<input class="button btn-save" type="submit" value="등록">
				<a class="button btn-cancel" href="notice.htm">취소</a>
			</p>
		</fieldset>
	</form>
	</section>

</section>