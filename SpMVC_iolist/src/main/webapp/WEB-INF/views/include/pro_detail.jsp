<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<style>
    #detail-body {
        display: inline-block;
        text-align: center;
    }

    #detail-table tr td {
        border: 1px solid black;
    }
</style>

<section id="detail_body">
    <table id="detail_table">
        <tr>
            <td>날짜</td>
            <td>${ProductVO.io_date}</td>
        </tr>
        <tr>
            <td>시각</td>
            <td>${ProductVO.io_time}</td>
        </tr>
        <tr>
            <td>상품명</td>
            <td>${ProductVO.io_pname}</td>
        </tr>
        <tr>
            <td>구분</td>
            <td>${ProductVO.io_input}</td>
        </tr>
        <tr>
            <td>단가</td>
            <td>${ProductVO.io_price}</td>
        </tr>
        <tr>
            <td>수량</td>
            <td>${ProductVO.io_quan}</td>
        </tr>
        <tr>
            <td>합계</td>
            <td>${ProductVO.io_total}</td>
        </tr>
    </table>
    <a href="${rootPath}/update?seq=${ProductVO.io_seq}">수정</a>
    <a href="${rootPath}/delete?seq=${ProductVO.io_seq}">삭제</a>
</section>
