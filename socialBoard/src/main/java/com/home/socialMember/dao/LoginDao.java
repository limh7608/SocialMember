package com.home.socialMember.dao;

import java.sql.*;
import javax.sql.*;
import java.util.*;
import org.springframework.jdbc.core.*;
import com.home.socialMember.vo.MemberInfo;

public class LoginDao {
	private JdbcTemplate jtbcTemplate;
	
	public LoginDao(DataSource dataSource) {
		this.jtbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public MemberInfo getLoginInfo(String email, String pwd) {
		String sql = "select * from t_member_info where ai_id = ? and ai_pw = ? ";
		List<MemberInfo> results = jtbcTemplate.query(sql, new RowMapper<MemberInfo>(){
			public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberInfo mi = new MemberInfo();
				mi.setIdx(rs.getInt("mi_idx"));		mi.setMi_email(rs.getString("mi_email"));
				mi.setMi_pw(rs.getString("pwd"));		mi.setMi_name(rs.getString("mi_name"));
	            return mi;
			}
		}, email, pwd);
		return results.isEmpty() ? null : results.get(0);
	}
}