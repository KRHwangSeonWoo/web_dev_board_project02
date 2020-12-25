<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

  <c:import url="/WEB-INF/views/menu/top_menu.jsp"/>


	<c:choose>
			<c:when test="${checkLoginBean.userLogin == false }">
					
					<form action="${contextPath }user/login_pro"  method="post">
								
								아이디 : <input name="user_id" type="text"/>
								비밀번호 : <input name="user_pw"  type="password"/>
								<button type="submit">로그인</button>
					
					</form>
			</c:when>
    </c:choose>
	
	 
</body>
</html>