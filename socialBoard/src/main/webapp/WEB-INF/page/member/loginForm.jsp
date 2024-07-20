<%@page import="com.home.socialMember.vo.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>socialBoard</title>
<link rel="stylesheet" href="resources/css/loginModal.css">
</head>
<body>
    
    <div id="loginModal" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <div class="login-wrapper">
                <h2>Login</h2>
                <form method="post" action="LoginAction" id="login-form">
                    <input type="text" name="mi_email" placeholder="Email">
                    <input type="password" name="mi_pw" placeholder="Password">
                    <label for="remember-check">
                        <input type="checkbox" id="remember-check">아이디 저장하기
                    </label>
                    <label>
                        <a href="JoinForm" style="color: black; text-decoration: none;">회원가입</a>
                    </label>
                    <input style="cursor: pointer;" type="submit" value="Login">
                </form>
            </div>
        </div>
    </div>

<script src="resources/js/loginModal.js"></script>
</body>
</html>
