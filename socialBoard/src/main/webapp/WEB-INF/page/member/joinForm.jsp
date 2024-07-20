<%@page import="com.home.socialMember.vo.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../page/_inc/inc_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<link rel="stylesheet" href="resources/css/joinForm.css">
<body>
    <div class="join-wrapper">
        <h2>회원가입</h2>
        <form method="post" action="JoinAction" id="join-form">
        	<div><input type="text" class="mi_email" name="mi_email" placeholder="Email" /><button type="button" id="emailCheck">중복체크</button></div>  
            <div id="result"></div>
            비밀번호
            <input type="password" name="mi_pw" id="mi_pw" placeholder="Password">
            비밀번호 확인
            <input type="password" name="CheckPw" id="CheckPw" placeholder="Password">
            <div id="checkPwResult"></div>
            <input type="text" name="mi_name" placeholder="이름">
            <!-- 생일 선택 부분 -->
            <div>
                <select id="year" name="mi_birth_year"></select>
                <label for="year"> 년도</label>
                
                <select id="month" name="mi_birth_month"></select>
                <label for="month"> 월</label>
                
                <select id="day" name="mi_birth_day"></select>
                <label for="day"> 일</label>
            </div>
            <input type="text" name="mi_phone" id="mi_phone" placeholder="휴대폰 번호">
            <div id="phoneResult"></div>
            <div>
            <input type="radio" name="mi_gender" value="male" />남자
            <input type="radio" name="mi_gender" value="female" />여자    
            </div>
            <input type="submit" value="join">
        </form>
    </div>
<script src="resources/js/joinForm.js"></script>
<%@ include file="../../page/_inc/inc_footer.jsp" %>