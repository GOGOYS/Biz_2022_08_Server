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
	<form:form>
		<input name="seq" type="hidden" 
			value='<c:out value="${TODO.seq}" default ="0"/>' >
		<input name="todo" placeholder="할일을 입력하세요" value="${TODO.todo}"/>
		<button>투두 입력</button>
	</form:form>	
</body>
</html>