    $(document).ready(function() {
        const $yearSelect = $('#year');
        const $monthSelect = $('#month');
        const $daySelect = $('#day');

        // 현재 날짜 가져오기
        const today = new Date();
        const currentYear = today.getFullYear();

        // 년도 옵션 추가 (1800년부터 현재년도까지)
        for (let year = 1800; year <= currentYear; year++) {
            $yearSelect.append(new Option(year, year));
        }

        // 월 옵션 추가 (1월부터 12월까지)
        for (let month = 1; month <= 12; month++) {
            $monthSelect.append(new Option(month, month));
        }

        // 일 업데이트 함수
        function updateDays() {
            const selectedYear = parseInt($yearSelect.val());
            const selectedMonth = parseInt($monthSelect.val());
            const daysInMonth = new Date(selectedYear, selectedMonth, 0).getDate();
            
            // 일 선택 박스 초기화
            $daySelect.empty();
            
            for (let day = 1; day <= daysInMonth; day++) {
                $daySelect.append(new Option(day, day));
            }
        }

        // 월 또는 년도 선택 시 일 업데이트
        $yearSelect.change(updateDays);
        $monthSelect.change(updateDays);

        // 페이지 로드 시 초기 일 설정
        updateDays();
    	
    	
    	
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
        
        // 비밀번호 확인 검사
        $('#CheckPw').on('input', function() {
            var password = $('#mi_pw').val();
            var confirmPassword = $('#CheckPw').val();

   	        if (password !== confirmPassword) {
   	            $('#checkPwResult').text('비밀번호가 일치하지 않습니다.').css('color', 'red');
   	        } else {
   	            $('#checkPwResult').text('비밀번호가 일치합니다.').css('color', 'green');
   	        }
       	});
        
        $('#mi_phone').on('input', function() {
            var phone = $('#mi_phone').val().replace(/[^0-9]/g, ''); // 숫자 외 문자 제거
            var phonePattern = /^01[0|1|6|7|8|9][0-9]{7,8}$/; // 한국 휴대전화번호 형식 정규식

            if (phone.length > 3 && phone.length <= 7) {
                phone = phone.replace(/(\d{3})(\d{1,4})/, '$1-$2');
            } else if (phone.length > 7) {
                phone = phone.replace(/(\d{3})(\d{4})(\d{1,4})/, '$1-$2-$3');
            }

            $('#mi_phone').val(phone);

            if (!phonePattern.test(phone.replace(/-/g, ''))) {
                $('#phoneResult').text('유효하지 않은 휴대전화번호 형식입니다.').css('color', 'red');
            } else {
                $('#phoneResult').text('유효한 휴대전화번호 형식입니다.').css('color', 'green');
            }
        });
        
    });