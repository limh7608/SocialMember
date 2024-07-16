package com.home.socialMember.dao;

import java.sql.*;
import javax.sql.*;
import java.util.*;
import org.springframework.jdbc.core.*;
import com.home.socialMember.vo.MemberInfo;

public class MemberDao {
	private JdbcTemplate jdbc;
	
	public MemberDao(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}
	
	public int checkEmailDuplicate(String email) {
		String sql = "select * from t_member_info where mi_email = ?";
		List<MemberInfo> results = jdbc.query(sql, new RowMapper<MemberInfo>(){
			public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberInfo mi = new MemberInfo();
				mi.setMi_email(email);
				return mi;
			}
		}, email);
		return results.isEmpty() ? 1 : 0;
	}
}