<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h2{text-align: center; margin-top: 5%;}
#travel{
	border: 1px solid black;
	width: 400px;
	margin-left: 43%;
	padding-left: 30px;
	padding-top: 11px;
	padding-bottom: 11px;
	}
#list{margin-left: 57%; padding: 10px;}
</style>
</head>
<body>
<div id="insertDivv">
<jsp:include page="/NewFile.jsp" flush="false" />
<h2>운행노선 추가하기</h2>
<div id="travel">
<form action="/bustaja/insertTravelaa.action" method="get">
	<table>
		<tr>
			<td>운행코드</td>
			<td><input type="text" name="travelNum" /></td>
		</tr>
		
		<tr>
			<td>출발지</td>
			<td><input type="text" name="departure" /></td>
		</tr>
		<tr>
			<td>도착지</td>
			<td><input type="text" name="destination" /></td>
		</tr>
		
		<tr>
			<td>소요시간</td>
			<td><input type="text" name="runTime" /></td>
		</tr>
		<tr>
			<td>거리</td>
			<td><input type="text" name="distance" /></td>
		</tr>
		
		<tr>
			<td>요금</td>
			<td><input type="text" name="fee" /></td>
		</tr>
		<tr>
			<td>플랫폼</td>
			<td><input type="text" name="flatform" /></td>
			<td colspan="2"><input type="submit" value="새글등록" /></td>
		</tr>
	</table>	
</form>
</div>
	<div id="list">
		<a href="/bustaja/travleList.action">목록보기</a>
   </div>
</div>
</body>
</html>