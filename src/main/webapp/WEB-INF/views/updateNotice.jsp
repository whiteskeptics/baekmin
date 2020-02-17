<%@page import="com.project.bustaja.notice.dao.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	NoticeVO vo = (NoticeVO)request.getAttribute("updateNotice");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h2{text-align: center;}
	#detail{border:1px solid black;width: 600px; margin: 0 auto;padding: 20px;}
	#update{margin-left: 59%; margin-top: 5px;}
	#title{width: 230px;}
</style>
</head>
<body>
<jsp:include page="/NewFile.jsp" flush="false" />
	<h2>공지사항 수정</h2>
	
<form action="/bustaja/updateNoticeImpl.action" >
	<table id="detail">
	<tr>
		<th>제목</th>
		<td><input type="text" value="${vo.title }" name="title" id="title"/></td>
	</tr>
	<tr>
		<th>글쓴이</th>
		<td>${vo.writer }</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${vo.ndate }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea cols="30" rows="10" style="resize: none;" name="ncontents">${vo.ncontents }</textarea></td>
		<input type="text" name="seq" value="${vo.seq}"  hidden="hidden"/>
	</tr>
</table>
	<input type="submit" value="수정하기" id="update"/>
</form>


</body>
</html>