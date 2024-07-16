<%@page import="com.home.socialMember.vo.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
#emailCheck{
	width: 20%;
    height: 48px;
    background-color: #6A24FE;
    border-radius: 5px;
    color: #fff;
}
.mi_email{
	width: 80%;
    height: 48px;
    box-sizing: border-box;
    margin-bottom: 16px;
    border-radius: 6px;
    background-color: #F8F8F8;
}

</style>
<body>
    <div class="join-wrapper">
        <h2>회원가입</h2>
        <form method="post" action="JoinAction" id="join-form">
        	<div><input type="text" class="mi_email" name="mi_email" placeholder="Email" /><button type="button" id="emailCheck">중복체크</button></div>  
            <div id="result"></div>
            비밀번호
            <input type="password" name="mi_pw" placeholder="Password">
            비밀번호 확인
            <input type="password" name="CheckPw" placeholder="Password">
            <input type="text" name="mi_name" placeholder="이름">
            <input type="date" name="mi_birth" id="date" min="1900-01-01">	
            <input type="text" name="mi_phone" placeholder="휴대폰 번호">
            <div>
            <input type="radio" name="mi_gender" value="male" />남자
            <input type="radio" name="mi_gender" value="female" />여자    
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
	
	
    $(document).ready(function() {
        $('#emailCheck').click(function() {
            var email = $('.mi_email').val(); // 이메일 입력값 가져오기
            var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/; // 이메일 형식 정규식

            if (!emailPattern.test(email)) {
                $('#result').text('유효하지 않은 이메일 형식입니다.').css('color', 'red');
                return; // 이메일 형식이 유효하지 않으면 AJAX 요청을 보내지 않음
            }
            $.ajax({
                url: './EmailCheckDuplicate', // 요청을 보낼 URL
                type: 'POST', // 요청 방법
                data: { "mi_email": email }, // 서버로 전송할 데이터
                dataType: 'json', // 서버에서 반환되는 데이터 형식
                success: function(response) {
                    // 요청이 성공했을 때 실행할 코드
                    if (response.result === 1) {
                        $('#result').text('이메일이 유효합니다.').css('color', 'blue');
                    } else {
                        $('#result').text('이메일이 유효하지 않습니다.').css('color', 'red');
                    }
                },
                error: function(xhr, status, error) {
                    // 요청이 실패했을 때 실행할 코드
                    $('#result').text('오류가 발생했습니다.');
                    console.error(error);
                }
            });
        });
    });

	
</script>
</html>