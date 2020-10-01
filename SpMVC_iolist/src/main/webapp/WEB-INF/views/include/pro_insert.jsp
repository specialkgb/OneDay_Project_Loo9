<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${rootPath}/static/css/insert.css?ver=1">
<script>
	document.addEventListener("DOMContentLoaded", function() {
		let input_btn = document.querySelector("#insert_btn")
		input_btn.addEventListener("click", function() {
			document.querySelector("form").submit();
		})
	})
	
	
</script>
<section id="insert_body">
	<form method="post" action="${rootPath}${URL}">
		<h2>상품명</h2>
		<input id="io_pname" name="io_pname" type="text"
			placeholder="상품명을 입력하세요" value="${ProductVO.io_pname}"> <br />

		<h1>매입/매출 선택</h1>
			<input type='radio' name="radio" id="radio1" value="0"><label for="radio1">매입</label>
			


			<input type='radio' name="radio" id="radio2" value="1"><label for="radio2">매출</label>
			
		<br />

		<h1>가격</h1>
		<input id="io_price" name="io_price" type="number"
			placeholder="얼마에 사시겠어요?" value="${ProductVO.io_price}"> <br />

		<h1>수량</h1>
		<input id="io_quan" name="io_quan" type="number"
			placeholder="수량은 얼마인가요?" value="${ProductVO.io_quan}">
		<hr />

		<c:choose>
			<c:when test="${URL == '/update'}">
				<input type="hidden" name="io_seq" value="${ProductVO.io_seq}">
				<input type="hidden" name="io_date" value="${ProductVO.io_date}">
				<input type="hidden" name="io_time" value="${ProductVO.io_time}">
				<button id="insert_btn" type="button">수정</button>
			</c:when>
			<c:otherwise>
				<button id="insert_btn" type="button">저장</button>
			</c:otherwise>
		</c:choose>
	</form>
</section>