package com.home.socialMember.dao;


import java.sql.*;
import javax.sql.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.*;

@Repository
public class IndexDao {

	private JdbcTemplate jdbc;
	
	public IndexDao(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}
    // 데이터베이스 작업 메서드들
}
