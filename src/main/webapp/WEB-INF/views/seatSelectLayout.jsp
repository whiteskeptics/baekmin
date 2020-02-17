<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
	String startCode = (String)request.getAttribute("startCode");
	String arriveCode = (String)request.getAttribute("arriveCode");
	String startTime = (String)request.getAttribute("startTime");
	long busPrice = (Long)request.getAttribute("busPrice");
	String startDay = (String)request.getAttribute("startDay");
	
	List<Integer> seatSelectList = (List<Integer>)request.getAttribute("seatSelectList");
	int totalSeat = (Integer)request.getAttribute("totalSeat");
	int colCnt = 1; int rowCnt = 1;
	switch(totalSeat){
		case 31 : colCnt = 3; rowCnt = 9; break;
		case 45 : colCnt = 4; rowCnt = 10; break;
		case 21 : colCnt = 3; rowCnt = 6; break;
		default : colCnt = 1; rowCnt = 1;
	}
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

$(document).ready(function(){
	$('.seatList li>label').on('click', function(){
		$(this).parent().toggleClass("blue");
	})
});

</script>
<style>
body{
		background-color:pink;
		background-repeat: no-repeat;
		background-size: 100%;
    }
h1{text-align: center; margin-top: 10%;}
.seatList li{
	list-style: none;
	border : 1px solid black;
	background : green;
	color : blue;
	width : 50px;
	height : 50px;
	line-height: 50px;
	text-align: center;
}
ul.seatList{
	width : 80px;
	height : 80px;
	padding : 15px;
	float : left;
}
.seatList li.red{
	background : red;
	color : white;
}
.seatList li.blue{
	background : blue;
	color : white;
}
#seat{
	margin-left: 26%;
	border: 1px solid black;
	width: 1250px;
	height: 500px;
	padding-left: 50px;
	padding-top: 70px;
}
#pay{
	margin-left: 85%;
	margin-top: 30%;
}
</style>
</head>
<body>
<h1>버스좌석</h1>
<form action="/bustaja/paymentInfo.action"  method="get">
	<div id="seat">
		<%
		for(int i = 0; i < totalSeat ; i++){
			if( (i % colCnt) == 0){
				if(i != totalSeat-1) out.println("<ul class=\"seatList\">");
			}
			
			String attr = ""; //예약 유무에 따른 속성 부여
			for(int j = 0; j < seatSelectList.size(); j++){ // 예약된 좌석 유무를 판단하는 구문
				if( (Integer)seatSelectList.get(j) == i ){
					attr = "red";
					break;
				}
				System.out.println(attr);
			}
			
			out.println("<li  class=\"" + attr + "\">" +"<label for=\"list"+(i+1)+  "\" >" +  (i+1) + "</label>" + "</li>" + "<input type=\"checkbox\" hidden name=\"seatNum\" id=\"list" +(i+1) + "\" value=\""+ (i+1) + "\" />");
	
	
			if( (i % colCnt) == colCnt-1 ){
				if( i != totalSeat-2) out.println("</ul>");
			}
			if(i == totalSeat-1)out.println("</ul>");
		}
		 %>
		 <div id="pay">
	<input type="text" hidden = "hidden" name="startCode" value="<%= startCode %>" />
	<input type="text" hidden = "hidden" name="arriveCode" value="<%= arriveCode %>" />
	<input type="text" hidden = "hidden" name="startTime" value="<%= startTime %>" />
	<input type="text" hidden = "hidden" name="busPrice" value="<%= busPrice %>" />
	<input type="text" hidden = "hidden" name="startDay" value="<%= startDay %>" />
	<input type="submit"  value="다음 " />
	</div>
	</div>
	
</form>
</body>
</html>