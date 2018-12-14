<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="show" modelAttribute="user" method="POST">
loanAmount: <form:input path="loanAmount"/><br><br>
rateOfInterest:<form:input path="rateOfInterest"/><br><br>
tenure: <form:input path="tenure"/><br><br>
numberofInstallments:<form:input path="numberofInstallments"/><br><br>

<input type="submit" value="submit"/><br>
</form:form>
</body>
</html>