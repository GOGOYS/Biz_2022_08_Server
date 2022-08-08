<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header >
		<h1>반갑습니다</h1>
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal.username"/>
			<sec:authentication property="principal.email"/>
			<sec:authentication property="principal.realname"/>
		</sec:authorize>	
	</header>
	<nav>
		<ul>
			<sec:authorize access="isAuthenticated()">
				<li><a href="${rootPath}/todo/list">TODO 보기</a></li>
				<li><a href="${rootPath}/user/login">로그인</a></li>
				<li><a href="${rootPath}/user/join">회원가입</a></li>
				<form:form class="logout" action="${rootPath}/logout">
					<button>로그아웃</button>
				</form:form>
			</sec:authorize>

		</ul>
	</nav>
	<section>
			<h1>여기는 홈 화면입니다</h1>			
	</section>

</body>
</html>