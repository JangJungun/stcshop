<%--

  쇼핑 트렌드 분야통계 조회결과 페이지



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
<meta charset="UTF-8">

<!-- chart.js -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.1/dist/chart.min.js" />
<title>조회 결과</title>
</head>
<body>
sdfsd
<div class="container mt-3">
  <div class="row mb-4">
    <div class="col">
      <button onclick="history.back()" class="btn btn-secondary">뒤로가기</button>
    </div>
  </div>

  <!-- 차트 들어갈 칸 -->
  <div class="row mb-5">
    <div class="col">
      <canvas id="myChart"></canvas>
    </div>
  </div>

  <!-- 추천 상품 목록 칸 -->
  <div class="row">
    <div class="col-12">
      <h4 class="mb-3">추천 상품 목록</h4>
    </div>
    <!-- 상품 목록을 2열로 나누어 6개의 칸을 만듭니다. -->
    <!-- 예시로 6개의 상품 칸을 만들었습니다. 실제 상품 정보를 반영해야 합니다. -->
    <div class="col-md-4 col-sm-6 mb-4" style="height: 200px;">상품 1</div>
    <div class="col-md-4 col-sm-6 mb-4" style="height: 200px;">상품 2</div>
    <div class="col-md-4 col-sm-6 mb-4" style="height: 200px;">상품 3</div>
    <div class="col-md-4 col-sm-6 mb-4" style="height: 200px;">상품 4</div>
    <div class="col-md-4 col-sm-6 mb-4" style="height: 200px;">상품 5</div>
    <div class="col-md-4 col-sm-6 mb-4" style="height: 200px;">상품 6</div>
  </div>
</div>





<script>
  // Chart.js를 사용한 차트 초기화
  var ctx = document.getElementById('myChart').getContext('2d');
  var myChart = new Chart(ctx, {
    // 차트의 형태와 데이터 설정
    type: 'bar', // 예시로 바 차트를 넣었습니다. 필요에 따라 변경하세요.
    data: {
      labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'], // 레이블 예시입니다.
      datasets: [{
        label: '# of Votes',
        data: [12, 19, 3, 5, 2, 3], // 데이터 예시입니다.
        backgroundColor: [
          'rgba(255, 99, 132, 0.2)', // 각 바의 배경색입니다.
          'rgba(54, 162, 235, 0.2)',
          'rgba(255, 206, 86, 0.2)',
          'rgba(75, 192, 192, 0.2)',
          'rgba(153, 102, 255, 0.2)',
          'rgba(255, 159, 64, 0.2)'
        ],
        borderColor: [
          'rgba(255, 99, 132, 1)', // 각 바의 경계선 색입니다.
          'rgba(54, 162, 235, 1)',
          'rgba(255, 206, 86, 1)',
          'rgba(75, 192, 192, 1)',
          'rgba(153, 102, 255, 1)',
          'rgba(255, 159, 64, 1)'
        ],
        borderWidth: 1
      }]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });
</script>
</body>
</html>