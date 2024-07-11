package com.home.socialMember.config;

import static com.home.socialMember.config.DbConfig.*;
import org.apache.tomcat.jdbc.pool.*;
import org.springframework.context.annotation.*;
import com.home.socialMember.dao.*;
import com.home.socialMember.svc.*;

@Configuration
public class IndexConfig {
	
	@Bean
	public IndexDao indexDao() {
		return new IndexDao(dataSource());
	}
	
	@Bean
	public IndexSvc indexSvc() {
		IndexSvc indexSvc = new IndexSvc();
		indexSvc.setIndexDao(indexDao());
		return indexSvc;
	}
}
