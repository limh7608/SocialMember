// 모달 요소들 선택
const modal = document.getElementById("loginModal");
const loginBtn = document.getElementById("loginBtn");
const logoutBtn = document.getElementById("logoutBtn");
const span = document.getElementsByClassName("close")[0];

// 로그인 버튼 클릭 시 모달 열기
if (loginBtn) {
    loginBtn.onclick = function() {
        modal.style.display = "block";
    }
}

// 닫기 버튼 클릭 시 모달 닫기
if (span) {
    span.onclick = function() {
        modal.style.display = "none";
    }
}

// 모달 외부 클릭 시 모달 닫기
window.onclick = function(event) {
    if (event.target === modal) {
        modal.style.display = "none";
    }
}

// 로그아웃 버튼 클릭 시 로그아웃 처리
if (logoutBtn) {
    logoutBtn.onclick = function() {
        fetch('/Logout', { method: 'POST' })
            .then(response => {
                if (response.ok) {
                    // 로그아웃 성공 시 페이지 리디렉션
                    location.href = '/'; // 또는 원하는 페이지로
                } else {
                    // 오류 처리
                    console.error('로그아웃 실패');
                }
            })
            .catch(error => {
                console.error('오류 발생:', error);
            });
    };
}
