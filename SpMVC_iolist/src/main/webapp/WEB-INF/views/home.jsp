<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>매입매출리스트 프로젝트</title>
<script src='https://code.jquery.com/jquery-latest.min.js'></script>
<script>
	var rootPath="${rootPath}"
</script>
<script src="https://kit.fontawesome.com/3c990466ed.js"
	crossorigin="anonymous"></script>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

header {
	background-color: gold;
	color: white;
	text-align: center;
	padding: 1.5rem;
}

table {
	border-collapse: collapse;
	border: 1px solid #ccc;
	width: 80%;
	margin: 10px auto;
}

th, td {
	border: 1px solid #ccc;
	padding: 8px;
	text-align: left;
}
/*
	child 속성에 연산식을 사용하는 방법
	An + b 형식의 연산식을 사용할 수 있다
	n : 1 ~ child 개수만큼 +1씩 증가하는 값
	
	th와 td 값에 4번째 위치부터 이후에 동일한 특성(style)을 지정하라
*/
th:nth-child(n+4),
td:nth-child(n+4) {
	text-align: right;
}

tbody tr:nth-child(odd) {
	background-color: #f1f0f0;
}

tbody tr:nth-child(even) {
	background-color: #fff;
}

tbody tr:hover {
	background-color: #ddd;
}

article {
	width: 80%;
	margin: 5px auto;
	text-align: right;
}

article a {
	display: inline-block;
	padding: 8px 16px;
	background-color: blue;
	color: white;
	cursor: pointer;
	text-decoration: none;
	border-radius: 5px;
}

article a:hover {
	color: black;
	background-color: #ddd;
	-webkit-box-shadow: 9px 6px 13px 5px rgba(0, 0, 0, 0.75);
	-moz-box-shadow: 9px 6px 13px 5px rgba(0, 0, 0, 0.75);
	box-shadow: 9px 6px 13px 5px rgba(0, 0, 0, 0.75);
}
</style>
</head>
<body>
	<header>
		<h3>하나도 모르겠어 진짜</h3>
	</header>
		<%@ include file="/WEB-INF/views/include/pro_nav.jsp"%>
		
		<section>
		<c:choose>
			<c:when test="${BODY == 'PRO_HOME'}">
				<%@ include file="/WEB-INF/views/include/pro_list.jsp" %>
			</c:when>
			<c:when test="${BODY == 'PRO_INSERT'}">
				<%@ include file="/WEB-INF/views/include/pro_insert.jsp" %>
			</c:when>
			<c:when test="${BODY == 'PRO_DETAIL'}">
				<%@ include file="/WEB-INF/views/include/pro_detail.jsp" %>
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/views/include/pro_list.jsp" %>
			</c:otherwise>
		</c:choose>
		</section>

</body>
</html>