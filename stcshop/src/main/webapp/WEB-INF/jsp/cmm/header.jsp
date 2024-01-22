<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 부트스트랩 5.3.2 / jQuery 3.7.1 -->
<link rel="stylesheet" href="<c:url value="/js/jquery-ui-1.13.2/jquery-ui.css"/>">
<link rel="stylesheet" href="<c:url value="/css/bootstrap/bootstrap.min.css"/>">

<script src="<c:url value='/js/jquery-3.7.1.min.js'/>"></script>
<script src="<c:url value='/js/bootstrap/bootstrap.min.js'/>"></script>

<title>header</title>
</head>
<body>
<!-- header -->
<nav class="navbar navbar-expand-lg navbar-light bg-light" aria-label="Third navbar example">
    <div class="container-fluid">
	  <img src="<c:url value='/images/logo_image.png'/>" alt="logo" class="logo" width="10%">
      <a class="navbar-brand" href="#"></a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample03" aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExample03">
        <ul class="navbar-nav me-auto mb-2 mb-sm-0">
          <li class="nav-item" style="margin-right: 40px;">
            <a class="nav-link" aria-current="page" href="#">이용안내</a>
          </li>
          <li class="nav-item" style="margin-right: 40px;">
            <a class="nav-link" href="#">분야별 통계</a>
          </li>
          <li class="nav-item" style="margin-right: 40px;">
            <a class="nav-link" href="#">검색어별 통계</a>
          </li>
          <li class="nav-item" style="margin-right: 40px;">
            <a class="nav-link" href="#">마이페이지</a>
          </li>
          <li class="nav-item" style="margin-right: 40px;">
            <a class="nav-link" href="#">관리자페이지</a>
          </li>


        </ul>
<!--         
		<form role="search">
          <input class="form-control" type="search" placeholder="Search" aria-label="Search">
        </form>
-->
        
      </div>
    </div>
    <div class="d-flex align-items-center">
	  <p class="fw-bolder mb-0 text-nowrap">관리자님 어서오세요.   &nbsp;&nbsp;</p>
	</div>

    <img src="<c:url value='/images/defaultprofile.png'/>" alt="profile" class="profile" width="5%">
  </nav>
</body>
</html>