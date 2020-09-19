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

<%@ page import="user.UserDAO"%>
<%@ page import="java.io.PrintWriter"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="user" class="user.User" scope="page" />
<jsp:setProperty name="user" property="userID" />
<jsp:setProperty name="user" property="userPassword" />
<jsp:setProperty name="user" property="userName" />
<%-- <jsp:setProperty name="user" property="userGender" /> --%>
<jsp:setProperty name="user" property="userEmail" />
<jsp:setProperty name="user" property="userNickname" />



<title>MathNS</title>
</head>
<body>
	<%
	// 성별은 뺐음
	if(user.getUserID() == null || user.getUserPassword() == null || user.getUserName() == null 
		|| user.getUserEmail() == null || user.getUserNickname() == null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력하지 않은 사항이 있습니다.')");
		script.println("history.back()");
		script.println("</script>");
	} else {
		UserDAO userDAO = new UserDAO();
		
		int result = userDAO.join(user);
		
		if (result == 1) {
			session.setAttribute("userID", user.getUserID());
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = '../Page/mainPage.jsp'");
			script.println("</script>");
		} else if (result == 0) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')");
			script.println("history.back()");
			script.println("</script>");
		} else if (result == -1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 존재하는 아이디입니다.')");
			script.println("history.back()");
			script.println("</script>");
		} else if (result == -2) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('삐ㅡ빅 DB오류')");
			script.println("history.back()");
			script.println("</script>");
		}
	}
	%>

</body>
</html>
