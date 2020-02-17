<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h2{text-align: center; margin-top: 5%;}
#notice{
	border: 1px solid black; 
	width: 400px; 
	margin-left: 43%;
	padding-left: 10px;
	padding-top: 10px;
	}
	#list{margin-left: 56%; padding: 10px;}
</style>
</head>
<body>
<jsp:include page="/NewFile.jsp" flush="false" />
	<h2>공지사항 추가</h2>
<div id="notice">
<form action="/bustaja/noticeInsertaa.action" method="get">
	<table>
		<tr>
			<td>글제목</td>
			<td><input type="text" name="title" /></td>
		</tr>
		
		<tr>
			<td>글쓴이</td>
			<td><input type="text" name="writer" value="${userName }" readonly="readonly"/></td>
		</tr>
		
		<tr>
		<td>글내용</td>
		<td><textarea name="nContents" id=nContents cols="30" rows="10" style="resize: none; "></textarea></td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" value="새글등록" /></td>
			
		</tr>
	</table>	
</form>
</div>
<div  id="list">
   <a href="/bustaja/noticeList.action">글목록</a>
</div>
</body>
</html>