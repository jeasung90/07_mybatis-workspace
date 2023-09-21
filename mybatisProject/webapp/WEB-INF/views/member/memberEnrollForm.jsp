<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시연딱대좌 팬클럽 회원가입</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="outer">
		<br>
		<h1 align="center">회원가입</h1>
		<br>

		<form action="insert.me" method="post">
	
			<table align="center">
				<tr>
					<td>* ID</td>
					<td><input type="text" name="userId" required></td>
				</tr>
				<tr>
					<td>* PWD</td>
					<td><input type="password" name="userPwd" required></td>
				</tr>
				<tr>
					<td>* NAME</td>
					<td><input type="text" name=userName></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp; EMAIL</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp; BIRTHDAY</td>
					<td><input type="text" name="birthday" placeholder="생년월일(6자리)"></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp; GENDER</td>
					<td align="center">
						<input type="radio" name="gender" id="M" value="M"><label for="M">남좌</label>
						<input type="radio" name="gender" id="F" value="F"><label for="F">여좌</label>
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;PHONE</td>
					<td><input type="text" name="phone" placeholder="-포함"></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;ADDRESS</td>
					<td><input type="text" name="address"></td>
				</tr>
			</table>
			<div align="center">
				<button type="reset">초기화</button>
				<button type="submit">회원가입</button>
			</div>
		</form>

	</div>
	
</body>
</html>
