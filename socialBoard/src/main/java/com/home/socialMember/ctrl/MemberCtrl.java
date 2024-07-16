package com.home.socialMember.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
}
