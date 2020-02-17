<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
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
#main {
	border:1px solid black;
	width:300px;
	margin-top: 18%;
	margin-left: 45%;
	padding-left: 20px;
	padding-top: 10px;
	padding-bottom: 20px;
}
</style>
</head>
<body>
	<div id="main">
		<h1>버스예매</h1>
		<form action="/bustaja/logincheck.action" method="get">
			<table id="loginForm">
				<tr>
					<td class="tdText">아이디</td>
					<td class="tdInput"><input class="inputForm" type="text"
						name="cid" required="required"/></td>
				</tr>
				<tr>
					<td class="tdText">비밀번호</td>
					<td class="tdInput"><input class="inputForm" type="password"
						name="cpw" required="required"/></td>
				</tr>
				<tr>
					<td colspan="2"><input id="loginBtn" type="submit"
						value="Login" /></td>
				</tr>
			</table>
		</form>

		<table id="btnTable">
			<form action="/bustaja/joinview.action" method="get">
				<table id="joinnForm">			
					<tr>
						<td colspan="2"><input id="joinBtn" type="submit"
							value="회원가입" /></td>
					</tr>
				</table>
		</form>
		</table>

	</div>
</body>
</html>