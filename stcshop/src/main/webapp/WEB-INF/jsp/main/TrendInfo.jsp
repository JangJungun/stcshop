<%--

  이용안내 페이지



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
<title>Insert title here</title>
</head>
<body>
<div class="container mt-5">
        <h1 class="mb-4">서비스 이용안내</h1>
        
        <div class="mb-3"><img alt="" src="<c:url value='/images/2.png'/>"  style="width: 50%;"></div>
        <p>메뉴에서 '통계조회'를 선택하여 통계조회 페이지로 이동하세요. 원하는 카테고리를 선택하여 상품을 조회할 수 있습니다.</p>
        
        <div class="mb-3"><img alt="" src="<c:url value='/images/1.png'/>"  style="width: 50%;"></div>
        <p>특정 검색어로도 상품을 조회할 수 있습니다.</p>
        
        <div class="mb-3"><img alt="" src="<c:url value='/images/3.png'/>"  style="width: 50%;"></div>
        <p>조회통계 그래프와 추천상품을 확인해보세요</p>
        
    </div>
</body>
</html>