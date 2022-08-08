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

<h1>회원가입</h1>
	<form:form>
		<div><input name="username" placeholder="USERNAME"></div>
		<div><input name="password" type="password"></div>
		<div><input name="re_password" type="password"></div>
		<div><input name="email" placeholder="EMAIL"></div>
		<div><input name="phone" placeholder="PHONE"></div>
		<div><input name="address" placeholder="ADDRESS"></div>
		<div><input name="realname" placeholder="REAL NAME"></div>
		<div><input name="nickname" placeholder="NICK NAME"></div>
		<button>회원가입</button>
	</form:form>


</body>
</html>