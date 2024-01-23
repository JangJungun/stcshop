<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title><tiles:insertAttribute name="title"/></title>
	<tiles:insertAttribute name="include"/>
	<style>
		.wrap {width: 100%;}
		.wrap .header {width: 0%;vertical-align: top;height: 0;}
		.wrap .middle {width: 100%;vertical-align: top;display: table;height: calc(95vh - 100px);}
		.wrap .middle .contents {display: table-row;}
		.wrap .middle .contents .left {display: table-cell;width: 7%;vertical-align: top;}
		 .wrap .middle .contents .body {display: inline-block;width: 95%; text-align: center; padding-top: 2%;} 


		.wrap .footer {width: 100%;vertical-align: top;height: 50px;}
	</style>
</head>
<body>
		<div class="header">
			<tiles:insertAttribute name="header"/>
		</div>
	<div class="wrap">
		<div class="middle">
			<div class="contents">
				<div class="left">
					<tiles:insertAttribute name="left"/>
				</div>
				<div class="body">
					<tiles:insertAttribute name="body"/>
				</div>
			</div>
		</div>
		<div class="footer">
			<tiles:insertAttribute name="footer"/>
		</div>
	</div>	
</body>
</html>