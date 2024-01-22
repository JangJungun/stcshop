<%--

  쇼핑 트렌드 분석시스템 로그인페이지



  << 개정이력(Modification Information) >>
 
    수정일      수정자           수정내용
   -------    --------    ---------------------------

   
   
  author   : SI&컨설팅 사업본부 장준근
  since    : 1.0.0
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	       });                    
	       
	       //초기값을 오늘 날짜로 설정해줘야 합니다.
	       $('#usrBrdt').datepicker('setDate', '-20Y'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)            
	   });

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
    <form action="#">
      <h1>회원가입</h1>

      <span></span>
      <input type="text" placeholder="아이디" id="lgnAcntId" />
      <input type="password" placeholder="비밀번호" id="lgnAcntPswd" />
      <input type="text" placeholder="닉네임" id="nickNm" />
      <input type="email" placeholder="이메일" id="usrEml" />
      <input type="text" placeholder="생년월일" id="usrBrdt" />
      <input type="sample" placeholder="성별" id="sxdsCd" />
      <input type="text" placeholder="휴대전화번호" id="mblTelno" />
      <input type="hidden"  />
      <input type="hidden"  />
      <button class="sign-up-button">가입</button>
    </form>
  </div>
  <div class="form-container sign-in-container">
    <form action="#">
      <h1>로그인</h1>
      <div class="social-container">
        <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
      </div>
      <span>or use your account</span>
      <input type="text" placeholder="ID" />
      <input type="password" placeholder="Password" />
      <a href="#">비밀번호를 잊어버리셨나요?</a>
      <button>로그인</button>
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


</script>
</html>