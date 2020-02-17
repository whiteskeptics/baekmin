<%@page import="com.project.bustaja.userview.dao.UserViewVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<UserViewVO> list = (List<UserViewVO>)request.getAttribute("list");
	String startTermName = (String)request.getAttribute("startTermName");
	String arriveTermName = (String)request.getAttribute("arriveTermName");
	System.out.println("=====" + startTermName + "+++++" + arriveTermName);
	String seatSelectList = (String)request.getAttribute("seatSelect");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* 	h1{text-align: center;margin-top: 5%;}
	#ticketInfo{margin-left: 35%; margin-top: 5%;} */
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
		border-width: 1px 0px 0px 0px;
	}
</style>
</head>
<body>
<h1>출발지 : [<%= startTermName %>]  => 도착지 : [<%= arriveTermName %>] 배차 조회 입니다.</h1>
<table>
	<c:forEach items="${list}" var="vo">
	<tr>
		<th colspan="2" style="background-color: yellowgreen;">배차조회</th>
	</tr>
	<tr>
		<th>출발일자</th>
		<td>${startDay}</td>
	</tr>
	<tr>
		<th>출발시간</th>
		<td>${vo.startTime }</td>
	</tr>
	<tr>
		<th>운송회사명</th>
		<td>${vo.companyName}</td>
	</tr>
	<tr>
		<th>좌석종류</th>
		<td>${vo.seatName }</td>
	</tr>
	<tr>
		<th>요금</th>
		<td>${vo.busPrice }</td>
	</tr>
	<tr>
		<th>거리</th>
		<td>${vo.distance }</td>
	</tr>
	<tr>
		<th>소요시간</th>
		<td>${vo.runTime }</td>
	</tr>
	<tr>
		<th colspan="2"><a href="/bustaja/seatSelect.action?totalSeat=${vo.seatCnt}&start=${start}&arrive=${arrive}&startTime=${vo.startTime }&busPrice=${vo.busPrice}&startDay=${startDay}">좌석선택</a></th>
	</tr>
	<tr>
		<td colspan="2" id="blank"></td>
	</tr>
</c:forEach>
</table>
  <% if(seatSelectList != null) { 
	  out.println("여기에서 좌석을 선택할 수 있습니다.");	  
  }%>
</body>
</html>