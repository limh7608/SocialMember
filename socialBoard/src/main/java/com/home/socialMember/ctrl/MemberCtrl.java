package com.home.socialMember.ctrl;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.home.socialMember.svc.MemberSvc;
import com.home.socialMember.vo.MemberInfo;

@Controller
public class MemberCtrl {

	private MemberSvc memberSvc;
	
	public void setMemberSvc(MemberSvc memberSvc) {
		this.memberSvc = memberSvc;
	}
	@GetMapping("/JoinForm")
	public String JoinForm () {
		
		return "member/joinForm";
	}
	
	@PostMapping("/EmailCheckDuplicate")
    public ResponseEntity<Map<String, Integer>> emailCheckDuplicate(@RequestParam("mi_email") String email) {
        int result = memberSvc.checkEmailDuplicate(email);
        Map<String, Integer> response = new HashMap<>();
        response.put("result", result);
        return ResponseEntity.ok(response);
    }
	@PostMapping("/JoinAction")
	public String JoinAction (HttpServletRequest request, HttpServletResponse response) throws Exception{
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setMi_email(request.getParameter("mi_email"));
		memberInfo.setMi_pw(request.getParameter("mi_pw"));
		memberInfo.setMi_name(request.getParameter("mi_name"));
		memberInfo.setMi_birth(request.getParameter("mi_birth"));
		memberInfo.setMi_gender(request.getParameter("mi_gender"));
		
		int result = memberSvc.memberRegistration(memberInfo);
		
		if (result == 1) {
		    response.setContentType("text/html; charset=utf-8");
		    PrintWriter out = response.getWriter();
		    out.println("<script>");
		    out.println("alert('정상 가입되었습니다!!.');");
		    out.println("location.href='/socialBoard/';");  // alert 후에 로그인 폼으로 리다이렉션
		    out.println("</script>");
		    out.close();
		    return null;  // 클라이언트 측에서 리다이렉션을 수행하므로 서버 측에서는 더 이상 경로를 반환하지 않음
		} else {
		    return "redirect:/member/joinForm";
		}
	}
	@GetMapping("/MyPage")
	public String MyPage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		return "member/myPage";
	}
	
	
	
}
