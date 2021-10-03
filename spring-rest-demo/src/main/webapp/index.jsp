<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rest Demo</title>
</head>
<body>

<h3>Spring Rest Demo</h3>
<hr>
<a href="${pageContext.request.contextPath}/test/hello">Hello</a>

<br><br>
<a href="${pageContext.request.contextPath}/api/students">Get All Students</a>

</body>
</html>