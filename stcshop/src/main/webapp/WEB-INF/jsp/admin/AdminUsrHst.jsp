<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">${usrLgnAcntId}님의 이용내역</h2>
        <a href="/admin.do" class="btn btn-primary">목록으로</a>
		<div class="table-responsive" style="font-size: 90%; height: 80vh; overflow: auto;">
	        <table class="table table-striped">
	            <thead class="thead-dark">
	                <tr>
	                    <th>순번</th>
	                    <th>조회일</th>
	                    <th>분류명</th>
	                    <th>비교분류1</th>
	                    <th>비교분류2</th>
	                    <th>검색어</th>
	                    <th>조회상품</th>
	                </tr>
	            </thead>
	            <tbody>
	                <c:forEach var="usrHst" items="${usrHst}" varStatus="status">
	                    <tr>
	                        <td>${status.index + 1}</td>
	                        <td><fmt:formatDate value="${usrHst.srchDt}" pattern="yyyy-MM-dd" /></td>
	                        <td>${usrHst.gdsClsfOneNm}</td>
	                        <td>${usrHst.gdsClsfTwoNm}</td>
	                        <td>${usrHst.gdsClsfThrNm}</td>
	                        <td>${usrHst.srchKwrdCn}</td>
	                        <td>${usrHst.inqGdsNm}</td>
	                    </tr>
	                </c:forEach>
	            </tbody>
	        </table>
        </div>
        
    </div>
</body>
</html>