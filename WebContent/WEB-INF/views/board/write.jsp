<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='contextPath' value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<c:import url="/WEB-INF/views/menu/top_menu.jsp"/>


<form:form action='${contextPath }board/write_pro' method='post' modelAttribute="contentBean" enctype="multipart/form-data">
							
						    <form:hidden path="board_idx"/>
							제목 : <form:input path="title" /><br>
							<form:errors path='title' style='color:red' /><br>
							내용 : <form:textarea path="content_body" rows="10" style="resize:none"/><br>
							<form:errors path='content_body' style='color:red'/><br>
							첨부이미지 : <form:input type='file' path='upload_file' accept="image/*"/><br>
								<form:button>작성하기</form:button>				
					</form:form>

</body>
</html>