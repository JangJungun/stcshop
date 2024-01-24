


<!DOCTYPE html>
<html lang="ko">
<head>
	<title>STC Trend</title>
	
	<style>
		.wrap {width: 100%;}
		.wrap .header {width: 0%;vertical-align: top;height: 0;}
		.wrap .middle {width: 100%;vertical-align: top;display: table;height: calc(95vh - 100px);}
		.wrap .middle .contents {display: table-row;}
/* 		.wrap .middle .contents .left {display: table-cell;width: 7%;vertical-align: top;} */
/* 		 .wrap .middle .contents .body {display: inline-block;width: 95%; text-align: center; padding-top: 2%;}  */


		.wrap .footer {width: 100%;vertical-align: top;height: 50px;}
	</style>
</head>
<body>
		<div class="header">
			


<!-- 부트스트랩 5.3.2 / jQuery 3.7.1 -->
<link rel="stylesheet" href="/js/jquery-ui-1.13.2/jquery-ui.css">
<link rel="stylesheet" href="/css/bootstrap/bootstrap.min.css">

<script src="/js/jquery-3.7.1.min.js"></script>
<script src="/js/bootstrap/bootstrap.min.js"></script>

<!-- header -->
<nav class="navbar navbar-expand-lg navbar-light bg-light" aria-label="Third navbar example">
    <div class="container-fluid">
	  <img src="/images/logo_image.png" alt="logo" class="logo" width="10%">
      <a class="navbar-brand" href="#"></a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample03" aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExample03">
        <ul class="navbar-nav me-auto mb-2 mb-sm-0">
          <li class="nav-item" style="margin-right: 40px;">
            <a class="nav-link " aria-current="page" href="/main/info.do">이용안내</a>
          </li>
          <li class="nav-item" style="margin-right: 40px;">
            <a class="nav-link link-primary" href="/main/inquirytrend.do">통계조회</a>
          </li>
          <li class="nav-item" style="margin-right: 40px;">
            <a class="nav-link " href="/usrinfo.do">마이페이지</a>
          </li>
          <li class="nav-item" style="margin-right: 40px;">
            <a class="nav-link " href="/admin.do">관리자페이지</a>
          </li>
        </ul>
      </div>
      
    </div>
    <div class="d-flex align-items-center">
	  <p class="fw-bolder mb-0 text-nowrap">관리자님 어서오세요.   &nbsp;&nbsp;</p>
	</div>

    <img src="/images/defaultprofile.png" alt="profile" class="profile" width="5%">
  </nav>
		</div>
	<div class="wrap">
		<div class="middle">
			<div class="contents">
				<div class="left">
					

				</div>
				<div class="body">
					

<!DOCTYPE html>
<html>
<head>
<!-- chart.js -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.1/dist/chart.min.js"></script>
    <title>분야별 검색</title>

</head>
<body>

<div class="container mt-5">
    <h2>통계 조회</h2>
    <hr />
   	
		<form method="post" action="/main/inquiry.do" id="inquiryForm">
			<div class="row g-3">
			<strong class="title">분류</strong>
            <div class="form-group col-sm-3">
			  <select class="form-control form-select" id="category1" required>
			    <option value="" selected disabled hidden>1분류</option>
			    <option value="패션의류" data-param="50000000">패션의류</option>
			    <option value="패션잡화" data-param="50000001">패션잡화</option>
			    <option value="화장품/미용" data-param="50000002">화장품/미용</option>
			    <option value="디지털/가전" data-param="50000003">디지털/가전</option>
			    <option value="가구/인테리어" data-param="50000004">가구/인테리어</option>
			    <option value="출산/육아" data-param="50000005">출산/육아</option>
			    <option value="식품" data-param="50000006">식품</option>
			    <option value="스포츠/레저" data-param="50000007">스포츠/레저</option>
			    <option value="생활/건강" data-param="50000008">생활/건강</option>
			    <option value="여가/생활편의" data-param="50000009">여가/생활편의</option>
			    <option value="면세점" data-param="50000010">면세점</option>
			    
			  </select>
			  
			
			</div>
			<div class="form-group col-sm-3">
			  
			  <select class="form-control form-select" id="category2" style="display: none;">
			    <option value="" selected disabled hidden>2분류</option>
			    <option value="sample2">sample2</option>
			    <option value="sample3">sample3</option>
			    <!-- 기타 옵션 -->
			  </select>
			</div>
			<div class="form-group col-sm-3">
			  
			  <select class="form-control form-select" id="category3" style="display: none;">
			    <option value="" selected disabled hidden>3분류</option>
			    <option value="sample3">sample3</option>
			    <option value="sample4">sample4</option>
			    <!-- 기타 옵션 -->
			  </select>
			</div>
			<div class="form-group col-sm-3">
			  
			  <select class="form-control form-select" id="category4" style="display: none;">
			    <option value="" selected disabled hidden>4분류</option>
			    <option value="sample4">sample4</option>
			    <option value="sample5">sample5</option>
			    <!-- 기타 옵션 -->
			  </select>
			</div>
			
			
			<input type="hidden" id="categoryName" name="categoryName">
			<input type="hidden" id="categoryParam" name="categoryParam">


        <!-- <label for="state" class="form-label">기간</label> -->
        <strong class="title me-2">기간</strong>
		<div class="row">
			<div class="col-md-2">
              <select class="form-select" id="timeUnit" name="timeUnit" required>
                <option value="date" selected>일간</option>
                <option value="week" selected>주간</option>
                <option value="month" selected>월간</option>
              </select>
              
              <div class="invalid-feedback">
                valid
              </div>
            </div>
            
			<div class="col-md-5" id="">
			  <!-- 1개월 라디오 버튼 -->
			  <input type="radio" class="btn-check" name="itemPeriod" id="setPeriod0" autocomplete="off">
			  <label class="btn btn-outline-primary" for="setPeriod0">1개월</label>
			
			  <!-- 3개월 라디오 버튼 -->
			  <input type="radio" class="btn-check" name="itemPeriod" id="setPeriod1" autocomplete="off">
			  <label class="btn btn-outline-primary" for="setPeriod1">3개월</label>
			
			  <!-- 1년 라디오 버튼 -->
			  <input type="radio" class="btn-check" name="itemPeriod" id="setPeriod2" autocomplete="off">
			  <label class="btn btn-outline-primary" for="setPeriod2">1년</label>
			
			  <!-- 직접입력 라디오 버튼 -->
			  <input type="radio" class="btn-check" name="itemPeriod" id="setPeriod3" autocomplete="off">
			  <label class="btn btn-outline-primary" for="setPeriod3">직접입력</label>
			</div>
			<!-- '직접선택'이 활성화 될 때 보여질 입력 필드들 -->
			<div class="col-md-8" id="customPeriodInputs" style="padding-top: 10px; display: none;">
			  <div class="row">
			    <div class="col">
			      <div class="input-group input-group-sm">

			        <input type="date" class="form-control" id="startDate" name="startDate">
			      </div>
			    </div>
			    ~
			    <div class="col">
			      <div class="input-group input-group-sm">

			        <input type="date" class="form-control" id="endDate" name="endDate">
			      </div>
			    </div>
			  </div>
			</div>
		</div>



<div class="form_row form_float d-flex align-items-center">
  <strong class="title me-2">기기별</strong>
  
  <div class="set_col set_target_chk d-flex">
    <!-- 전체 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="device_0">
      <label class="form-check-label" for="device_0">전체</label>
    </div>
    <!-- PC 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="device_1" value="pc">
      <label class="form-check-label" for="device_1">PC</label>
    </div>
    <!-- 모바일 체크박스 -->
    <div class="form-check">
      <input type="checkbox" class="form-check-input" id="device_2" value="mo">
      <label class="form-check-label" for="device_2">모바일</label>
    </div>
  </div>
  <input type="hidden" name="device" id="device">
  
  
  <strong class="title px-2 ms-4">성별</strong>
  <div class="set_col set_target_chk d-flex">
    <!-- 전체 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="gender_0">
      <label class="form-check-label" for="gender_0">전체</label>
    </div>
    <!-- 남 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="gender_1" value="m">
      <label class="form-check-label" for="gender_1">남</label>
    </div>
    <!-- 여 체크박스 -->
    <div class="form-check">
      <input type="checkbox" class="form-check-input" id="gender_2" value="f">
      <label class="form-check-label" for="gender_2">여</label>
    </div>
  </div>
  <input type="hidden" name="gender" id="gender">
</div>
  
<div class="form_row form_float d-flex align-items-center">
  <strong class="title me-2">연령</strong>
  <div class="set_col set_target_chk d-flex">
    <!-- 전체 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input-age" id="age_0">
      <label class="form-check-label" for="age_0">전체</label>
    </div>
    <!-- 10대 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input-age" id="age_1" value="10">
      <label class="form-check-label" for="age_1">10대</label>
    </div>
    <!-- 20대 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input-age" id="age_2" value="20">
      <label class="form-check-label" for="age_2">20대</label>
    </div>
    <!-- 30대 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input-age" id="age_3" value="30">
      <label class="form-check-label" for="age_3">30대</label>
    </div>
    <!-- 40대 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input-age" id="age_4" value="40">
      <label class="form-check-label" for="age_4">40대</label>
    </div>
    <!-- 50대 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input-age" id="age_5" value="50">
      <label class="form-check-label" for="age_5">50대</label>
    </div>
    <!-- 60대 체크박스 -->
    <div class="form-check">
      <input type="checkbox" class="form-check-input-age" id="age_6" value="60">
      <label class="form-check-label" for="age_6">60대 이상</label>
    </div>
  </div>
  <input type="hidden" name="ages" id="ages">
  </div>
  </div>



            
	<hr class="my-4">

	<button class="w-50 btn btn-primary btn-lg" type="submit">조회</button>
	</form>
</div>
<hr>

				
<!-- footer -->

</body>

<script type="text/javascript">

$(document).ready(function(){
	 $('.form-select').change(function() {
	        // 현재 select의 다음 모든 field-group을 찾아서 숨기고, select를 default value로 설정
	        var allNextGroups = $(this).closest('.form-group').nextAll('.form-group');
	        allNextGroups.find('.form-select').val('').hide();

	        // 현재 select의 다음 field-group을 찾음
	        var nextField = $(this).closest('.form-group').next('.form-group').find('.form-select');

	        // 만약 현재 select의 값이 ""가 아니라면 다음 field-group을 표시함
	        if ($(this).val() !== "") {
	            nextField.show();
	        }
	        
	    });
	 

	 
	 //category1~4 중 마지막에 선택값을 categoryName으로 설정
	 //각 category에 저장된 param값을 categoryParam으로 설정
	 var lastSelectedCategoryValue = '';
	  $('.form-control.form-select').change(function() {
		    var selectedValue = $(this).val();
		    if(selectedValue) {
		      lastSelectedCategoryValue = selectedValue;
		    }
		    
			// 현재 선택된 옵션의 data-param 값을 dataParam에 저장
		    var dataParam = $(this).find('option:selected').data('param');
		 	// 선택된 옵션이 유효값이면 hidden input에 data-param 값을 할당.
		    if(dataParam) {
		      $('#categoryParam').val(dataParam);
		    }
			
		    console.log(lastSelectedCategoryValue);
		    console.log(dataParam);
		    
		  });
	 //submit시 input hidden으로 설정된 categoryName에 마지막 선택값을 넣고 전송
	  $('#inquiryForm').submit(function(e) {
		    // 마지막으로 선택된 카테고리 값을 확인하고 설정합니다.
		    if(lastSelectedCategoryValue) {
		      $('#categoryName').val(lastSelectedCategoryValue);
		    } else {
		      // 예외처리
		      e.preventDefault();
		      alert('카테고리를 선택해주세요.');
		    }
		    
		 	// hidden input에 저장된 data-param 값이 있는지 확인
		    var categoryParam = $('#categoryParam').val();
		    if (!categoryParam) {
		        // 예외처리
		        event.preventDefault();
		        alert('카테고리를 선택해주세요.');
		      }
		    
		    
		  
	  });
	 
	 
	// 라디오 버튼 변경 시 호출될 함수를 정의합니다.
	  function handleRadioChange() {
	    var $customPeriodInputs = $('#customPeriodInputs');
	    var $startDate = $('#startDate');
	    var $endDate = $('#endDate');
	    var today = new Date();
	    
	    // '직접입력' 라디오 버튼이 체크되었는지 확인합니다.
	    if($('#setPeriod3').is(':checked')) {
	      $customPeriodInputs.show();
	      $startDate.val(formatDate(today));
	      $endDate.val(formatDate(today));
	    } else {
	      $customPeriodInputs.hide();
	      // 현재 체크된 라디오 버튼의 id를 기반으로 날짜 계산
	      var checkedRadioButtonId = $('input[name="itemPeriod"]:checked').attr('id');
	      var start = new Date(today);

	      switch(checkedRadioButtonId) {
	        case 'setPeriod0':
	          start.setMonth(today.getMonth() - 1);
	          break;
	        case 'setPeriod1':
	          start.setMonth(today.getMonth() - 3);
	          break;
	        case 'setPeriod2':
	          start.setFullYear(today.getFullYear() - 1);
	          break;
	        
	          
	      }

	      

	      // 날짜를 입력 필드에 설정
	      $startDate.val(formatDate(start));
	      $endDate.val(formatDate(today));
	    }
	    console.log(formatDate(start));
	    console.log(formatDate(today));
	    
	  }

	  // 라디오 버튼에 이벤트 리스너를 추가합니다.
	  $('input[type=radio][name=itemPeriod]').change(handleRadioChange);
	 
});

//날짜를 YYYY-MM-DD 형식으로 변환
var formatDate = function(date) {
  var d = date,
      month = '' + (d.getMonth() + 1),
      day = '' + d.getDate(),
      year = d.getFullYear();

  if (month.length < 2) month = '0' + month;
  if (day.length < 2) day = '0' + day;

  return [year, month, day].join('-');
};


// 기기별 '전체' 체크박스 상태 변경
$('#device_0').change(function() {
  var isChecked = $(this).is(':checked');
  // PC와 모바일 체크박스 상태를 변경
  $('#device_1').prop('checked', isChecked);
  $('#device_2').prop('checked', isChecked);
  updateDeviceHiddenInput();
  
});

// PC 또는 모바일 체크박스 상태 변경 시 hidden input의 값을 조정
$('#device_1, #device_2').change(function() {
  $('#device_0').prop('checked', false);
  updateDeviceHiddenInput();
});

// 디바이스 input값 변경
function updateDeviceHiddenInput() {
  var pcChecked = $('#device_1').is(':checked');
  var mobileChecked = $('#device_2').is(':checked');
  // '전체'가 선택되었을 경우 hidden input의 값을 비움
  if (pcChecked && mobileChecked) {
    $('#device').val('');
  } else if (pcChecked) { // PC만 선택된 경우
    $('#device').val('pc');
  } else if (mobileChecked) { // 모바일만 선택된 경우
    $('#device').val('mo');
  } else { // 어떤 것도 선택되지 않은 경우
    $('#device').val('');
  }

//  console.log($('#device').val());
}


// 성별'전체' 체크박스 상태 변경
$('#gender_0').change(function() {
  var isChecked = $(this).is(':checked');
  // 남과 여 체크박스 상태를 변경
  $('#gender_1').prop('checked', isChecked);
  $('#gender_2').prop('checked', isChecked);
  updateGenderHiddenInput();
});

// 남 또는 여 체크박스 상태 변경 시 hidden input의 값을 조정
$('#gender_1, #gender_2').change(function() {
  // '전체' 체크 해제
  $('#gender_0').prop('checked', false);
  updateGenderHiddenInput();
});

// 성별 input값 변경
function updateGenderHiddenInput() {
  var genderValue = '';
  var maleChecked = $('#gender_1').is(':checked');
  var femaleChecked = $('#gender_2').is(':checked');

  if(maleChecked && femaleChecked) {
    // '전체' 체크박스를 다시 체크
    $('#gender_0').prop('checked', true);
    genderValue = '';
  } else if(maleChecked) {
    genderValue = 'm';
  } else if(femaleChecked) {
    genderValue = 'f';
  }

  // hidden input값 설정
  $('#gender').val(genderValue);

//  console.log($('#gender').val());
}


// 연령 '전체' 체크박스 상태 변경
$('#age_0').change(function() {
  var isChecked = $(this).is(':checked');
  // '전체'가 체크되면 모든 연령 체크박스를 체크하고, 아니면 모두 해제
  $('.form-check-input-age').not('#age_0').prop('checked', isChecked);
  updateAgesHiddenInput();
});

// 개별연령 체크박스 상태 변경 시 전체 체크박스 조정
$('.form-check-input-age').not('#age_0').change(function() {
  
  // 모든 개별 체크박스가 체크되었는지 확인
  var allChecked = $('.form-check-input-age').not('#age_0').length ===
	  $('.form-check-input-age:checked').not('#age_0').length;
  
  // 전체 체크박스 상태를 업데이트
  $('#age_0').prop('checked', allChecked);
  
  // hidden에 있는 서버로 전송할 age값 입력
  updateAgesHiddenInput();
});
  
// 연령 input값 변경
function updateAgesHiddenInput() {
  // 체크된 연령 체크박스의 값을 배열로 가져옵니다.
  var checkedAges = $('.form-check-input-age:checked').not('#age_0').map(function() {
    return this.value;
  }).get(); // .get()으로 jQuery 객체를 일반 배열로 변환합니다.

  // '전체' 체크박스가 선택되어 있지 않고, 하나 이상의 체크박스가 선택되어 있는 경우
  if (!$('#age_0').is(':checked') && checkedAges.length > 0) {
    $('#ages').val(checkedAges);
  } else {
    // '전체' 체크박스가 선택되어 있거나, 아무 체크박스도 선택되지 않은 경우
    $('#ages').val('');
  }


//  console.log($('#ages').val());


}



</script>
</html>

				</div>
			</div>
		</div>
		<div class="footer">
			

<div><p>Stcreative 2024 Sample Project.</p></div>
		</div>
	</div>	
</body>
</html>