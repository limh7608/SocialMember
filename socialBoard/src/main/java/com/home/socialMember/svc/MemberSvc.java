package com.home.socialMember.svc;


import com.home.socialMember.dao.*;
import com.home.socialMember.vo.*;

public class MemberSvc {
	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}

