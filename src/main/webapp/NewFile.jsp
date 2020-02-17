<%@ page language="java" contentType="text/html; charset=UTF-8"
	trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
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
header {
	border: 1px solid black;
	padding: 10px;
}

#adminHead {
	margin-left: 75%;
}
</style>
</head>
<body>
	<header>
		<div>
			<h1>관리자 화면  [${userName}] 님  <a href="/bustaja/logout.action">log-out</a></h1>
		</div>
		<div id="adminHead">
			<a href="/bustaja/companyList.action"><b>[회사관리]</b></a> 
			<a href="/bustaja/terminalList.action"><b>[터미널관리]</b></a> 
			<a href="/bustaja/noticeList.action"><b>[공지사항]</b></a> 
			<a href="/bustaja/travleList.action"><b>[운행노선]</b></a> 
			<a href="/bustaja/timeList.action"><b>[시간표 관리]</b></a>
		</div>
	</header>
</body>
</html>