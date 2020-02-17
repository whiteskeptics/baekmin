<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		background-color:pink;
		background-repeat: no-repeat;
		background-size: 100%;
    }
	h1{text-align: center; margin-top: 10%;}
	#search{
		margin-left: 39%;
		border: 1px solid black;
		width: 500px;
		height: 70px;
		padding: 15px;
		padding-left: 70px;
		padding-top: 50px;
	}
</style>
</head>
<body>
<h1>예매조회</h1>
<div id="search">
	<form action="/bustaja/rescheck.action" method="get">
		<table id="reservationForm">
			<tr>
				<th class="tdText">예약번호를 입력하세요</th>
				<td class="tdInput"><input class="inputForm" type="text" name="reservationNo"/><td colspan="2"><input id="resBtn" type="submit" value="예약확인" /></td>
			</tr>
		</table>
	</form>
</div>				
</body>
</html>