package com.home.socialMember.dao;

import java.sql.*;
import javax.sql.*;
import java.util.*;
import org.springframework.jdbc.core.*;
import com.home.socialMember.vo.MemberInfo;

public class MemberDao {
	private JdbcTemplate jtbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jtbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public MemberInfo getMemberInfo(String email, String pwd) {
		String sql = "select * from t_member_info where mi_email = ? and mi_pw = ? ";
		List<MemberInfo> results = jtbcTemplate.query(sql, new RowMapper<MemberInfo>(){
			public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberInfo mi = new MemberInfo();
				mi.setIdx(rs.getInt("idx"));		mi.setMi_email(rs.getString("mi_email"));
				mi.setMi_pw(rs.getString("mi_pw"));		mi.setMi_name(rs.getString("mi_name"));
	            return mi;
			}
		}, email, pwd);
		return results.isEmpty() ? null : results.get(0);
	}
}