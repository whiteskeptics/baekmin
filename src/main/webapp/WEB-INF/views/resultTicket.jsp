<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String userId = (String)session.getAttribute("userName");
	if(userId == null) userId="guest";
%>    

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
	table{
		border-collapse: collapse;
		width: 600px;
		margin-left: 38%;
	}
	td, th{
		border: 1px solid black;
		text-align: center;
		padding: 8px;
	}
</style>
</head>
<body>
<h1>예매완료</h1>
	<table>
		<tr>
			<th colspan="2"><%=userId %>님의 예매 내역입니다.</th>
		</tr>
		<tr>
			<th>발권번호</th>
			<td><a href="/bustaja/ticketSearch.action?reservationNo=${ insertResult.reservationNo }" title="예매티켓조회"> ${ insertResult.reservationNo } </a></td>
		</tr>
		<tr>
			<td colspan="2">발권번호 또는 본인 계정을 이용하여 예매 내역을 확인할 수 있습니다. <br /> 매표소에서 발권번호를 제시하세요.</td>
		</tr>
	</table>
</body>
</html>