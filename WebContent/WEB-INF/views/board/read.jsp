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

<table border="1">

<tr>
	<td>글쓴이</td>
	<td>${contentBean.writer_id }</td>
</tr>
<tr>
	<td>제목</td>
	<td>${contentBean.title }</td>
</tr>
<tr>
	<td>내용</td>
	<td>${contentBean.content_body }</td>
</tr>

<c:if test="${contentBean.content_file != null }">
	<img src="${path_upload}/${contentBean.content_file }" width="600"/>	
</c:if>

</table>


<c:if test="${contentBean.writer_idx == checkLoginBean.user_idx }">
		<a href="${contextPath }board/modify?content_idx=${contentBean.content_idx}&writer_idx=${contentBean.writer_idx}">정보수정</a>
</c:if>


</body>
</html>