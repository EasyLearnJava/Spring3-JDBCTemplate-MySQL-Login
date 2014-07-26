<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring3 JDBCTemplate MySQL Login Success</title>
</head>
<body>

	<table>
		<tr>
			<td><a href="login"> Log Out ...</a></td>
		</tr>
		<tr>
			<td>Welcome <b><core:out value="${loginForm.userName}" /></b> you have successfully
				logged in to the application ... :)
			</td>
		</tr>
	</table>

</body>
</html>