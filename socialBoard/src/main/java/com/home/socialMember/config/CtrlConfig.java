package com.home.socialMember.config;


import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import com.home.socialMember.ctrl.*;
import com.home.socialMember.svc.*;

@Configuration
public class CtrlConfig {
	
	@Autowired
	private IndexSvc indexSvc;

	@Autowired
	private LoginSvc loginSvc;

	@Autowired
	private MemberSvc memberSvc;
	
	@Bean 
	public LoginCtrl loginCtrl() { 
		LoginCtrl loginCtrl = new LoginCtrl(); 
		loginCtrl.setLoginSvc(loginSvc);
  
		return loginCtrl; 
	}
	 
	
	@Bean
	public IndexCtrl IndexCtrl() {
		IndexCtrl indexCtrl = new IndexCtrl();
		indexCtrl.setIndexSvc(indexSvc);
		
		return indexCtrl;
	}
	
	@Bean
	public MemberCtrl memberCtrl() {
		MemberCtrl memberCtrl = new MemberCtrl();
		memberCtrl.setMemberSvc(memberSvc);
		
		return memberCtrl;
	}
}