<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">회원 관리</h2>

        <table class="table table-striped" style="font-size: 90%;">
            <thead class="thead-dark">
                <tr>
                    <th>고유식별ID</th>
                    <th>계정ID</th>
                    <th>닉네임</th>
                    <th>이메일</th>
                    <th>생년월일</th>
                    <th>성별</th>
                    <th>전화번호</th>
                    <th>회원구분</th>
                    <th>가입일</th>
                    <th>이용내역</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${usrLst}">
                    <tr>
                        <td>${user.usrId}</td>
                        <td>${user.lgnAcntId}</td>
                        <td>${user.nickNm}</td>
                        <td>${user.usrEml}</td>
                        <td>${user.usrBrdt}</td>
                        <td>
							<c:choose>
						        <c:when test="${user.sxdsCd == 'M'}">남자</c:when>
						        <c:when test="${user.sxdsCd == 'F'}">여자</c:when>
						        <c:otherwise>성별없음</c:otherwise>
						    </c:choose>
						</td>
                        <td>${user.mblTelno}</td>
                        <td>
							<c:choose>
						        <c:when test="${user.grpId == 'GROUP_00000000000001'}">관리자</c:when>
						        <c:when test="${user.grpId == 'GROUP_00000000000002'}">일반회원</c:when>
						        <c:otherwise>권한그룹미지정</c:otherwise>
						    </c:choose>
						</td>
                        <td><fmt:formatDate value="${user.joinDt}" pattern="yyyy-MM-dd" /></td>
                        
                        <td>
                            <form method="POST" action="/getUserHst.do">
						        <input type="hidden" name="usrId" value="${user.usrId}"/>
						        <input type="hidden" name="lgnAcntId" value="${user.lgnAcntId}"/>
						        <button type="submit" class="btn btn-info">이용내역 조회</button>
						    </form>
 						</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>