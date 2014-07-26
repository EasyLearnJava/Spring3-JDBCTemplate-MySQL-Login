<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring3 JDBCTemplate MySQL Login</title>

<script type="text/javascript">
	function validateData() {
		var userNameValue = document.getElementById('userName').value.trim();
		if (userNameValue == "") {
			alert('please enter username');
			document.getElementById('userName').focus();
			return false;
		}
		var passwordField = document.getElementById('password').value.trim();
		if (passwordField == "") {
			alert('please enter password');
			document.getElementById('password').focus();
			return false;
		}
	}
</script>

</head>
<body>
	<h2 align="center">Login functionality implemented using Spring 3,
		JDBCTemplate and MySQL</h2>

	<form:form action="login" commandName="loginForm" method="post">
		<table align="center">
			<tr>
				<td colspan="2"><FONT color="red"><form:errors	path="userName" /></FONT></td>
			</tr>
			<tr>
				<td ><form:label path="userName">username :</form:label></td>
				<td ><form:input path="userName" /></td>
			</tr>

			<tr>
				<td colspan="2"><FONT color="red"><form:errors path="password" /></FONT></td>
			</tr>
			<tr>
				<td ><form:label path="password">password :</form:label></td>
				<td ><form:password path="password" /></td>
			</tr>
			<tr>
				<td ><input type="submit" value="Submit" id="loginButton" onclick="return validateData();"/></td>
				<td > </td>
			</tr>
		</table>
	</form:form>

</body>
</html>