<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.box{
		margin: 10px 20px;
	}
	a{
		text-decoration: none;
		color: black;
		padding:8px 20px;
		background-color: blue;
		border-radius: 8px;
	}
</style>
</head>
<body>	
	<h1>투두 리스트</h1>
	
	<table class="box">
		<thead>
			<tr>	
				<th>순서</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>작성시간</th>
				<th>완료일</th>
				<th>완료시각</th>
				<th>완료여부</th>
				<th>버튼</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${TODOLIST}" var="TODO">
					<tr data-seq ="${TODO.seq}">
						<td>${TODO.seq}</td>
						<td>${TODO.todo}</td>
						<td>${TODO.d_date}</td>
						<td>${TODO.d_time}</td>
						<td>${TODO.f_date}</td>
						<td>${TODO.f_time}</td>
						<c:if test="${TODO.finish == false}">
							<td>작성중</td>
							<td><a href="${rootPath}/todo/${TODO.seq}/finish">완료하기</a></td>
						</c:if>
						<c:if test="${TODO.finish == true}">
							<td>작성완료</td>
						</c:if>
						
					</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="${rootPath}/todo/input">입력하기</a>
	<a href="${rootPath}/">홈가기</a>
</body>

<script >
	  const rootPath = "${rootPath}";
</script>

<script src="${rootPath}/static/js/todo.js?ver=2022-08-08-011"></script>
</html>