<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	body{
		background-color:pink;
		background-repeat: no-repeat;
		background-size: 100%;
	}
	h1{text-align: center; margin-top: 10%;}
	#joinForm{
		border: 1px solid black;
		width: 350px;
		padding-left: 30px;
		padding-top: 15px;
		padding-bottom: 15px;
		margin-left: 43%;
	}
	#btnfield{
		padding-top: 20px;
	}
</style>
</head>
<body>
	
	<h1>회원가입</h1>
	<div id="joinForm">
	<form name="registerform" action="/bustaja/joincheck.action">
		<div class="fieldlabel">
			<label for="cid">아이디</label>
		</div>
		<div class="formfield">
			<input type="text" id="cid" name="cid" maxlength="20" placeholder="아이디입력" required>
		</div>
		<div class="fieldlabel">
			<label for="cpw">패스워드</label>
		</div>
		<div class="formfield">
			<input type="password" id="cpw" name="cpw" maxlength="20" autocomplete="off" placeholder="패스워드입력" required>
		</div>
		
		<div class="fieldlabel">
			<label for="cname">이름</label>
		</div>
		<div class="formfield">
			<input type="text" id="cname" name="cname" maxlength="20" placeholder="이름입력" required>
		</div>
		<div class="fieldlabel">
			<label for="cphone">연락처</label>
		</div>
		<div class="formfield">
			<input type="text" id="cphone" name="cphone" maxlength="20" placeholder="핸드폰번호입력" required>
		</div>
		<div class="btnfield">
			<input type="submit" value="회원가입">
		</div>
	</form>
	</div>
</body>

</html>