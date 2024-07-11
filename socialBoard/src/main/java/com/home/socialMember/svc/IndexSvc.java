package com.home.socialMember.svc;
import java.util.List;

import org.springframework.stereotype.Service;

import com.home.socialMember.dao.*;
import com.home.socialMember.vo.*;


public class IndexSvc {
	private IndexDao indexDao;

	public void setIndexDao(IndexDao indexDao) {
		this.indexDao = indexDao;
	}	
}