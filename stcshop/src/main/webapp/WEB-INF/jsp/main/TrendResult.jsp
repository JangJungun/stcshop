<%--

  쇼핑 트렌드 분야통계 조회결과 페이지



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

<!-- chart.js -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.1/dist/chart.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-annotation@1.0.2"></script>


<title>조회 결과</title>
</head>
<body>

<div class="container mt-3">
  <div class="row mb-4">
    <div class="col">
      <button onclick="history.back()" class="btn btn-secondary">뒤로가기</button>
    </div>
  </div>

  <!-- 차트 들어갈 칸 -->
  <div class="row mb-5">
    <div class="col">
      <canvas id="trendChart" width="300" height="250"></canvas>
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
//JSON 문자열을 JavaScript 객체로 파싱
var trendData = JSON.parse('<c:out value="${trendData}" escapeXml="false" />');

// 차트 데이터 준비
var labels = trendData.results[0].data.map(function(item) {
    return item.period;
});

// 차트 구성
var ctx = document.getElementById('trendChart').getContext('2d');

var datasets = trendData.results.map(function(result, index) {
    var datasetData = result.data.map(function(item) {
        return item.ratio;
    });

    // 색상 배열
    var colors = ['rgba(255, 99, 132, 0.2)', 'rgba(54, 162, 235, 0.2)', 'rgba(255, 206, 86, 0.2)'];

    return {
        label: result.title + ' 검색 비율 (%)',
        data: datasetData,
        fill: false,
        borderColor: colors[index % colors.length],  
        backgroundColor: 'rgba(0, 0, 0, 0)',
        pointBorderColor: colors[index % colors.length],
        pointBackgroundColor: '#fff',
        pointBorderWidth: 1,
        pointHoverRadius: 5,
        pointHoverBackgroundColor: colors[index % colors.length],
        pointHoverBorderColor: colors[index % colors.length],
        pointHoverBorderWidth: 2,
        pointRadius: 1,
        pointHitRadius: 10,
    };
});

var trendChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: labels,
        datasets: datasets
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        tooltips: {
            mode: 'index',
            intersect: false,
        },
        hover: {
            mode: 'nearest',
            intersect: true
        },
        scales: {
            x: {
                display: true,
                scaleLabel: {
                    display: true,
                    labelString: '날짜'
                }
            },
            y: {
                display: true,
                scaleLabel: {
                    display: true,
                    labelString: '검색 비율 (%)'
                }
            }
        }
    }
});


</script>
</body>
</html>