package com.home.socialMember.ctrl;

import java.io.PrintWriter;

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
		
		return "member/loginForm";
	}
	
	@PostMapping("/LoginAction")
	public String LoginAction(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		MemberInfo memberInfo = new MemberInfo();
		
		
		memberInfo.setMi_email(request.getParameter("mi_email"));
		memberInfo.setMi_pw(request.getParameter("mi_pw"));
		
		memberInfo = loginSvc.getCheckMember(memberInfo);
		HttpSession session = request.getSession();
		
		if(memberInfo == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('아이디와 비밀번호가 틀렸습니다.')");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		} 
		
		session.setAttribute("memberInfo", memberInfo);
		model.addAttribute("memberInfo", memberInfo);
		
		return "/index";
	}
	
	@RequestMapping("/Logout")
	public String Logout (HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
}
