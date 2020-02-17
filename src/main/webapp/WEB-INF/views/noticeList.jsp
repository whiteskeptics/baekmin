<%@page import="com.project.bustaja.notice.dao.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
 
    
	List<NoticeVO> noticeList = (List<NoticeVO>)request.getAttribute("noticeList");
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
#noticeList{margin-left: 10%;}
table{
		border-collapse: collapse;
		width: 60%;
		margin-left: 15%;
	}
	td, th{
		border: 1px solid black;
		text-align: center;
		padding: 8px;
	}
	h2{text-align: center;}
	#paging{margin-left: 15%; padding: 10px;}
</style>
</head>
<body>
<jsp:include page="/NewFile.jsp" flush="false" />
	<h2>공지사항</h2>
	<div id="noticeList">
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>등록일</th>
			<th>조회수</th>
			<th>비고</th>
		</tr>
		<c:forEach items="${noticeList}" var="noticeVO">
		<tr>
			<td>${noticeVO.seq }</td>
			<td><a href="/bustaja/getNotice.action?seq=${noticeVO.seq }">${noticeVO.title }</a></td>
			<td>${noticeVO.writer }</td>
			<td>${noticeVO.ndate }</td>
			<td>${noticeVO.ncount }</td>
			<td><a href="/bustaja/noticedelete.action?seq=${noticeVO.seq}"><b>[삭제]</b></a></td>
		</tr>
		</c:forEach>
	</table>
	<div id="paging">
	<tr align=center; height=20;>
		<td colspan=7 style=font-family:Tahoma;font-size:10pt;>
			<%if(nowPage<=1){ %>
			[이전]&nbsp;
			<%}else{ %>
			<a href="./noticeList.action?page=<%=nowPage-1 %>">[이전]</a>&nbsp;
			<%} %>
			
			<%for(int a=startPage; a<=endPage; a++){
				if(a==nowPage){%>
				[<%=a %>]
				<%}else{ %>
				<a href="./noticeList.action?page=<%=a %>">[<%=a %>]</a>&nbsp;
				<%} %>
			<%} %>
			
			<%if(nowPage>=maxPage){ %>
			[다음]
			<%}else{ %>
			<a href="./noticeList.action?page=<%=nowPage+1 %>">[다음]</a>
			<%} %>
		</td>
	</tr>
	<tr align="left">
		<td colspan="5">
	   		<a href="/bustaja/noticeInsert.action">추가하기</a>
		</td>
	</tr>
	</div>
	</div>
</body>
</html>