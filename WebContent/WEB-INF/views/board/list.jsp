<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='contextPath' value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<c:import url="/WEB-INF/views/menu/top_menu.jsp"/>


<table border="1">
		<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성날짜</th>
					</tr>
		</thead>
		<tbody>
					<c:forEach var='obj' items="${list_info }">
					<tr>
						<td>${obj.content_idx }</td>
						<td><a href='${contextPath }board/read?content_idx=${obj.content_idx}'>${obj.title }</a></td>
						<td>${obj.writer_id }</td>
						<td>${obj.content_date }</td>
					</tr>
					</c:forEach>
					
					
		<c:choose>
		<c:when test="${checkLoginBean.userLogin == true }">
					<tr>
						<td><a href='${contextPath }board/write?board_idx=${board_idx}'>글 쓰기</a></td>		
					</tr>
		</c:when>
</c:choose>
					
			
		</tbody>
</table>
</body>
</html>