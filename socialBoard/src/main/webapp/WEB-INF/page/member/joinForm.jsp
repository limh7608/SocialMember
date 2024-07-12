<%@page import="com.home.socialMember.vo.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
*{
    padding: 0;
    margin: 0;
    border: none;
}
body{
    font-size: 14px;
    font-family: 'Roboto', sans-serif;
    width: 100%; display: flex; flex-flow: column; align-items: center; margin-top: 3em;
}
.join-wrapper{
    width: 400px;
    height: 350px;
    padding: 40px;
    box-sizing: border-box;
}

.join-wrapper > h2{
    font-size: 24px;
    color: #6A24FE;
    margin-bottom: 20px;
}
#join-form > input{
    width: 100%;
    height: 48px;
    padding: 0 10px;
    box-sizing: border-box;
    margin-bottom: 16px;
    border-radius: 6px;
    background-color: #F8F8F8;
}
#join-form > input::placeholder{
    color: #D2D2D2;
}
#join-form > input[type="submit"]{
    color: #fff;
    font-size: 16px;
    background-color: #6A24FE;
    margin-top: 20px;
}
#join-form > input[type="checkbox"]{
    display: none;
}
#join-form > label{
    color: #999999;
}
#join-form input[type="checkbox"] + label{
    cursor: pointer;
    padding-left: 26px;
    background-image: url("checkbox.png");
    background-repeat: no-repeat;
    background-size: contain;
}
#join-form input[type="checkbox"]:checked + label{
    background-image: url("checkbox-active.png");
    background-repeat: no-repeat;
    background-size: contain;
}
</style>
<body>
    <div class="join-wrapper">
        <h2>join</h2>
        <form method="post" action="JoinAction" id="join-form">
            <input type="text" name="mi_email" placeholder="Email"><input type="button" id="emailCheck">이메일 중복체크
            <input type="password" name="mi_pw" placeholder="Password">
            <input type="password" name="CheckPw" placeholder="Password">
            <input type="text" name="mi_name" placeholder="이름">
            <input type="date" name="mi_birth" id="date" min="1900-01-01">	
            <input type="text" name="mi_phone" placeholder="휴대폰 번호">
            <div>
            <input type="radio" name="mi_gender" value="male" placeholder="남자">
            <input type="radio" name="mi_gender" value="female" placeholder="여자">    
            </div>
            <input type="submit" value="join">
        </form>
    </div>
</body>
<script>
	
	document.addEventListener('DOMContentLoaded', (event) => {
	    const dateControl = document.querySelector('input[type="date"]');
	    const today = new Date();
	    const year = today.getFullYear();
	    const month = String(today.getMonth() + 1).padStart(2, '0');
	    const day = String(today.getDate()).padStart(2, '0');
	    const todayString = `${year}-${month}-${day}`;
	
	    // 설정된 max 속성을 오늘 날짜로 변경
	    dateControl.max = todayString;
	
	    // 디폴트값을 오늘 날짜로 설정
	    dateControl.value = todayString;
	
	    // 사용자가 날짜를 선택한 후에도 값을 유지
	    dateControl.addEventListener('change', (event) => {
	        console.log(dateControl.value); // 선택된 날짜
	        console.log(dateControl.valueAsNumber); // JavaScript 타임스탬프 (밀리초)
    	});
	});
	
</script>
</html>