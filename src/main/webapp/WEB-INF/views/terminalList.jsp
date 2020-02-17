<%@page import="com.project.bustaja.terminal.dao.TerminalVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    
    	List<TerminalVO> terminalList = (List<TerminalVO>)request.getAttribute("terminalList");
	    int listCnt = ((Integer)request.getAttribute("listCnt")).intValue();
		int nowPage = ((Integer)request.getAttribute("page")).intValue(); //현재 페이지
		int maxPage = ((Integer)request.getAttribute("maxPage")).intValue(); //최대 페이지 
		int startPage = ((Integer)request.getAttribute("startPage")).intValue(); //현재 페이지를 기준으로 하는  시작페이지
		int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
		border-collapse: collapse;
		width: 70%;
		margin-left: 13%;
	}
	td, th{
		border: 1px solid black;
		text-align: center;
		padding: 8px;
	}
	h2{text-align: center;}
	#paging{margin-left: 13%; padding: 10px;}
</style>
</head>
<body>
<jsp:include page="/NewFile.jsp" flush="false" />
	<h2>터미널정보</h2>
	<div id="terminalList">
	<table>
		<tr>
			<th>터미널코드</th>
			<th>터미널명</th>
			<th>버스타입</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>홈페이지</th>
			<th>비고</th>
		</tr>
		<c:forEach items="${terminalList}" var="terminalVO">
		<tr>
			<td>${terminalVO.termCode }</td>
			<td>${terminalVO.termName }</td>
			<td>${terminalVO.busType }</td>
			<td>${terminalVO.address }</td>
			<td>${terminalVO.phone }</td>
			<td>${terminalVO.homepage }</td>
			<td><a href="/bustaja/terminalDelete.action?termCode=${terminalVO.termCode }">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
	<div id="paging">
	<tr align=center height=20>
		<td colspan=7 style=font-family:Tahoma;font-size:10pt;>
			<%if(nowPage<=1){ %>
			[이전]&nbsp;
			<%}else{ %>
			<a href="./terminalList.action?page=<%=nowPage-1 %>">[이전]</a>&nbsp;
			<%} %>
			
			<%for(int a=startPage; a<=endPage; a++){
				if(a==nowPage){%>
				[<%=a %>]
				<%}else{ %>
				<a href="./terminalList.action?page=<%=a %>">[<%=a %>]</a>&nbsp;
				<%} %>
			<%} %>
			
			<%if(nowPage>=maxPage){ %>
			[다음]
			<%}else{ %>
			<a href="./terminalList.action?page=<%=nowPage+1 %>">[다음]</a>
			<%} %>
		</td>
	</tr>
	<tr align="right">
		<td colspan="5">
	   		<a href="/bustaja/terminalInsert.action">추가하기</a>
		</td>
	</tr>
	</div>
	</div>
</body>
</html>