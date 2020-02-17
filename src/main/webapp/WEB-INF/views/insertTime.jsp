<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h2{text-align: center; margin-top: 5%;}
	#time{
	border: 1px solid black;
	width: 400px;
	margin-left:42%;
	padding-left: 25px;
	padding-top: 10px;
	padding-bottom: 10px;
	}
	#list{margin-left: 55%; padding: 10px;}
</style>
</head>
<body>
<jsp:include page="/NewFile.jsp" flush="false" />
<div id="insertDivvv">
<h2>배차 추가하기</h2>
<div id="time">
<form action="/bustaja/insertTimeaa.action" method="get">
	<table>
		<tr>
			<td>노선코드</td>
			<td><input type="text" name="routeNum" /></td>
		</tr>
		
		<tr>
			<td>회사코드</td>
			<td><input type="text" name="company" /></td>
		</tr>
		<tr>
			<td>좌석등급코드</td>
			<td><input type="text" name="seatClass" /></td>
		</tr>
		
		<tr>
			<td>출발시간</td>
			<td><input type="text" name="startTime" /></td>
		</tr>
		<tr>
			<td>차량번호</td>
			<td><input type="text" name="busNum" /></td>
			<td colspan="2"><input type="submit" value="새글등록" /></td>
		</tr>
	</table>	
</form>
</div>
   <div id="list">
   <a href="/bustaja/timeList.action">목록보기</a>
   </div>
</div>
</body>
</html>