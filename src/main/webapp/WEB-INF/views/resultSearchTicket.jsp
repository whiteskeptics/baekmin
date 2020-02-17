<%@page import="com.project.bustaja.userview.dao.PaymentInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
	List<PaymentInfoVO> list = (List<PaymentInfoVO>)request.getAttribute("list");
	long totalPayment = 0;
	for(int i = 0; i < list.size(); i++){
		totalPayment += list.get(i).getBusPrice();
	}
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
	h1{text-align: center; margin-top: 5%;}
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
	#blank{
		border: solid #000000;
		border-width: 1px 0px 0px 0px
	}
	a{margin-left: 49%; padding: 10px;}
</style>
</head>
<body>
<h1>승차권 예매 조회 결과</h1>
<table>
		
	<c:forEach items="${list}" var="vo">
		<tr>
			<th colspan="2" style="background-color: skyblue;">예매조회 결과</th>
		</tr>
		<tr>
			<th>발권 고유 번호</th>
			<td>${vo.reservationNo}</td>
		</tr>
		<tr>
			<th>출발지</th>
			<td>${vo.departure}</td>
		</tr>
		<tr>
			<th>목적지</th>
			<td>${vo.destination}</td>
		</tr>
		<tr>
			<th>출발일자</th>
			<td>${vo.startDay}</td>
		</tr>
		<tr>
			<th>출발시간</th>
			<td>${vo.startTime}</td>
		</tr>
		<tr>
			<th>좌석번호</th>
			<td>${vo.seatNum}</td>
		</tr>
		<tr>
			<th>요금</th>
			<td>${vo.busPrice}</td>
		</tr>
		<tr>
			<th>총 결재 금액</th>
			<th><%=totalPayment %></th>
		</tr>
		<tr>
		<td colspan="2" id="blank"></td>
		</tr>
	</c:forEach>
</table>
<a href="/bustaja/getTerminalName.action" title="예매화면으로"><b>[확인]</b></a>
<br />
<br />
</body>
</html>