<%--

  쇼핑 트렌드 분야통계 조회 페이지



  << 개정이력(Modification Information) >>
 
    수정일      수정자           수정내용
   -------    --------    ---------------------------

   
   
  author   : SI&컨설팅 사업본부 장준근
  since    : 1.0.0
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>분야별 검색</title>

</head>
<body>

<div class="container mt-5">
    <h2>분야별 통계 조회</h2>
    <hr />
   	<h3>일반 조회</h3> 
		<form action="/main/trendresult.do">
			<div class="row g-3">
			<strong class="title">분류</strong>
            <div class="form-group col-sm-3">
			  
			  <select class="form-control form-select" id="field1" required>
			    <option value="" selected disabled hidden>1분류</option>
			    <option value="패션의류">sample1</option>
			    <option value="화장품/미용">sample2</option>
			    
			  </select>
			</div>
			<div class="form-group col-sm-3">
			  
			  <select class="form-control form-select" id="field2" style="display: none;">
			    <option value="" selected disabled hidden>2분류</option>
			    <option value="sample2">sample2</option>
			    <option value="sample3">sample3</option>
			    <!-- 기타 옵션 -->
			  </select>
			</div>
			<div class="form-group col-sm-3">
			  
			  <select class="form-control form-select" id="field3" style="display: none;">
			    <option value="" selected disabled hidden>3분류</option>
			    <option value="sample3">sample3</option>
			    <option value="sample4">sample4</option>
			    <!-- 기타 옵션 -->
			  </select>
			</div>
			<div class="form-group col-sm-3">
			  
			  <select class="form-control form-select" id="field4" style="display: none;">
			    <option value="" selected disabled hidden>4분류</option>
			    <option value="sample4">sample4</option>
			    <option value="sample5">sample5</option>
			    <!-- 기타 옵션 -->
			  </select>
			</div>
<%-- --%>

        <!-- <label for="state" class="form-label">기간</label> -->
        <strong class="title me-2">기간</strong>
		<div class="row">
			<div class="col-md-2">
              <select class="form-select" id="state" required>
                <option value="day" selected>일간</option>
                <option value="week" selected>주간</option>
                <option value="month" selected>월간</option>
              </select>
              
              <div class="invalid-feedback">
                valid
              </div>
            </div>
            
			<div class="col-md-5" id="">
			  <!-- 1개월 라디오 버튼 -->
			  <input type="radio" class="btn-check" name="item_period" id="35_set_period0" autocomplete="off">
			  <label class="btn btn-outline-primary" for="35_set_period0">1개월</label>
			
			  <!-- 3개월 라디오 버튼 -->
			  <input type="radio" class="btn-check" name="item_period" id="35_set_period1" autocomplete="off">
			  <label class="btn btn-outline-primary" for="35_set_period1">3개월</label>
			
			  <!-- 1년 라디오 버튼 -->
			  <input type="radio" class="btn-check" name="item_period" id="35_set_period2" autocomplete="off">
			  <label class="btn btn-outline-primary" for="35_set_period2">1년</label>
			
			  <!-- 직접입력 라디오 버튼 -->
			  <input type="radio" class="btn-check" name="item_period" id="35_set_period3" autocomplete="off">
			  <label class="btn btn-outline-primary" for="35_set_period3">직접입력</label>
			</div>
			<!-- '직접선택'이 활성화 될 때 보여질 입력 필드들 -->
			<div class="col-md-8" id="customPeriodInputs" style="padding-top: 10px; display: none;">
			  <div class="row">
			    <div class="col">
			      <div class="input-group input-group-sm">

			        <input type="date" class="form-control" id="startDate" name="start_date">
			      </div>
			    </div>
			    ~
			    <div class="col">
			      <div class="input-group input-group-sm">

			        <input type="date" class="form-control" id="endDate" name="end_date">
			      </div>
			    </div>
			  </div>
			</div>
		</div>

<%-- 기기별 --%>

<div class="form_row form_float d-flex align-items-center">
  <strong class="title me-2">기기별</strong>
  
  <div class="set_col set_target_chk d-flex">
    <!-- 전체 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="45_device_0">
      <label class="form-check-label" for="45_device_0">전체</label>
    </div>
    <!-- PC 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="45_device_1" value="pc">
      <label class="form-check-label" for="45_device_1">PC</label>
    </div>
    <!-- 모바일 체크박스 -->
    <div class="form-check">
      <input type="checkbox" class="form-check-input" id="45_device_2" value="mo">
      <label class="form-check-label" for="45_device_2">모바일</label>
    </div>
  </div>
  
  
  <strong class="title px-2 ms-4">성별</strong>
  <div class="set_col set_target_chk d-flex">
    <!-- 전체 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="45_gender_0">
      <label class="form-check-label" for="45_gender_0">전체</label>
    </div>
    <!-- 남 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="45_gender_1" value="m">
      <label class="form-check-label" for="45_gender_1">남</label>
    </div>
    <!-- 여 체크박스 -->
    <div class="form-check">
      <input type="checkbox" class="form-check-input" id="45_gender_2" value="f">
      <label class="form-check-label" for="45_gender_2">여</label>
    </div>
  </div>
  
  
  <strong class="title px-2 ms-4">연령</strong>
  <div class="set_col set_target_chk d-flex">
    <!-- 전체 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="45_age_0">
      <label class="form-check-label" for="45_age_0">전체</label>
    </div>
    <!-- 10대 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="45_age_1" value="10">
      <label class="form-check-label" for="45_age_1">10대</label>
    </div>
    <!-- 20대 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="45_age_2" value="20">
      <label class="form-check-label" for="45_age_2">20대</label>
    </div>
    <!-- 30대 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="45_age_3" value="30">
      <label class="form-check-label" for="45_age_3">30대</label>
    </div>
    <!-- 40대 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="45_age_4" value="40">
      <label class="form-check-label" for="45_age_4">40대</label>
    </div>
    <!-- 50대 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="45_age_5" value="50">
      <label class="form-check-label" for="45_age_5">50대</label>
    </div>
    <!-- 60대 체크박스 -->
    <div class="form-check">
      <input type="checkbox" class="form-check-input" id="45_age_6" value="60">
      <label class="form-check-label" for="45_age_6">60대 이상</label>
    </div>
  </div>
  
  </div>
</div>
<%-- /기기별 --%>


            
<%-- 비교조회 --%>
		<hr class="my-4">

		<button class="w-100 btn btn-primary btn-lg" type="submit">조회</button>
		</form>
		<hr>
		<form>
			<h3>비교 조회</h3>
			<div class="row g-3">
			
            <strong class="title">분류1</strong>
            <div class="form-group col-sm-3">
			  
			  <select class="form-control form-select" id="field1" required>
			    <option value="" selected disabled hidden>1분류</option>
			    <option value="sample1">sample1</option>
			    <option value="sample2">sample2</option>
			    <option value="sample3">sample3</option>
			    
			  </select>
			</div>
			<div class="form-group col-sm-3">
			  
			  <select class="form-control form-select" id="field2" style="display: none;">
			    <option value="" selected disabled hidden>2분류</option>
			    <option value="sample2">sample2</option>
			    <option value="sample3">sample3</option>
			    <!-- 기타 옵션 -->
			  </select>
			</div>
			<div class="form-group col-sm-3">
			  
			  <select class="form-control form-select" id="field3" style="display: none;">
			    <option value="" selected disabled hidden>3분류</option>
			    <option value="sample3">sample3</option>
			    <option value="sample4">sample4</option>
			    <!-- 기타 옵션 -->
			  </select>
			</div>
			<div class="form-group col-sm-3">
			  
			  <select class="form-control form-select" id="field4" style="display: none;">
			    <option value="" selected disabled hidden>4분류</option>
			    <option value="sample4">sample4</option>
			    <option value="sample5">sample5</option>
			    <!-- 기타 옵션 -->
			  </select>
			</div>
		</div>
<%-- --%>
			<div class="row g-3">
			<strong class="title">분류2</strong>
            <div class="form-group col-sm-3">
			  
			  <select class="form-control form-select" id="field1" required>
			    <option value="" selected disabled hidden>1분류</option>
			    <option value="sample1">sample1</option>
			    <option value="sample2">sample2</option>
			    <option value="sample3">sample3</option>
			    
			  </select>
			</div>
			<div class="form-group col-sm-3">
			  
			  <select class="form-control form-select" id="field2" style="display: none;">
			    <option value="" selected disabled hidden>2분류</option>
			    <option value="sample2">sample2</option>
			    <option value="sample3">sample3</option>
			    <!-- 기타 옵션 -->
			  </select>
			</div>
			<div class="form-group col-sm-3">
			  
			  <select class="form-control form-select" id="field3" style="display: none;">
			    <option value="" selected disabled hidden>3분류</option>
			    <option value="sample3">sample3</option>
			    <option value="sample4">sample4</option>
			    <!-- 기타 옵션 -->
			  </select>
			</div>
			<div class="form-group col-sm-3">
			  
			  <select class="form-control form-select" id="field4" style="display: none;">
			    <option value="" selected disabled hidden>4분류</option>
			    <option value="sample4">sample4</option>
			    <option value="sample5">sample5</option>
			    <!-- 기타 옵션 -->
			  </select>
			</div>
		</div>
<%-- --%>
			<div class="row g-3">
			<strong class="title">분류3</strong>
            <div class="form-group col-sm-3">
			  
			  <select class="form-control form-select" id="field1" required>
			    <option value="" selected disabled hidden>1분류</option>
			    <option value="sample1">sample1</option>
			    <option value="sample2">sample2</option>
			    <option value="sample3">sample3</option>
			    
			  </select>
			</div>
			<div class="form-group col-sm-3">
			  
			  <select class="form-control form-select" id="field2" style="display: none;">
			    <option value="" selected disabled hidden>2분류</option>
			    <option value="sample2">sample2</option>
			    <option value="sample3">sample3</option>
			    <!-- 기타 옵션 -->
			  </select>
			</div>
			<div class="form-group col-sm-3">
			  
			  <select class="form-control form-select" id="field3" style="display: none;">
			    <option value="" selected disabled hidden>3분류</option>
			    <option value="sample3">sample3</option>
			    <option value="sample4">sample4</option>
			    <!-- 기타 옵션 -->
			  </select>
			</div>
			<div class="form-group col-sm-3">
			  
			  <select class="form-control form-select" id="field4" style="display: none;">
			    <option value="" selected disabled hidden>4분류</option>
			    <option value="sample4">sample4</option>
			    <option value="sample5">sample5</option>
			    <!-- 기타 옵션 -->
			  </select>
			</div>
		</div>
<%-- --%>
	<div class="row g-3">
        <!-- <label for="state" class="form-label">기간</label> -->
        <strong class="title me-2">기간</strong>
		<div class="row">
			<div class="col-md-2">
              <select class="form-select" id="state" required>
                <option value="day" selected>일간</option>
                <option value="week" selected>주간</option>
                <option value="month" selected>월간</option>
              </select>
              
              <div class="invalid-feedback">
                valid
              </div>
            </div>
            
			<div class="col-md-5" id="">
			  <!-- 1개월 라디오 버튼 -->
			  <input type="radio" class="btn-check" name="item_period2" id="36_set_period0" autocomplete="off">
			  <label class="btn btn-outline-primary" for="36_set_period0">1개월</label>
			
			  <!-- 3개월 라디오 버튼 -->
			  <input type="radio" class="btn-check" name="item_period2" id="36_set_period1" autocomplete="off">
			  <label class="btn btn-outline-primary" for="36_set_period1">3개월</label>
			
			  <!-- 1년 라디오 버튼 -->
			  <input type="radio" class="btn-check" name="item_period2" id="36_set_period2" autocomplete="off">
			  <label class="btn btn-outline-primary" for="36_set_period2">1년</label>
			
			  <!-- 직접입력 라디오 버튼 -->
			  <input type="radio" class="btn-check" name="item_period2" id="36_set_period3" autocomplete="off">
			  <label class="btn btn-outline-primary" for="36_set_period3">직접입력</label>
			</div>
			<!-- '직접선택'이 활성화 될 때 보여질 입력 필드들 -->
			<div class="col-md-8" id="customPeriodInputs2" style="padding-top: 10px; display: none;">
			  <div class="row">
			    <div class="col">
			      <div class="input-group input-group-sm">

			        <input type="date" class="form-control" id="startDate" name="start_date">
			      </div>
			    </div>
			    ~
			    <div class="col">
			      <div class="input-group input-group-sm">

			        <input type="date" class="form-control" id="endDate" name="end_date">
			      </div>
			    </div>
			  </div>
			</div>
		</div>

<%-- 기기별 --%>

<div class="form_row form_float d-flex align-items-center">
  <strong class="title me-2">기기별</strong>
  
  <div class="set_col set_target_chk d-flex">
    <!-- 전체 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="45_device_0">
      <label class="form-check-label" for="45_device_0">전체</label>
    </div>
    <!-- PC 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="45_device_1" value="pc">
      <label class="form-check-label" for="45_device_1">PC</label>
    </div>
    <!-- 모바일 체크박스 -->
    <div class="form-check">
      <input type="checkbox" class="form-check-input" id="45_device_2" value="mo">
      <label class="form-check-label" for="45_device_2">모바일</label>
    </div>
  </div>
  
  
  <strong class="title px-2 ms-4">성별</strong>
  <div class="set_col set_target_chk d-flex">
    <!-- 전체 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="45_gender_0">
      <label class="form-check-label" for="45_gender_0">전체</label>
    </div>
    <!-- 남 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="45_gender_1" value="m">
      <label class="form-check-label" for="45_gender_1">남</label>
    </div>
    <!-- 여 체크박스 -->
    <div class="form-check">
      <input type="checkbox" class="form-check-input" id="45_gender_2" value="f">
      <label class="form-check-label" for="45_gender_2">여</label>
    </div>
  </div>
  
  
  <strong class="title px-2 ms-4">연령</strong>
  <div class="set_col set_target_chk d-flex">
    <!-- 전체 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="45_age_0">
      <label class="form-check-label" for="45_age_0">전체</label>
    </div>
    <!-- 10대 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="45_age_1" value="10">
      <label class="form-check-label" for="45_age_1">10대</label>
    </div>
    <!-- 20대 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="45_age_2" value="20">
      <label class="form-check-label" for="45_age_2">20대</label>
    </div>
    <!-- 30대 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="45_age_3" value="30">
      <label class="form-check-label" for="45_age_3">30대</label>
    </div>
    <!-- 40대 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="45_age_4" value="40">
      <label class="form-check-label" for="45_age_4">40대</label>
    </div>
    <!-- 50대 체크박스 -->
    <div class="form-check me-2">
      <input type="checkbox" class="form-check-input" id="45_age_5" value="50">
      <label class="form-check-label" for="45_age_5">50대</label>
    </div>
    <!-- 60대 체크박스 -->
    <div class="form-check">
      <input type="checkbox" class="form-check-input" id="45_age_6" value="60">
      <label class="form-check-label" for="45_age_6">60대 이상</label>
    </div>
  </div>
  </div>
</div>

<%-- /기기별 --%>
<hr class="my-4">
		<button class="w-100 btn btn-primary btn-lg" type="submit">조회</button>
		


		</form>
		
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
});

//모든 라디오 버튼에 대한 참조를 가져옵니다.
var radioButtons = document.getElementsByName('item_period');
var radioButtons2 = document.getElementsByName('item_period2');

// 라디오 버튼 변경 시 호출될 함수를 정의합니다.
function handleRadioChange() {
  var customPeriodInputs = document.getElementById('customPeriodInputs');
  var customPeriodInputs2 = document.getElementById('customPeriodInputs2');
  // '직접입력' 라디오 버튼이 체크되었는지 확인합니다.
  if(document.getElementById('35_set_period3').checked) {
    customPeriodInputs.style.display = 'block';
  } else {
    customPeriodInputs.style.display = 'none';
  }
  
  if(document.getElementById('36_set_period3').checked) {
    customPeriodInputs2.style.display = 'block';
  } else {
    customPeriodInputs2.style.display = 'none';
  }
  
}

// 모든 라디오 버튼에 이벤트 리스너를 추가합니다.
for(var i = 0; i < radioButtons.length; i++) {
  radioButtons[i].addEventListener('change', handleRadioChange);
}
for(var i = 0; i < radioButtons2.length; i++) {
  radioButtons2[i].addEventListener('change', handleRadioChange);
}

</script>
</html>
