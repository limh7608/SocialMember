<%@page import="com.home.socialMember.vo.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.*" %>
<%@ page import="java.time.*" %>
<%
MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/headerStyles.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <header>
        <div class="logo">
            <a href="/socialBoard/"><img src="resources/images/logo.png" id="logoImage" style="cursor: pointer;"/></a>
        </div>
        <nav>
            <ul class="menu">
                <li><a href="#category1">대분류 1</a></li>
                <li><a href="#category2">대분류 2</a></li>
                <li id="myPage"><a href="MyPage">마이페이지</a></li>
                <%if(memberInfo == null){ %>
                <li id="loginBtn"><a href="#">login</a></li>
                <%} else { %>
                <li id="logoutBtn"><a href="Logout">logout</a></li>
                <%} %>
            </ul>
        </nav>
    </header>
<%@ include file="../member/loginForm.jsp" %>
<script>
$(document).ready(function() {
	const memberInfo = <%=memberInfo%>;
    $('#myPage').click(function() {
		if (memberInfo == null){
			alert("로그인이 필요한 서비스입니다.");
        	return false;
        }
    });
    
    
});
</script>
