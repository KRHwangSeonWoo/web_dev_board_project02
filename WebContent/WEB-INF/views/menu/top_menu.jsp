<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='contextPath' value="${ pageContext.request.contextPath }/"/>

<nav>


<a href="${contextPath}board/main" class="nav-link">메인페이지</a>

<c:forEach var='obj' items='${topMenuInfo }'>
		<a href="${contextPath }board/list?board_idx=${obj.board_idx}" >${obj.board_name }</a>
</c:forEach>



<c:choose>
		<c:when test="${checkLoginBean.userLogin == true }">
						<a href="${contextPath }user/userInfoModify">정보수정</a>
						<a href="${contextPath }user/logout" >로그아웃</a>
		</c:when>
		<c:otherwise>
						<a href="${contextPath }user/join">회원가입</a>
		</c:otherwise>
</c:choose>


</nav>