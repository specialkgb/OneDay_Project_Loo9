<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<script src="${rootPath}/static/js/pro_list.js?ver=001"></script>
<div id="main_div">
    <h1></h1>
</div>
<div id=main_list>
    <table id="proList">
			<thead>
				<tr>
					<th>NO</th>
					<th>거래일자</th>
					<th>거래시간</th>
					
					<th>상품명</th>
					<th>단가</th>
					<th>수량</th>
					
					<th>매입합계</th>
					<th>총매입계</th>
					
					<th>매출합계</th>					
					<th>총매출계</th>
					
					<th>비고</th>
					
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${PRO_LIST}" var="VO" varStatus="i">
				<tr class="proitems" data-seq="${VO.io_seq}">
					<td>${i.count}</td>
					<td>${VO.io_date}</td>
					<td>${VO.io_time}</td>
					
					<td>${VO.io_pname}</td>
					<td>${VO.io_price}</td>
					<td>${VO.io_quan}</td>
					
					<td>${VO.io_iprice}</td>
					<td>${VO.io_iprice_sum}</td>
					
					<td>${VO.io_oprice}</td>
					<td>${VO.io_oprice_sum}</td>
					<td><a href="${rootPath}/detail?seq=${VO.io_seq}">상세정보</a></td>
					
				</tr>
				</c:forEach>
				<tr>
					<
				</tr>

			</tbody>
		</table>
		<article>
			<a href="${rootPath}/insert">상품추가</a>
		</article>
</div>