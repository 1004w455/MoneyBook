<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<sec:authorize access="isAnonymous()">
	        <li>signin하세요.</li>
    	</sec:authorize>
    	<sec:authorize access="isAuthenticated()">
	        <li>
	        	<sec:authentication property="principal.user.name"/>님 안녕하세요.
	        </li>
    	</sec:authorize>
		<li><a href="/signin">signin</a></li>
		<li><a href="/signout">signout</a></li>
		<li>session id >>> <%= session.getId() %></li>
	</ul>
	Hello world! 하이욧 
	<br>
	<br>
	${members }
</body>
</html>