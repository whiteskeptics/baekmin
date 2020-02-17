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
	#addForm{border: 1px solid black; width: 400px; margin-left: 40%; padding-left: 4%; padding-top: 10px;}
	#list{margin-left: 55%; padding: 6px;}
</style>
</head>
<body>
<jsp:include page="/NewFile.jsp" flush="false" />
	<div id="insertDiv">
<h2>터미널추가</h2>
<div id="addForm">
	<form action="/bustaja/terminalInsertaa.action" method="get">
		<table>
			<tr>
				<th>터미널코드</th>
				<td><input type="text" name="termCode" /></td>
			</tr>
			
			<tr>
				<th>터미널명</th>
				<td><input type="text" name="termName" /></td>
			</tr>
			
			<tr>
				<th>버스타입</th>
				<td><input type="text" name="busType" /></td>
			</tr>
			
			<tr>
				<th>주소</th>
				<td><input type="text" name="address" /></td>
			</tr>
			
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="phone" /></td>
			</tr>
			
			<tr>
				<th>홈페이지</th>
				<td><input type="text" name="homepage" /></td>
				<td colspan="2"><input type="submit" value="추가" /></td>
			</tr>
		</table>	
		<div id="list">
			<a href="/bustaja/terminalList.action"><b>[목록으로]</b></a>
		</div>
	</form>
</div>
   
</div>
</body>
</html>