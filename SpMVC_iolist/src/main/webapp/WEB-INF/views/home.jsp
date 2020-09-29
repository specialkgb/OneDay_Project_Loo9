<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>나의 홈페이지</title>
<script src='https://code.jquery.com/jquery-latest.min.js'></script>
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
		<h3>거누네 샤핑몰</h3>
		<p>거누 패+숀</p>
	</header>
	<%@ include file="/WEB-INF/views/include/i-nav.jspf"%>
	<section>
		<table>
			<thead>
				<tr>
					<th>상품코드</th>
					<th>상품이름</th>
					<th>매입가격</th>
					<th>판매가격</th>
					<th>판매수량</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${PRO_LIST}" var="ProVO">
					<tr class="pro_item" data-pcode="${VO.io_pcode}">
						<td>${VO.io_pcode}</td>
						<td>${VO.io_pname}</td>
						<td>${VO.p_iprice}</td>
						<td>${VO.p_oprice}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<article>
			<a href="${rootPath}/product/insert">상품추가</a>
		</article>
	</section>

</body>
</html>