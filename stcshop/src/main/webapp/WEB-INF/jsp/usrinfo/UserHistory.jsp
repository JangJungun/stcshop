<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	    <button class="btn btn-primary">주간 활동보고서</button>
	  </div>
	
	  <div class="table-responsive">
	    <table class="table table-striped table-hover table-sm">
	      <thead class="thead-dark">
	        <tr>
	          <th scope="col">순번</th>
	          <th scope="col">조회일</th>
	          <th scope="col">분류명</th>
	          <th scope="col">검색어</th>
	          <th scope="col">조회상품</th>
	        </tr>
	      </thead>
	      <tbody>
	        <!-- 조회 이력 데이터 반복 -->
	        <tr>
	          <th scope="row">1</th>
	          <td>2024-01-23</td>
	          <td>패션의류</td>
	          <td>겨울자켓</td>
	          <td>자켓 A</td>
	        </tr>
	        <!-- 추가 데이터 행 -->
	        <!-- ... -->
	      </tbody>
	    </table>
	  </div>
	</div>
</div>

<div class="clearfix"></div>
</body>
</html>