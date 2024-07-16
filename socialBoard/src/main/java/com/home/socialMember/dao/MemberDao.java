package com.home.socialMember.dao;

import java.sql.*;
import javax.sql.*;
import java.util.*;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import com.home.socialMember.vo.MemberInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class MemberDao {
	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
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

	public int memberRegistration(MemberInfo mi) {
        String sql = "insert into t_member_info (mi_email, mi_pw, mi_name, mi_birth, mi_phone, mi_gender, mi_status) values (?, ?, ?, ?, ?, ?, ?)";
        int result = 0;

        try {
            result = jdbc.update(sql, mi.getMi_email(), mi.getMi_pw(), mi.getMi_name(), mi.getMi_birth(), mi.getMi_phone(), mi.getMi_gender(), mi.getMi_status());
        } catch (DataAccessException e) {
            logger.error("Database error during member registration", e);
            // 예외가 발생했을 때 0을 반환하거나, 상황에 맞게 다른 값을 반환할 수 있습니다.
            // 예를 들어, -1을 반환하여 호출자가 실패를 인식하게 할 수도 있습니다.
            result = -1;
        }

        return result;
    }
	
	
}