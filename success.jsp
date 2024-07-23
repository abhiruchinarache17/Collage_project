<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="2">
<tr>
<th>Rolleno</th>
<th>Name</th>
<th>Username</th>
<th>Password</th>
</tr>
<c:forEach items="${data}" var="s">
<tr>
<td>${s.rollno}</td>
<td>${s.name}</td>
<td>${s.username}</td>
<td>${s.password}</td>
<td><a href="delete?rollno=${s.rollno}">Delete</a>||<a href="edit?rollno=${s.rollno}">EDIT</a>
</tr>
</c:forEach>
</table>
<a href="paging?pageNo=0">1</a>||<a href="paging?pageNo=1">2</a>||<a href="paging?pageNo=2">3</a>||<a href="paging?pageNo=2">4</a>

</body>
</html>