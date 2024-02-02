<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 - 개인정보 수정</title>
<script type="text/javascript">
    $(document).ready(function() {
        var message = '${message}';
        if(message) {
            alert(message);
        }
    });
</script>
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
	    <h3>${userInfo.nickNm} 님</h3>
	    <!-- <img src="회원이미지경로" alt="회원 이미지" class="img-thumbnail" style="width: 150px; height: 150px;"> -->
	    <button class="btn btn-link">비밀번호 변경</button>
	  </div>
	
	  <form action="/usrInfoModify.do" method="post">
	    <div class="row form-group">
	      <div class="col-md-6">
	        <label for="userId">아이디</label>
	        <input type="text" class="form-control" id="userId" placeholder="아이디" value="${userInfo.lgnAcntId }" disabled>
	        <input type="hidden" value="${userInfo.usrId}" id="usrId" name="usrId">
	      </div>
	      <div class="col-md-6">
	        <label for="nickname">닉네임</label>
	        <input type="text" class="form-control" id="nickname" name="nickNm" placeholder="닉네임" value="${userInfo.nickNm }">
	      </div>
	    </div>
	    
	    <div class="row form-group">
	      <div class="col-md-6">
	        <label for="email">이메일</label>
	        <input type="email" class="form-control" id="email" name="usrEml" placeholder="이메일" value="${userInfo.usrEml }">
	      </div>
	      <div class="col-md-6">
	        <label for="birthdate">생년월일</label>
	        <%--fn:substring(string, begin, end)을 사용해서 yyyyMMdd형식 String을 년, 월, 일로 출력 --%>
	      	<c:set var="year" value="${fn:substring(userInfo.usrBrdt, 0, 4)}" />
	        <c:set var="month" value="${fn:substring(userInfo.usrBrdt, 4, 6)}" />
	        <c:set var="day" value="${fn:substring(userInfo.usrBrdt, 6, 8)}" />
        	<input type="text" class="form-control" id="birthdate" name="usrBrdt" value="${year}년 ${month}월 ${day}일" disabled>
	       
	      </div>
	    </div>
	    
	    <div class="row form-group">
	      <div class="col-md-6">
	        <label for="phone">휴대전화번호</label>
	        <input type="tel" class="form-control" id="phone" placeholder="휴대전화번호" name="mblTelno" value="${userInfo.mblTelno }">
	      </div>
	      <div class="col-md-6">
	        <label for="joinDate">가입일</label>
	        <%-- fmt:formatDate을 사용해서 Date형식을 yyyy년 MM월 dd일 형식으로 변환 --%>
	        <input type="text" class="form-control" id="joinDate" placeholder="가입일시" name="joinDt" value="<fmt:formatDate value='${userInfo.joinDt}' pattern='yyyy년 MM월 dd일' />" disabled>
	      </div>
	    </div>
	
	    <button type="submit" class="btn btn-primary">수정</button>
	  </form>
	</div>
</div>

<div class="clearfix"></div>

</body>
</html>