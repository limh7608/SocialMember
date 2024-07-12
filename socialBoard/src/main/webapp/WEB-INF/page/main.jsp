<%@page import="java.io.PrintWriter"%>
<%@page import="com.home.socialMember.vo.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
MemberInfo memberInfo = (MemberInfo)request.getAttribute("memberInfo");
	if (memberInfo != null){
%>
		<%@ include file="../page/_inc/inc_header.jsp" %>
<%
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Social Board</title>
</head>
<body style="width: 100%; display: flex; flex-flow: column; align-items: center; margin-top: 3em;">
	<h1>Main</h1>
	<%if(memberInfo == null){ %>
	<div>
		<a onclick="location.href='LoginForm'">로그인</a>
	</div>
	<%} else { %>
	<div>
		<a onclick="location.href='Logout'">로그아웃</a>
	</div>
	<%} %>
</body>
</html>