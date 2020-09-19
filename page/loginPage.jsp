<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/custom.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">

	
<title>MathNS</title>
</head>
<body>
	<nav class="navbar my-nav navbar-expand-md">
		<a class="navbar-brand" href="#">MathNS</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">

			<span class="navbar-toggler-icon"><i class="fa fa-bars"
				aria-hidden=""></i></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">게시판</a></li>
				<li class="nav-item"><a class="nav-link" href="#">오답노트</a></li>
				<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
				</li>
			</ul>

			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-dark my-2 my-sm-0" type="submit">Search</button>
			</form>

			<ul class="navbar-nav form-inline my-2 my-lg-0 mr-right-auto">
				<li class="nav-item dropdown "><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">접속하기</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item active" href="#">로그인</a> <a
							class="dropdown-item" href="joinPage.jsp">회원가입</a>
						<!-- 세션걸고 로그인했다면 마이페이지 보이도록 만들 것  -->
						<!-- <div class="dropdown-divide"></div>
						<a class="dropdown-item" href="#">Something else here</a> -->
					</div></li>
			</ul>
		</div>
	</nav>

 	<div class="container" style="margin-top: 80px;">
			<div class="jumbotron" style="padding: 80px;">
				<form method="post" action="../action/loginAction.jsp">
					<h3 style="text-align: center;">로그인화면</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디"	name="userID" maxlength="20">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="비밀번호" name="userPassword" maxlength="20">
					</div>

					<input type="submit" class="btn btn-dark form-control" value="로그인">
				</form>
			</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>