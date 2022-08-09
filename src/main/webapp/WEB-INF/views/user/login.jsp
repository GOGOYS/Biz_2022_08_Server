<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="${rootPath}/user/login">
	
		<c:choose>
			<c:when test="${error =='LOGIN_NEED' }">
				<c:set var="message" value="* 로그인이 필요한 서비스 입니다"/>
			</c:when>
		</c:choose>
	
		<c:if test="${not empty exception}">
			<div>${exception}</div>
		</c:if>
		<c:if test="${not empty message}">
			<div>${message}</div>
		</c:if>
	
		<label><strong>USER NAME</strong></label>
		<input name="username">
	
		<label><strong>PASSWORD</strong></label>
		<input name="password"  type="password">
		
		<button>로그인</button>
		
	</form:form>
</body>
</html>