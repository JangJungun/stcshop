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
        <a href="#" class="nav-link active" aria-current="page">
          개인정보 조회/수정
        </a>
      </li>
      <li>
        <a href="/usrhistory.do" class="nav-link text-white">
          통계이력 조회
        </a>
      </li>
    </ul>
    <hr>
  </div>



<!-- 회원정보 -->

	<div class="container mt-4 col-md-9 float-left">
	  <h2>회원 정보</h2>
	  <div class="text-center mb-4">
	    <h3>(회원이름)님</h3>
	    <img src="회원이미지경로" alt="회원 이미지" class="img-thumbnail" style="width: 150px; height: 150px;">
	    <button class="btn btn-link">비밀번호 변경</button>
	  </div>
	
	  <form>
	    <div class="row form-group">
	      <div class="col-md-6">
	        <label for="userId">아이디</label>
	        <input type="text" class="form-control" id="userId" placeholder="아이디" readonly>
	      </div>
	      <div class="col-md-6">
	        <label for="nickname">닉네임</label>
	        <input type="text" class="form-control" id="nickname" placeholder="닉네임">
	      </div>
	    </div>
	    
	    <div class="row form-group">
	      <div class="col-md-6">
	        <label for="email">이메일</label>
	        <input type="email" class="form-control" id="email" placeholder="이메일">
	      </div>
	      <div class="col-md-6">
	        <label for="birthdate">생년월일</label>
	        <input type="date" class="form-control" id="birthdate">
	      </div>
	    </div>
	    
	    <div class="row form-group">
	      <div class="col-md-6">
	        <label for="phone">휴대전화번호</label>
	        <input type="tel" class="form-control" id="phone" placeholder="휴대전화번호">
	      </div>
	      <div class="col-md-6">
	        <label for="joinDate">가입일시</label>
	        <input type="text" class="form-control" id="joinDate" placeholder="가입일시" readonly>
	      </div>
	    </div>
	
	    <button type="submit" class="btn btn-primary">수정</button>
	  </form>
	</div>
</div>

<div class="clearfix"></div>
</body>
</html>