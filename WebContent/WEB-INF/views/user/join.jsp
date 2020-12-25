<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="<c:url value="/resouces/js/loginJs.js" />"></script>
</head>
<body>


<c:import url="/WEB-INF/views/menu/top_menu.jsp"/>


<form:form action="${contextPath }user/join_pro" method="post" modelAttribute="joinUserBean">

		<form:hidden path="userIdExist"/>
		
		이름 : <form:input path="user_name" type="text"/><br/>
		<form:errors path="user_name" style="color:red"/><br/>
		
		아이디 : <form:input path="user_id" type="text" onkeypress="resetUserIdExist()"/><br/>	
		<button type="button" onclick="checkUserIdExist()">중복확인</button> 
		
		<form:errors path="user_id" style="color:red"/><br/>
	
		비빌번호 : <form:password path="user_pw" /><br/>
		<form:errors path="user_pw" style="color:red"/><br/>
		
		비밀번호 확인 : <form:password path="user_pw_check" /><br/>
		<form:errors path="user_pw_check" style="color:red"/><br/>
		

	<form:button>회원가입</form:button>
	
</form:form>

</body>
</html>