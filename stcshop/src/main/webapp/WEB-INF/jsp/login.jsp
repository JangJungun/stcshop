<%--

  쇼핑 트렌드 분석시스템 로그인페이지



  << 개정이력(Modification Information) >>
 
    수정일      수정자           수정내용
   -------    --------    ---------------------------
   2024-01-22   장준근          신규개발
   
   
  author   : SI&컨설팅 사업본부 장준근
  since    : 1.0.0
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="<c:url value="/images/favicon.ico"/>">
<link rel="stylesheet" href="<c:url value="/css/main/login.css"/>">
<link rel="stylesheet" href="<c:url value="/js/jquery-ui-1.13.2/jquery-ui.css"/>">

<script src="<c:url value='/js/jquery-3.7.1.min.js'/>"></script>
<script src="<c:url value='/js/jquery-ui-1.13.2/jquery-ui.min.js'/>"></script>

<script type="text/javascript">

$(document).ready(function(){
  	//jQeury dateicker
    //input을 datepicker로 선언
    $("#usrBrdt").datepicker({
        dateFormat: 'yymmdd' //달력 날짜 형태
        ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
        ,showMonthAfterYear:true // 월- 년 순서가아닌 년도 - 월 순서
        ,changeYear: true //option값 년 선택 가능
        ,changeMonth: true //option값  월 선택 가능                
        ,buttonText: "선택" //버튼 호버 텍스트              
        ,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
        ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
        ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
        ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
        ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
        ,minDate: "-105Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
        ,maxDate: "today" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
    	,yearRange: 'c-50:c' // 현재 년도로부터 30년 전까지 선택 가능
    	,defaultDate: '-20Y' //달력기본날짜
    });                    
    
    //초기값
    //$('#usrBrdt').datepicker('setDate', '-20Y'); 
});

window.onload = function() {
    var expired = '<%= session.getAttribute("expired") %>';  // 세션에서 "expired" 속성을 가져옴
    if (expired == "true") {  // 만료되었다면
        alert("로그인을 해주세요");  // alert 표시
        session.removeAttribute("expired");  // "expired" 속성을 제거
    }
}

</script>
<title>로그인</title>
</head>
<body>
<h2></h2>

<div class="logo-container">

	<img src="<c:url value='/images/trendlogo.png'/>" alt="logo" class="logo" >
</div>

<div class="container" id="container">
  <div class="form-container sign-up-container">
    <form action="/usrinfo/join.do" method="post">
      <h1>회원가입</h1>

      <span></span>
      <input type="text" placeholder="아이디" id="lgnAcntId" name="lgnAcntId" required="required"/>
      <input type="password" placeholder="비밀번호" id="lgnAcntPswd" name="lgnAcntPswd" required="required"/>
      <input type="text" placeholder="닉네임" id="nickNm" name="nickNm" required="required"/>
      <input type="email" placeholder="이메일" id="usrEml" name="usrEml" />
      <input type="text" placeholder="생년월일" id="usrBrdt" name="usrBrdt" required="required" />
      <div>
	    <div style="display: inline-block;">
	        <input type="radio" id="male" name="sxdsCd" value="M" required>
	        <label for="male">남자</label>
	    </div>
	    <div style="display: inline-block;">
	        <input type="radio" id="female" name="sxdsCd" value="F">
	        <label for="female">여자</label>
	    </div>
	  </div>
      <input type="text" placeholder="휴대전화번호" id="mblTelno" name="mblTelno" />
      <input type="hidden"  />
      <input type="hidden"  />
      <button class="sign-up-button" type="submit">가입</button>
    </form>
  </div>
  <div class="form-container sign-in-container">
    <form action="/usrinfo/login.do" method="post">
      <h1>로그인</h1>
      <!-- <div class="social-container">
        <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
      </div> 
      <span>or use your account</span>-->
      <input type="text" placeholder="ID" name="lgnAcntId" />
      <input type="password" placeholder="Password" name="lgnAcntPswd" />
      <!-- <a href="#">비밀번호를 잊어버리셨나요?</a> -->
      <button type="submit" id="tryLogin">로그인</button>
    </form>
  </div>
  <div class="overlay-container">
    <div class="overlay">
      <div class="overlay-panel overlay-left">
        <h1>Welcome</h1>
        <p></p>
        <button class="ghost" id="signIn">로그인</button>
      </div>
      <div class="overlay-panel overlay-right">
        <h1>Hello</h1>
        <p></p>
        <button class="ghost" id="signUp">회원가입</button>
      </div>
    </div>
  </div>
</div>

</body>
<script type="text/javascript">
const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
  container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
  container.classList.remove("right-panel-active");
});

//로그인 오류메시지 alert
var loginErrorMessage = '<c:out value="${loginErrorMessage}"/>'; 

if (loginErrorMessage) {
    alert(loginErrorMessage);
}
//id 중복시 alert
var joinErrorMessage = '<c:out value="${joinErrorMessage}"/>'; 

if (joinErrorMessage) {
    alert(joinErrorMessage);
}



</script>
</html>