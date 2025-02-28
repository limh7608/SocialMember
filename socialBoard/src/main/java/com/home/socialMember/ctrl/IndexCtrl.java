package com.home.socialMember.ctrl;

import com.home.socialMember.svc.*;
import com.home.socialMember.vo.*;
import java.util.*;
import java.io.*;
import java.net.*;
import javax.servlet.http.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexCtrl {
	private IndexSvc indexSvc;
	
	public void setIndexSvc(IndexSvc indexSvc) {
		this.indexSvc = indexSvc;
	}
	@GetMapping("/")
	public String index (HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberInfo memberInfo = (MemberInfo)request.getAttribute("memberInfo");
		
		return "/main";
	}

}
