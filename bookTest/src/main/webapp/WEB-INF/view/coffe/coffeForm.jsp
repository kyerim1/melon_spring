<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커피 메뉴 등록</title>
<link rel="stylesheet" href="/css/write.css">
</head>
<body>
	<div id="wrap">
	<form method="post" action="/coffeSave">
			<div id="formWrap">
				<div class="inputField">
					<label for="itemName">커피메뉴명 : </label>
					<input type="text" name="itemName" id="itemName">
				</div>
				<div class="inputField">
					<label for="price">가격 : </label>
					<input type="number" name="price" id="price">
				</div>
				<div class="inputField">
					<label for="">디카페인 : </label>
					<div class="radioField">
						<input type="radio" name="decaffein" value="0" checked>카페인
						<input type="radio" name="decaffein" value="1">디카페인
					</div>
				</div>
				<button id="bt">등록</button>
			</div>
			
	</form>
	</div>
	
</body>
</html>