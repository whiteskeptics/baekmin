<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 등록</title>
<style>
	h2{text-align: center; margin-top: 5%;}
	#insertDiv{border:1px solid black;width: 360px; padding-left:70px; padding-top:10px; padding-bottom:10px; margin-left: 42%;}
	#listLink{margin-left: 63%; padding: 10px;}
</style>
</head>
<body>
<jsp:include page="/NewFile.jsp" flush="false" />
<h2>회사추가하기</h2>
<div id="insertDiv">
<form action="/bustaja/insertCompanyaa.action" method="get">
	<table>
		<tr>
			<td>회사코드</td>
			<td><input type="text" name="companyCode" /></td>
		</tr>
		
		<tr>
			<td>회사명</td>
			<td><input type="text" name="companyName" /></td><td colspan="2"><input type="submit" value="회사추가" /></td>
		</tr>
		
		<tr>
			
			
		</tr>
	</table>
	<div id="listLink">
   <a href="/bustaja/companyList.action"><b>[회사목록]</b></a>
	</div>	
</form>
</div>

</body>
</html>