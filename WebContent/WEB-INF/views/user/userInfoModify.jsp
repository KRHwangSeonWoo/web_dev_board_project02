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
</head>
<body>

<c:import url="/WEB-INF/views/menu/top_menu.jsp"/>

<form:form action="${contextPath }user/userInfoModify_pro" method="post" modelAttribute="userBean">
				
		이름 : <form:input path="user_name" type="text"  readonly="true"/><br/>
		
		아이디 : <form:input path="user_id" type="text"  readonly="true"/><br/>	
			
		비빌번호 : <form:password path="user_pw" /><br/>
		<form:errors path="user_pw" style="color:red"/><br/>
		
		비밀번호 확인 : <form:password path="user_pw_check" /><br/>
		<form:errors path="user_pw_check" style="color:red"/><br/>
	
	<form:button>정보수정</form:button>
	
</form:form>
</body>
</html>