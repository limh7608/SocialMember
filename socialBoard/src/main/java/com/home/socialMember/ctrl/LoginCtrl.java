package com.home.socialMember.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.home.socialMember.svc.LoginSvc;
import com.home.socialMember.vo.MemberInfo;


@Controller
public class LoginCtrl {
	private LoginSvc loginSvc;
	
	public void setLoginSvc(LoginSvc loginSvc) {
		this.loginSvc = loginSvc;
	}
	
	@GetMapping("/LoginForm")
	public String LoginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		return "login/loginForm";
	}
	
	@PostMapping("/LoginAction")
	public String LoginAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setMi_email(request.getParameter("mi_email"));
		memberInfo.setMi_pw(request.getParameter("mi_pw"));
		
		memberInfo = loginSvc.getCheckMember(memberInfo);
		
		return "/main";
	}
}
