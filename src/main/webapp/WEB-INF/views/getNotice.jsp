<%@page import="com.project.bustaja.notice.dao.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

	NoticeVO vo = (NoticeVO)request.getAttribute("getNotice");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h2{text-align: center;}
	#detail{border:1px solid black;width: 600px; margin: 0 auto;padding: 20px;}
	#list{margin-left: 58%; padding: 10px;}
</style>
</head>
<body>
<jsp:include page="/NewFile.jsp" flush="false" />
<h2>공지사항</h2>
<table id="detail">
	<tr>
		<th>제목</th>
		<td>${getNotice.title }</td>
	</tr>
	<tr>
		<th>글쓴이</th>
		<td>${getNotice.writer }</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${getNotice.ndate }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea cols="30" rows="10" readonly="readonly" style="resize: none; ">${getNotice.ncontents }</textarea></td>
	</tr>
</table>
<div id="list">
<a href="/bustaja/noticeList.action"><b>[목록]</b></a>
<a href="/bustaja/updateNotice.action?seq=${getNotice.seq}"><b>[수정]</b></a>
</div>
</body>
</html>