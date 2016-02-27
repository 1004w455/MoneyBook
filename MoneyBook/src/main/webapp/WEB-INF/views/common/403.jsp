<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>403</title>
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
		<li><a href="/">home</a></li>
		<li><a href="/signout">signout</a></li>
	</ul>
	접근 권한이 없습니다.
</body>
</html>