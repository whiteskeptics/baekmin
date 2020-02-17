<%@page import="com.project.bustaja.terminal.dao.TerminalDAO"%>
<%@page import="com.project.bustaja.terminal.controller.TerminalController"%>
<%@page import="com.project.bustaja.terminal.dao.TerminalVO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- db에서 정보가져와 테이블에 출력하기 
출발데이터,도착데이터가지고 와야함  -->
<%

	
	List<TerminalVO> list = (List<TerminalVO>)request.getAttribute("list");

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
	*{position:relative;}
	h1{text-align: center; margin-top: 10%;}
	#reservForm{margin-left: 40%;border: 1px solid black; width: 500px; height: 300px; padding: 30px;}
	select{margin: 5px; padding: 5px;}
	#date{margin: 5px; padding: 3px;}
	#time{margin: 5px; padding: 3px;}
	form{margin-left: 31%;}
</style>
</head>
<body>
<h1>버스조회</h1>
<div id="reservForm">
	<h2>[${userName}] 님 환영합니다&nbsp;&nbsp;<a href="/bustaja/logout.action">log-out</a>&nbsp;&nbsp;&nbsp;<a href="/bustaja/ResSearch.action">[예약조회]</a></h2>
	<form action="/bustaja/travelInfo.action" method="get">
		<label for="start" ><b>출발</b>
			<select name="start" id="start" >
				<option value="" selected="selected">출발지선택</option>
				<c:forEach items="${list}" var="terVo">
				<option value="${terVo.termCode}">${terVo.termName} </option>
				</c:forEach>
			</select>
		</label><br />
		<label for="arrive"><b>도착</b>
			<select name="arrive" id="arrive" >
				<option value="" selected="selected">도착지선택</option>
				<c:forEach items="${list}" var="terVo">
					<option value="${terVo.termCode}">${terVo.termName} </option>
				</c:forEach>
			</select>
		</label><br />
		<label for="date"><b>날짜</b>
			<input type="date" id="date" name="date" />
		</label><br />
		<label for="time"><b>시간</b>
			<input type="time" id="time" name="time" />
		</label>
		<input type="submit" value="조회" onclick="user_busInfo()"/>
	</form>
</div>
</body>
</html>