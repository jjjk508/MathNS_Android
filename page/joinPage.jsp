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

			<form class="form-inline my-2 my-lg-0 ml-auto">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-dark my-2 my-sm-0" type="submit">Search</button>
			</form>

			<ul class="navbar-nav form-inline my-2 my-lg-0">
				<li class="nav-item dropdown "><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">접속하기</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item active" href="#">로그인</a> <a
							class="dropdown-item" href="#">회원가입</a>
						<!-- 세션걸고 로그인했다면 마이페이지 보이도록 만들 것  -->
						<!-- <div class="dropdown-divide"></div>
						<a class="dropdown-item" href="#">Something else here</a> -->
					</div></li>
			</ul>
		</div>
	</nav>
	
	<!-- 회원가입 div -->
 	<div class="container" style="margin-top: 80px;">
			<div class="jumbotron" style="padding: 80px;">
				<form method="post" action="../action/joinAction.jsp">
					<h3 style="text-align: center;">MathNS 회원가입</h3>
					
					<!-- ID -->
					<div class="form-group">
						<div class="btn-group" style="width: 100%;">
							<div style="width: 70%;">
								<input type="text" class="form-control" placeholder="아이디"	name="userID" maxlength="20">
							</div>
							<div style="width: 30%; margin-left: 30px;">
								<input type="submit" class="btn btn-dark form-control">중복확인
							</div>
						</div>
					</div>
					
					<!-- 닉네임 중복체크 크기 조정/전송타입 해야함 -->
					<div class="form-group">
						<div class="btn-group" style="width: 100%;">
							<div style="width: 70%;">
								<input type="text" class="form-control" placeholder="닉네임" name="userNickname" maxlength="20">
							</div>
							<div style="width: 30%; margin-left: 30px;">
								<label class="btn btn-dark form-control">중복확인</label>
							</div>
						</div>
					</div>
					
					<!-- 비밀번호 -->
					<div class="form-group">
						<input type="text" class="form-control" placeholder="비밀번호" name="userPassword" maxlength="20">
					</div>
					
					<!-- 비밀번호 확인 -->
					<div class="form-group">
						<input type="text" class="form-control" placeholder="비밀번호 확인" name="userPassword" maxlength="20">
					</div>
					
					<!-- 이름 -->
					<div class="form-group">
						<input type="text" class="form-control" placeholder="이름" name="userName" maxlength="20">
					</div>
					
					<!-- Email 중복체크 크기 조정해야함 -->
					<div class="form-group">
						<div class="btn-group" style="width: 100%;">
							<div style="width: 70%;">
								<input type="email" class="form-control" placeholder="이메일" name="userEmail" maxlength="20">
							</div>
							<div style="width: 30%; margin-left: 30px;">
								<label class="btn btn-dark form-control">중복확인</label>
							</div>
						</div>
					</div>
					
<!-- 					성별
					<div class="form-group" style="text-align: center;">
						<div class="btn-group btn-group-toggle" data-toggle="buttons">
							<label class="btn btn-dark active">
								<input type="radio" name="userGender" value="남자">남자
							</label>
							<label class="btn btn-dark">
								<input type="radio" name="userGender" value="여자">여자
							</label>
						</div>
					</div> -->
					
					<!-- 전송 -->
					<div style="width: 30%; margin: 0 auto;">
						<input type="submit" class="btn btn-dark form-control" value="회원가입">
					</div>
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