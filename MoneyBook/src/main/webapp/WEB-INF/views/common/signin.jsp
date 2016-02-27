<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>Sign in</title>
    <script type="text/javascript">
    
    </script>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/signout">signout</a></li>
        <li>
        	<form action="/signout" method="post">
				<!-- security의 csrf 옵션활성화 돼있으면 post방식으로만 로그아웃 가능함.  -->
        		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        		<button type="submit">signout</button>
        	</form>
        </li>
    </ul>
</nav>

<h1>Sign in</h1>

<p>You can use: demo@localhost / demo</p>

<form role="form" action="/signin" method="post">
    <div>
        <label for="email">Email address</label>
        <input type="email" name="email" id="email" required autofocus/>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" required/>
    </div>
    <div>
        <label for="remember-me">Remember me</label>
        <input type="checkbox" name="remember-me" id="remember-me"/>
    </div>
	<!-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> -->
    <button type="submit">Sign in</button>
</form>

<c:if test="${error.isPresent() }">
	<p>The email or password you have entered is invalid, try again.</p>
</c:if>
</body>
</html>