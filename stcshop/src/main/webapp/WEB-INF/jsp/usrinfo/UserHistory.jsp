<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 - 개인정보 수정</title>
</head>
<body>
<!-- side bar -->

<div class="row">
  <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px; height: 100vh;">
    <hr>
    <ul class="nav nav-pills flex-column mb-auto">
      <li class="nav-item">
      	<a href="/usrinfo.do" class="nav-link text-white">
          개인정보 조회/수정
        </a>
      </li>
      <li>
        <a href="#" class="nav-link active" aria-current="page">
          통계이력 조회
        </a>
      </li>
    </ul>
    <hr>
  </div>



<!-- 회원정보 -->

	<div class="container mt-4 col-md-9 float-left">
	  <div class="d-flex justify-content-between align-items-center mb-4">
	    <h2>조회 이력</h2>
	    <!-- <button class="btn btn-primary">주간 활동보고서</button> -->
	  </div>
	
	  <div class="table-responsive" style="font-size: 90%; height: 80vh; overflow: auto;">
	    <table class="table table-striped table-hover table-sm">
	      <thead class="thead-dark">
	        <tr>
	          <th scope="col">순번</th>
	          <th scope="col">조회일</th>
	          <th scope="col">분류명</th>
	          <th scope="col">비교분류1</th>
	          <th scope="col">비교분류2</th>
	          <th scope="col">검색어</th>
	          <th scope="col">조회상품</th>
	        </tr>
	      </thead>
	      <tbody>
	        <!-- 조회 이력 데이터 반복 -->
	        
	        <c:forEach var="hst" items="${hstList}" varStatus="status">
			    <tr>
			      <th scope="row">${status.index + 1}</th>  <!-- 순번: 1부터 시작하는 인덱스 -->
			      
			      <td><fmt:formatDate value="${hst.srchDt}" pattern="yyyy년 MM월 dd일" /></td>  <!-- 조회일 -->
			      <td>${hst.gdsClsfOneNm}</td>  <!-- 분류명 -->
			      <td>${hst.gdsClsfTwoNm}</td>  <!-- 비교분류1 -->
			      <td>${hst.gdsClsfThrNm}</td>  <!-- 비교분류2 -->
			      <td>${hst.srchKwrdCn}</td>  <!-- 검색어 -->
			      <td>${hst.inqGdsNm}</td>  <!-- 조회상품 -->
			    </tr>
			  </c:forEach>
	        <!-- ... -->
	      </tbody>
	    </table>
	  </div>
	</div>
</div>

<div class="clearfix"></div>
</body>
</html>