<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커피 상세</title>
<!-- jquery CDN-->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/css/info.css">
<script src="/javascript/info.js"></script>

<script>
	inputType=["text","number","radio"];
	inputName=["itemName","price","decaffein"];
</script>

</head>
<body>

	<form id="fm" method="get" action="/coffee/delete">
		<input type="hidden" name="id" value="${menu.coffeId }">
		
	<div id="wrap">
		<a href="/coffe">HOME</a>
		<table id="viewBox">
			<tr>
				<td class="fieldName">메뉴명</td>
				<td class="value">${ menu.itemName }</td>
			</tr>
			<tr>
				<td class="fieldName">가격</td>
				<td class="value">${ menu.price }</td>
			</tr>
			<tr>
				<td class="fieldName">디카페인 유무</td>
				<td class="value">${ menu.decaffein?'디카페인':'카페인' }</td>
			</tr>			
			<tr>
				<td colspan="2">
					<button type="button" id="modify">수정</button>
					<button type="button" id="del">삭제</button>
				</td>
			</tr>
			
		</table>
	</div>
	</form>

</body>
</html>