<%@page import="com.project.bustaja.userview.dao.UserViewVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
		//필요한 자료 => 출발지, 도착지, 출발일자 및 시간, 좌석번호, 결재요금 
		//필요한 자료가 어디어서 가져올 것인가 => DB에서, 리쿼스트 영역(포워딩상태여야 자료를 가져올 수 있다)에서, 외부에서 파라미터(호풀하는 곳에서 get방식(a태그나 폼을 통해서)이나 post방식(폼테그를 통해서)로 가져올 것인가, 세션 영역에서 가져올 것인가(포워딩, 리다이렉트를 하든 세션의 정보를 가져올 수가 있다.)....
	//출발지 => 출발지 코드를 통해서 DB접근해서 결과를 가져온다.
	//도착지 => 도착지 코드를 통해서  DB접근해서 결과를 가져온다.

		List<UserViewVO> list = (List<UserViewVO>)request.getAttribute("list");
		String startTermName = (String)request.getAttribute("startTermName"); //출발지명
		String arriveTermName = (String)request.getAttribute("arriveTermName"); //도착지명
		String[] seatNum = (String[])request.getAttribute("seatNum");//좌석번호
		String startDay = (String)request.getAttribute("startDay"); //출발일 => 임시로 만들 둠
		String startTime = (String)request.getAttribute("startTime"); //출발시간
		long busPrice = (Long)request.getAttribute("busPrice"); //버스요금
		long totalFee =  busPrice * seatNum.length;
		int seatCnt = 0;
		System.out.println("출발지" + startTermName + "\n도착지" + arriveTermName );
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
		width: 500px;
		margin-left: 40%;
	}
	td, th{
		border: 1px solid black;
		text-align: center;
		padding: 8px;
	}
</style>
</head>
<body>
	<h1> 결제화면 </h1>
	<form id ="progress" action="/bustaja/paymentInsert.action" method="get">
	<table>
		<tr>
			<th colspan="2" style="background-color: hotpink;">예약정보</th>
		</tr>
		<tr>
			<th>출발지</th>
			<th><input class="inputClass" type='text' name="startTermName" readonly value="<%=startTermName %>"></th>
		</tr>
		<tr>
			<th>도착지</th>
			<th><input class="inputClass" type='text' name="arriveTermName" readonly value="<%=arriveTermName %>"></th>
		</tr>
		<tr>
			<th>출발날짜</th>
			<th><input class="inputClass" type='text' name="startDay" readonly value="<%=startDay %>"></th>
		</tr>
		<tr>
			<th>출발시간</th>
			<th><input class="inputClass" type='text' name="startTime" readonly value="<%=startTime %>"></th>
		</tr>
		<tr>
			<th>좌석번호</th>
			<td>
				<c:forEach items="${seatNum }" var="num">
					<label>${num}</label>&nbsp;&nbsp;&nbsp;
				</c:forEach> 
								<%-- 	좌석번호 자료가  전달될 수 있도록 한다. --%>
				<%
					for(int i = 0; i < seatNum.length; i++){
					out.println("<input type=\"checkbox\" hidden checked name=\"seatNum\" value=\""+seatNum[i] + "\" >" );
				}
				%>	
			</td>
		</tr>
		<tr>
			<th>결제금액</th>
			<th>
				<input id="_payprice_" class="inputClass" type='text' readonly value="<%=totalFee %>">
				<input type='text' name="busPrice"  value="<%=busPrice %>" hidden="hidden" />
			</th>
		</tr>
		<tr>
			<th>티켓팅</th>
			<th>
				<select name="_ticketing_" form="progress" class="right">
					<option value='현장발권'>현장 발권</option>
					<option value='e-티켓'>e - 티켓</option>
				</select>
			</th>
			<tr>
				<td colspan="2"><input class = "btn" id="paymentBtn" type="submit" onclick = "check()" value="결제"/></td>
			</tr>
	</table>
</form>
</body>
</html>