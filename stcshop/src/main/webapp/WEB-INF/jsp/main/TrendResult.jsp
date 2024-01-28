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

<style>


.product-item p {
    font-size: 12px;
    overflow: hidden; 
    margin: 5px 0;
}
</style>
<title>조회 결과</title>
</head>
<body>
<div class="container mt-3">
  <h2>조회 결과</h2>
  <hr />
  
  <div class="row mb-4">
    <div class="col">
      <button onclick="history.back()" class="btn btn-secondary">뒤로가기</button>
    </div>
  </div>

  <!-- 차트와 추천 상품 목록 칸 -->
  <div class="row mb-5">
    <!-- 차트 들어갈 칸 -->
    <div class="col-md-8">
      <div style="height: 300px;"> <!-- 차트 높이 조절 -->
        <canvas id="trendChart" width="300" height="200"></canvas> <!-- 차트 높이 조절 -->
      </div>
      <!-- <div class="row mt-3" id="button-set">
        <div class="col-md-4">
          <button class="btn btn-primary btn-block px-3">기기별 조회</button>
        </div>
        <div class="col-md-4">
          <button class="btn btn-primary btn-block px-3">성별 조회</button>
        </div>
        <div class="col-md-4">
          <button class="btn btn-primary btn-block px-3">연령별 조회</button>
        </div>
      </div> -->
    </div>
    <!-- 추천 상품 목록 칸 -->
    <div class="col-md-4">
      <h4 class="mb-3">추천 상품 목록</h4>
      <div class="row" style="height: 800px; overflow: auto;">
			<c:forEach var="data" items="${searchData}">
				<c:forEach var="item" items="${data.items}">
	
					<div class="col-md-6 mb-4 product-item" style="height: auto;">
						<div style="height: 150px;">
							<a href="${item.link}"><img src="${item.image}"
								alt="${item.title}" style="height: 100%; width: auto;"></a>
						</div>
	
						<div style="height: 100px;">
							<p><a href="${item.link}">${item.title}</a></p>
							<p>가격: ${item.lprice}</p>
							<p>${item.category1}> ${item.category2} > ${item.category3}</p>
						</div>
					</div>
				</c:forEach>
			</c:forEach>
		</div>
    </div>
  </div>
</div>



<script>
/* <차트 생성 script> */
//JSON 문자열을 JavaScript 객체로 파싱
var trendData = JSON.parse('<c:out value="${trendData}" escapeXml="false" />');

// 차트 데이터 준비
var labels = trendData.results[0].data.map(function(item) {
    return item.period;
});

// 차트 구성
var ctx = document.getElementById('trendChart').getContext('2d');

var datasets = trendData.results.map(function(result, index) {
    var datasetData;
    if (result.data.length > 0) {
        datasetData = result.data.map(function(item) {
            return item.ratio;
        });
    } else {
        // 검색 결과 데이터가 없는 경우, 0으로 채워진 배열을 생성
        datasetData = Array(labels.length).fill(0);
    }

    // 색상 배열
    var colors = ['rgba(255, 99, 132, 0.2)', 'rgba(54, 162, 235, 0.2)', 'rgba(255, 206, 86, 0.2)'];

    return {
        label: result.title + ' 검색 비율 (%)',
        data: datasetData,
        fill: false,
        borderColor: colors[index % colors.length],  
        backgroundColor: 'rgba(0, 0, 0, 0)',
        pointBorderColor: colors[index % colors.length],
        pointBackgroundColor: colors[index % colors.length],
        pointBorderWidth: 1,
        pointHoverRadius: 5,
        pointHoverBackgroundColor: colors[index % colors.length],
        pointHoverBorderColor: colors[index % colors.length],
        pointHoverBorderWidth: 2,
        pointRadius: 1,
        pointHitRadius: 10,
    };
console.log(datasetData);
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
/* </차트 생성 script> */

</script>
</body>
</html>