<%--

  쇼핑 트렌드 분야통계 조회 페이지



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
    <title>분야별 검색</title>

</head>
<body>

<div class="container mt-5">
    <h2>통계 조회</h2>
    <hr />
	  <div class="row a">
	   	<div class="col-md-8">
	   		<!-- 통계 조회 form -->
			<form method="post" action="/main/inquiry.do" id="inquiryForm">
				<div class="row g-3">
				
				<strong class="title">분류</strong>
				
				<!-- 분류값 option -->
	            <div class="form-group col-sm-3">
				  <select class="form-control form-select" id="category1" name="category1" required>
				    <option value="" selected disabled hidden>1분류</option>
				  </select>
				
				</div>
				<div class="form-group col-sm-3">
				  
				  <select class="form-control form-select" id="category2" name="category2" style="display: none;">
				    <option value="" selected disabled hidden>2분류</option>
				  </select>
				</div>
				<div class="form-group col-sm-3">
				  
				  <select class="form-control form-select" id="category3" name="category3" style="display: none;">
				    <option value="" selected disabled hidden>3분류</option>
				  </select>
				</div>
	 			<div class="form-group col-sm-3">
				  
	
				</div> 
				
				
				<!-- api이용을 위한 hidden 값 -->
				<input type="hidden" id="categoryName" name="categoryName">
				<input type="hidden" id="categoryParam" name="categoryParam">
				<input type="hidden" id="categoryName2" name="categoryName2">
				<input type="hidden" id="categoryParam2" name="categoryParam2">
				<input type="hidden" id="categoryName3" name="categoryName3">
				<input type="hidden" id="categoryParam3" name="categoryParam3">
				
				<button type="button" class="w-25 btn btn-secondary ms-2" id="addCategory">추가</button>
	<%-- --%>
			<hr />	
			
				<!-- 검색어 조회 -->
				<input type="hidden" id="keyword" name="keyword" value=""/>
					<div class="set_keyword_wrap" style="display: none;">
					  <strong class="title me-2">검색어</strong>
						<div class="set_keyword2 d-flex flex-row">
							<div class="cell input">
								<input type="text" id="item_keyword" placeholder="비교할 검색어 추가">
								<button type="button" class="btn btn-outline-secondary" id="addNewKwrd">추가</button>
							</div>
						</div>
					</div>
					
					<button type="button" class="w-25 btn btn-secondary ms-2" id="addKeyword">검색어 추가</button>
					
	
	        <strong class="title me-2">기간</strong>
			<div class="row">
				<div class="col-md-2">
	              <select class="form-select" id="timeUnit" name="timeUnit" required>
	                <option value="date" >일간</option>
	                <option value="week" selected>주간</option>
	                <option value="month" >월간</option>
	              </select>
	              
	              <div class="invalid-feedback">
	                valid
	              </div>
	            </div>
	            
				<div class="col-md-5" id="">
				  <!-- 1개월 라디오 버튼 -->
				  <input type="radio" class="btn-check" name="itemPeriod" id="setPeriod0" autocomplete="off" required>
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
	
				        <input type="date" class="form-control" id="startDate" name="startDate" required="required">
				      </div>
				    </div>
				    ~
				    <div class="col">
				      <div class="input-group input-group-sm">
	
				        <input type="date" class="form-control" id="endDate" name="endDate" required="required">
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
	  
	  <%-- 성별 --%>
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
	  <%-- 연령 --%>
	<div class="form_row form_float d-flex align-items-center">
	  <strong class="title me-2">연령</strong>
	  <div class="set_col set_target_chk d-flex">
	    <!-- 전체 체크박스 -->
	    <div class="form-check me-2">
	      <input type="checkbox" class="form-check-input age" id="age_0">
	      <label class="form-check-label" for="age_0">전체</label>
	    </div>
	    <!-- 10대 체크박스 -->
	    <div class="form-check me-2">
	      <input type="checkbox" class="form-check-input age" id="age_1" value="10">
	      <label class="form-check-label" for="age_1">10대</label>
	    </div>
	    <!-- 20대 체크박스 -->
	    <div class="form-check me-2">
	      <input type="checkbox" class="form-check-input age" id="age_2" value="20">
	      <label class="form-check-label" for="age_2">20대</label>
	    </div>
	    <!-- 30대 체크박스 -->
	    <div class="form-check me-2">
	      <input type="checkbox" class="form-check-input age" id="age_3" value="30">
	      <label class="form-check-label" for="age_3">30대</label>
	    </div>
	    <!-- 40대 체크박스 -->
	    <div class="form-check me-2">
	      <input type="checkbox" class="form-check-input age" id="age_4" value="40">
	      <label class="form-check-label" for="age_4">40대</label>
	    </div>
	    <!-- 50대 체크박스 -->
	    <div class="form-check me-2">
	      <input type="checkbox" class="form-check-input age" id="age_5" value="50">
	      <label class="form-check-label" for="age_5">50대</label>
	    </div>
	    <!-- 60대 체크박스 -->
	    <div class="form-check">
	      <input type="checkbox" class="form-check-input age" id="age_6" value="60">
	      <label class="form-check-label" for="age_6">60대 이상</label>
	    </div>
	  </div>
	  <input type="hidden" name="ages" id="ages">
	  </div>
	
	<%-- /연령 --%>
	
	
	            
		<hr class="my-4">
	
		<button class="w-50 btn btn-primary btn-lg" type="submit">조회</button>
		</form>
		<!-- 통계 조회 form -->
		
	  </div>
  </div>
  
  
  <div class="col-md-1"></div>
  
  <div class="col-md-3">
 	  
	  <div class="section_insite container">
	    <h4 class="insite_title">
	        <strong>주간 인기검색어</strong>
	        <span class="title_sub"></span>
	    </h4>
	    <div class="rank_top1000">
	        <strong>TOP 20</strong>
	        <div class="rank_top1000_scroll">
	            <ul class="rank_top1000_list list-group">
	                
	            </ul>
	        </div>
	        <div class="top100_btn_area d-flex justify-content-between align-items-center">
	            <span class="page_info"><em>1</em>/2</span>
	            <div class="btn_page_box">
	                <a href="#" class="btn_page_prev btn btn-secondary" disabled><span class="blind">이전</span></a>
	                <a href="#" class="btn_page_next btn btn-primary"><span class="blind">다음</span></a>
	            </div>
	        </div>
	    </div>
	</div>

		
		
	</div>
  </div>
	


<hr>
<%-- 비교조회 --%>
				
<!-- footer -->

</body>

<script type="text/javascript">

$(document).ready(function(){
	
	//분류1 option값 설정
	setCategoryOneOptions('category1');
	
	//분류 추가버튼 이벤트
	$('#addCategory').click(function() {
		var categoryCount = 1;
	
	    // 새로운 분류 세트 번호를 결정
	    if ($('.form-group3').length > 0 && $('.form-group2').length == 0) {
	        categoryCount = 2;
	    } else if ($('.form-group2').length > 0 && $('.form-group3').length == 0) {
	        categoryCount = 3;
	    } else if ($('.form-group2').length == 0 && $('.form-group3').length == 0) {
	        categoryCount = categoryCount + 1;
	    }
	    
	    // 새로운 분류 세트의 HTML 문자열을 생성
	    var newSetHtml = '';
	    for (var i = 1; i <= 3; i++) {
	      newSetHtml += '<div class="form-group' + categoryCount + ' col-sm-3">';
	      if(i==1){
	      	newSetHtml += '<select class="form-control form-select" id="category' + i + '-' + categoryCount + '" name="category' + i + '_' + categoryCount + '" >';
	      }else{
	      	newSetHtml += '<select class="form-control form-select" id="category' + i + '-' + categoryCount + '" name="category' + i + '_' + categoryCount + '" style="display: none;">';
	      }
	      newSetHtml += '<option value="" selected disabled hidden>' + i + '분류</option>';
	      newSetHtml += '</select>';
	      newSetHtml += '</div>';
	    }

	    newSetHtml += '<div class="form-group' + categoryCount + ' col-sm-3"><button class="btn btn-secondary ms-2 delete-button" id="delete'+categoryCount+'">삭제</button></div>'
	    
	    
	    // 새로운 분류HTML 추가
	    $(this).before(newSetHtml);
	    
	 	// 새로 추가된 분류 1에 option 설정
	    setCategoryOneOptions('category1-' + categoryCount);
	    
	    
	 	// 추가된 분류의 삭제 버튼에 이벤트 핸들러를 연결
	    $('#delete' + categoryCount).click(function() {
	        var deleteId = $(this).attr('id');
	        var deleteNumber = deleteId.replace('delete', '');
	        $('.form-group' + deleteNumber).remove(); // 현재 버튼에 매칭되는 .form-group 요소를 삭제
	        $('#categoryName' + deleteNumber).val(''); // 해당 hidden input 값을 초기화.
	        $('#categoryParam' + deleteNumber).val(''); // 해당 hidden input 값을 초기화.
	        categoryCount--;
	        //버튼 활성화
	        if ($('.delete-button').length < 2) {
	            $("#addCategory").attr("disabled", false);
	        }
	    });
		
	 	// 버튼 비활성화
	    if ($('.delete-button').length >= 2) {
        	$("#addCategory").attr("disabled", true);
    	}
	 	
	  });
	  
	
	
	
	 //1분류 ~ 3분류 숨기기/보이기
	$(document).on('change', '.form-select', function() {
        // 현재 select의 다음 모든 field-group을 찾아서 숨기고, select를 default value로 설정
        var allNextGroups = $(this).closest('.form-group').nextAll('.form-group');
        allNextGroups.find('.form-select').val('').hide();
        var allNextGroups2 = $(this).closest('.form-group2').nextAll('.form-group2');
        allNextGroups2.find('.form-select').val('').hide();
        var allNextGroups3 = $(this).closest('.form-group3').nextAll('.form-group3');
        allNextGroups3.find('.form-select').val('').hide();

        // 현재 select의 다음 field-group을 찾음
        var nextField = $(this).closest('.form-group').next('.form-group').find('.form-select');
        var nextField2 = $(this).closest('.form-group2').next('.form-group2').find('.form-select');
        var nextField3 = $(this).closest('.form-group3').next('.form-group3').find('.form-select');

        // 만약 현재 select의 값이 ""가 아니라면 다음 field-group을 표시함
        if ($(this).val() !== "") {
            nextField.show();
        }
        if ($(this).val() !== "") {
            nextField2.show();
        }
        if ($(this).val() !== "") {
            nextField3.show();
        }
        
    });
	
	 
	// 라디오 버튼 변경 시 호출될 함수를 정의
	  function handleRadioChange() {
	    var $customPeriodInputs = $('#customPeriodInputs');
	    var $startDate = $('#startDate');
	    var $endDate = $('#endDate');
	    var today = new Date();
	    
	    // '직접입력' 라디오 버튼이 체크되었는지 확인
	    if($('#setPeriod3').is(':checked')) {
	      //직접 날짜선택하는 input 보이도록 함 기본값으로 오늘날짜.
	      $customPeriodInputs.show();
	      $startDate.val(formatDate(today));
	      $endDate.val(formatDate(today));
	    } else {
	      $customPeriodInputs.hide();
	      
	      // 현재 체크된 라디오 버튼의 id를 기반으로 날짜 계산
	      var checkedRadioButtonId = $('input[name="itemPeriod"]:checked').attr('id');
	      var start = new Date(today);

	      switch(checkedRadioButtonId) {
	        //1개월
	        case 'setPeriod0':
	          start.setMonth(today.getMonth() - 1);
	          break;
	        //3개월
	        case 'setPeriod1':
	          start.setMonth(today.getMonth() - 3);
	          break;
	        //1년
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
	 
	  
	  
	  
	  
	  
	  //인기검색어 TOP 100 페이징, 비동기적으로 데이터 가져오기
	  var currentPage = 1;
      var totalPage = 2;
      /*
      페이지 로드시 loadPage함수를 한번만 실행하지만, 
      inquirytrendData.do의 future.join()에서 크롤링작업이 완료될때까지 대기하기 때문에
      크롤링이 완료되는대로 페이지에 List 반영
      */
      loadPage(currentPage);

      //"다음" 버튼 클릭이벤트
      $(".btn_page_next").click(function(e) {
          e.preventDefault();
          if(currentPage < totalPage) {
              currentPage++;
              loadPage(currentPage);
          }
      });
		
      //"이전" 버튼 클릭이벤트
      $(".btn_page_prev").click(function(e) {
          e.preventDefault();
          if(currentPage > 1) {
              currentPage--;
              loadPage(currentPage);
          }
      });

      //주간 인기검색어 비동기식으로 가져오기
      function loadPage(page) {
          $.ajax({
              url: "/main/inquirytrendData.do", 
              type: "GET",
              data: { page: page },
              success: function(data) {
                  var listHtml = '';
                  $.each(data, function(i, item) {
                	    var order = (page - 1) * 10 + (i + 1);
                	    listHtml += '<li class="list-group-item"><a href="/main/searchTopKeyword.do?keyword=' + encodeURIComponent(item.keyword) + '" class="link_text"><span class="rank_top1000_num badge bg-primary">' + order + '</span>' + item.keyword + '</a></li>';
                	});

                  $(".rank_top1000_list").html(listHtml);
                  $(".page_info").html('<em>' + page + '</em>/2');
                  
               // 페이지 정보와 버튼 상태 업데이트
                  updatePageInfoAndButtons(page);
              },
              error: function(jqXHR, textStatus, errorThrown) {
                  console.log(textStatus, errorThrown);
              }
          });
      }
	  
	  
      
});

//각 분류의 <select>에 옵션을 추가하는 함수
function addOptionsToSelect(selectElementId, options) {
  // 해당 select 요소를 찾습니다.
  var $select = $("#" + selectElementId);

  // 옵션을 추가합니다.
  options.forEach(function(option) {
    $select.append(new Option(option.text, option.value));
  });
}

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
  $('.age').not('#age_0').prop('checked', isChecked);
  updateAgesHiddenInput();
});

// 개별연령 체크박스 상태 변경 시 전체 체크박스 조정
$('.age').not('#age_0').change(function() {
  
  // 모든 개별 체크박스가 체크되었는지 확인
  var allChecked = $('.age').not('#age_0').length ===
	  $('.age:checked').not('#age_0').length;
  
  // 전체 체크박스 상태를 업데이트
  $('#age_0').prop('checked', allChecked);
  
  // hidden에 있는 서버로 전송할 age값 입력
  updateAgesHiddenInput();
});
  
// 연령 input값 변경
function updateAgesHiddenInput() {
  // 체크된 연령 체크박스의 값을 배열로 가져옵니다.
  var checkedAges = $('.age:checked').not('#age_0').map(function() {
    return this.value;
  }).get(); // .get()으로 jQuery 객체를 일반 배열로 변환합니다.

  // '전체' 체크박스가 선택되어 있지 않고, 하나 이상의 체크박스가 선택되어 있는 경우
  if (!$('#age_0').is(':checked') && checkedAges.length > 0) {
    $('#ages').val(checkedAges);
  } else {
    // '전체' 체크박스가 선택되어 있거나, 아무 체크박스도 선택되지 않은 경우
    $('#ages').val('');
  }

}

//첫번째 분류값의 option값들을 가져오기
function setCategoryOneOptions(id) {
    $.ajax({
        url: '/getCategoryOne.do',  
        type: 'GET',
        success: function(data) {
            var $category1 = $('#' + id);
            $.each(data, function(index, item) {
                $category1.append('<option value="' + item.gdsClsfOneNm + '" data-param="' + item.catId + '">' + item.gdsClsfOneNm + '</option>');
            });
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log('Ajax 요청 실패');
            console.log('textStatus: ' + textStatus);
            console.log('errorThrown: ' + errorThrown);
        }
    });
}

//#category1의 선택이 변경될 때 category2의 option값 가져오기
$('#category1').change(function() {
    var selectedValue = $(this).val();
    $.ajax({
        url: '/getCategoryTwo.do',
        type: 'GET',
        data: { gdsClsfOneNm: selectedValue },
        success: function(data) {
            var $category2 = $('#category2');
            $category2.find('.dynamic-option').remove(); // 동적으로 추가된 option만 제거
            $.each(data, function(index, item) {
                $category2.append('<option class="dynamic-option" value="' + item.gdsClsfTwoNm + '" data-param="' + item.catId + '">' + item.gdsClsfTwoNm + '</option>');
            });
            $category2.show();
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log('Ajax 요청 실패');
            console.log('textStatus: ' + textStatus);
            console.log('errorThrown: ' + errorThrown);
        }
    });
});

//#category2의 선택이 변경될 때 category3의 option값 가져오기
$('#category2').change(function() {
    var selectedValue = $(this).val();
    var gdsClsfOneNm = $('#category1').val();
    $.ajax({
        url: '/getCategoryThr.do',
        type: 'GET',
        data: { gdsClsfOneNm: gdsClsfOneNm, gdsClsfTwoNm: selectedValue },
        success: function(data) {
            var $category3 = $('#category3');
            $category3.find('.dynamic-option').remove(); // 동적으로 추가된 option만 제거
            $.each(data, function(index, item) {
                $category3.append('<option class="dynamic-option" value="' + item.gdsClsfThrNm + '" data-param="' + item.catId + '">' + item.gdsClsfThrNm + '</option>');
            });
            $category3.show();
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log('Ajax 요청 실패');
            console.log('textStatus: ' + textStatus);
            console.log('errorThrown: ' + errorThrown);
        }
    });
});

//"추가" 버튼을 클릭했을때, 생기는 카테고리의 option값 가져오기
$(document).on('change', '[id^=category1-]', function() {
    var selectedValue = $(this).val();
    var categoryNumber = $(this).attr('id').split('-')[1];
    var $category2 = $('#category2-' + categoryNumber);
    $.ajax({
        url: '/getCategoryTwo.do',
        type: 'GET',
        data: { gdsClsfOneNm: selectedValue },
        success: function(data) {
            $category2.find('.dynamic-option').remove(); 
            $.each(data, function(index, item) {
                $category2.append('<option class="dynamic-option" value="' + item.gdsClsfTwoNm + '" data-param="' + item.catId + '">' + item.gdsClsfTwoNm + '</option>');
            });
            $category2.show();
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log('Ajax 요청 실패');
            console.log('textStatus: ' + textStatus);
            console.log('errorThrown: ' + errorThrown);
        }
    });
});

//"추가" 버튼을 클릭했을때, 생기는 카테고리의 option값 가져오기
$(document).on('change', '[id^=category2-]', function() {
    var selectedValue = $(this).val();
    var categoryNumber = $(this).attr('id').split('-')[1];
    var gdsClsfOneNm = $('#category1-' + categoryNumber).val();
    var $category3 = $('#category3-' + categoryNumber);
    $.ajax({
        url: '/getCategoryThr.do',
        type: 'GET',
        data: { gdsClsfOneNm: gdsClsfOneNm, gdsClsfTwoNm: selectedValue },
        success: function(data) {
            $category3.find('.dynamic-option').remove(); 
            $.each(data, function(index, item) {
                $category3.append('<option class="dynamic-option" value="' + item.gdsClsfThrNm + '" data-param="' + item.catId + '">' + item.gdsClsfThrNm + '</option>');
            });
            $category3.show();
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log('Ajax 요청 실패');
            console.log('textStatus: ' + textStatus);
            console.log('errorThrown: ' + errorThrown);
        }
    });
});

//분류1~3 중 마지막에 선택값을 categoryName으로 설정
//각 category에 저장된 param값을 categoryParam으로 설정
$(document).on('change', '.form-control.form-select', function() {
    var selectedValue = $(this).val();
    var dataParam = $(this).find('option:selected').data('param');
//    var categoryNumber = $(this).is('#category1') ? '' : $(this).attr('id').split('-')[1];

    if($(this).is('#category1') || $(this).is('#category2') || $(this).is('#category3')){
    	var categoryNumber = '';
    }else{
    	var categoryNumber = $(this).attr('id').split('-')[1];
    }
    
    if(selectedValue) {
        $('#categoryName' + categoryNumber).val(selectedValue);
    }
    if(dataParam) {
        $('#categoryParam' + categoryNumber).val(dataParam);
    }

    console.log('categoryName' + categoryNumber + ': ' + selectedValue);
    console.log('categoryParam' + categoryNumber + ': ' + dataParam);
});

$('#inquiryForm').submit(function(e) {
    // 각 hidden 필드에 값이 설정되었는지 확인합니다.
    for(var i = 1; i <= categoryCount; i++) {
        var categoryNameValue = $('#categoryName' + i).val();
        var categoryParamValue = $('#categoryParam' + i).val();

        if(!categoryNameValue || !categoryParamValue) {
            // 예외처리
            e.preventDefault();
            alert('모든 카테고리를 선택해주세요.');
            return;
        }
    }
});



//"검색어 추가" 버튼 클릭이벤트
  $('#addKeyword').click(function(){
    var $this = $(this);
    $('.set_keyword_wrap').toggle();

    if ($('.set_keyword_wrap').is(':visible')) {
      $this.text('검색어 취소');
   	  // form-group2와 form-group3이 있다면 제거
      $('.form-group2, .form-group3').remove();
      // "분류 추가" 버튼 숨기기
      $('#addCategory').hide();
    } else {
      $this.text('검색어 추가');
      $('.cell.keyword').remove();
      $('#item_keyword').val('');
      //추가버튼 다시 활성화
      if($('.cell.keyword').length < 5){
        $('#addNewKwrd').attr("disabled", false);
      }
   	  // "분류 추가" 버튼 다시 보이기
      $('#addCategory').show().attr('disabled', false);
    }
    updateKeywords();
  });

//검색어 추가 > 추가 버튼 클릭이벤트
$('#addNewKwrd').click(function(){
    if($('.cell.keyword').length < 5){
      var new_keyword = $('#item_keyword').val();
      if(new_keyword != ''){
        var new_keyword_div = '<div class="cell keyword d-inline-block p-2 border rounded me-2"><span>'+ new_keyword +'</span> <a href="#" class="deleteKeyword text-danger ms-2">X</a></div>'


;
        $('.set_keyword2').append(new_keyword_div);
        $('#item_keyword').val('');
      }
    }
    if($('.cell.keyword').length >= 5){
      //추가버튼 비활성화
      $('#addNewKwrd').attr("disabled", true);
    }
    updateKeywords();
  });

  $(document).on('click', '.deleteKeyword', function(){
    $(this).parent().remove();
    if($('.cell.keyword').length < 5){
      //추가버튼 활성화
      $('#addNewKwrd').attr("disabled", false);
    }
    updateKeywords();
  });
  
function updateKeywords() {
    var keywords = $('.cell.keyword span').map(function(){
      return $(this).text();
    }).get();
    $('#keyword').val(keywords.join(','));
 }


function updatePageInfoAndButtons(page) {
    // 페이지 정보 업데이트
    $(".page_info").html('<em>' + page + '</em>/2');

    // 버튼 활성/비활성 상태 업데이트
    if(page === 1) {
        $(".btn_page_prev").attr("disabled", true);
    } else {
        $(".btn_page_prev").removeAttr("disabled");
    }

    if(page === 10) {
        $(".btn_page_next").attr("disabled", true);
    } else {
        $(".btn_page_next").removeAttr("disabled");
    }
}
</script>
</html>
