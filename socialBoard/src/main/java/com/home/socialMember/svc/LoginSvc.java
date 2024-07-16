package com.home.socialMember.svc;

import com.home.socialMember.dao.*;
import com.home.socialMember.svc.*;
import com.home.socialMember.vo.*;


public class LoginSvc {
	private LoginDao loginDao;

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public MemberInfo getCheckMember(MemberInfo memberInfo) {
		memberInfo = loginDao.getCheckMember(memberInfo);
		
		return memberInfo;
	}
}