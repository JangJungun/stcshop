<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>분야별 검색</title>

</head>
<body>
<jsp:include page="../cmm/header.jsp" />
<div class="container mt-5">
    <h2>정보 조회</h2>
		<form>
			<div class="insite_form">
				<div class="form_row">
					<strong class="title">분야</strong>
					<div class="set_period category">
						<div class="select">
							<span class="select_btn">패션의류</span>
							<ul class="select_list scroll_cst">
								<li class="active"><a href="#" data-cid="50000000"
									class="option">패션의류</a></li>
								<li class=""><a href="#" data-cid="50000001" class="option">패션잡화</a></li>
								<li class=""><a href="#" data-cid="50000002" class="option">화장품/미용</a></li>
								<li class=""><a href="#" data-cid="50000003" class="option">디지털/가전</a></li>
								<li class=""><a href="#" data-cid="50000004" class="option">가구/인테리어</a></li>
								<li class=""><a href="#" data-cid="50000005" class="option">출산/육아</a></li>
								<li class=""><a href="#" data-cid="50000006" class="option">식품</a></li>
								<li class=""><a href="#" data-cid="50000007" class="option">스포츠/레저</a></li>
								<li class=""><a href="#" data-cid="50000008" class="option">생활/건강</a></li>
								<li class=""><a href="#" data-cid="50000009" class="option">여가/생활편의</a></li>
								<li class=""><a href="#" data-cid="50000010" class="option">면세점</a></li>
								<li class=""><a href="#" data-cid="50005542" class="option">도서</a></li>
							</ul>
						</div>
						<div class="select">
							<span class="select_btn">2분류</span>
							<ul class="select_list scroll_cst">
								<li class=""><a href="#" data-cid="50000167" class="option">여성의류</a></li>
								<li class=""><a href="#" data-cid="50000168" class="option">여성언더웨어/잠옷</a></li>
								<li class=""><a href="#" data-cid="50000169" class="option">남성의류</a></li>
								<li class=""><a href="#" data-cid="50000170" class="option">남성언더웨어/잠옷</a></li>
							</ul>
						</div>
					</div>
				</div>
				<!---->
				
				</div>
				<div class="form_row form_float">
					<strong class="title">기기별</strong>
					<div class="set_col set_target_chk">
						<div class="set_chk">
							<span class="select_chk v1"><input type="checkbox"
								id="18_device_0" class="chk"> <label for="18_device_0"
								class="lbl active">전체</label></span> <span class="select_chk v1"><input
								type="checkbox" id="18_device_1" class="chk" value="pc">
								<label for="18_device_1" class="lbl">PC</label></span><span
								class="select_chk v1"><input type="checkbox"
								id="18_device_2" class="chk" value="mo"> <label
								for="18_device_2" class="lbl">모바일</label></span>
						</div>
					</div>
				</div>
				<div class="form_row form_float">
					<strong class="title">성별</strong>
					<div class="set_col set_target_chk">
						<div class="set_chk">
							<span class="select_chk v1"><input type="checkbox"
								id="19_gender_0" class="chk"> <label for="19_gender_0"
								class="lbl active">전체</label></span> <span class="select_chk v1"><input
								type="checkbox" id="19_gender_1" class="chk" value="f">
								<label for="19_gender_1" class="lbl">여성</label></span><span
								class="select_chk v1"><input type="checkbox"
								id="19_gender_2" class="chk" value="m"> <label
								for="19_gender_2" class="lbl">남성</label></span>
						</div>
					</div>
				</div>
				<div class="form_row form_float">
					<strong class="title">연령</strong>
					<div class="set_col set_target_chk">
						<div class="set_chk">
							<span class="select_chk v1"><input type="checkbox"
								id="20_age_0" class="chk"> <label for="20_age_0"
								class="lbl active">전체</label></span> <span class="select_chk v1"><input
								type="checkbox" id="20_age_1" class="chk" value="10"> <label
								for="20_age_1" class="lbl">10대</label></span><span
								class="select_chk v1"><input type="checkbox"
								id="20_age_2" class="chk" value="20"> <label
								for="20_age_2" class="lbl">20대</label></span><span
								class="select_chk v1"><input type="checkbox"
								id="20_age_3" class="chk" value="30"> <label
								for="20_age_3" class="lbl">30대</label></span><span
								class="select_chk v1"><input type="checkbox"
								id="20_age_4" class="chk" value="40"> <label
								for="20_age_4" class="lbl">40대</label></span><span
								class="select_chk v1"><input type="checkbox"
								id="20_age_5" class="chk" value="50"> <label
								for="20_age_5" class="lbl">50대</label></span><span
								class="select_chk v1"><input type="checkbox"
								id="20_age_6" class="chk" value="60"> <label
								for="20_age_6" class="lbl">60대 이상</label></span>
						</div>
					</div>
				</div>
			</div>
			<!-- 조회 버튼 -->
			<button type="submit" class="btn btn-primary">조회하기</button>
		</form>
	</div>


</body>
</html>
