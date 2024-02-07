<%--

  접근거부 페이지. 이전페이지로 되돌아간다.



  << 개정이력(Modification Information) >>
 
    수정일      수정자           수정내용
   -------    --------    ---------------------------
   2024-01-22   장준근          신규개발
   
   
  author   : SI&컨설팅 사업본부 장준근
  since    : 1.0.0
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
    alert("권한이 없습니다. 이전 페이지로 돌아갑니다.");
    history.back();
</script>
