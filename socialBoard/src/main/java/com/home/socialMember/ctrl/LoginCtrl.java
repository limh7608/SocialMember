package com.home.socialMember.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		// login이 되어있을 때는 못들어오게 해야 됨 어디서 작업?
		HttpSession session = request.getSession();
		MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");
		
		if (memberInfo == null) {
			return "login/loginForm";
		}
		
		return "";
	}
	
	@PostMapping("/LoginAction")
	public String LoginAction(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		MemberInfo memberInfo = new MemberInfo();
		
		memberInfo.setMi_email(request.getParameter("mi_email"));
		memberInfo.setMi_pw(request.getParameter("mi_pw"));
		
		memberInfo = loginSvc.getCheckMember(memberInfo);
		
		if(memberInfo != null) {
		model.addAttribute("memberInfo", memberInfo);
		return "/main";
		}
		
		return "login/loginForm";
	}
}
