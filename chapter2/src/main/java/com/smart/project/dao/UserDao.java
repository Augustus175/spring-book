package com.smart.project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author zhangzhibo-linux
 * @date 18-7-15 下午2:55
 */
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getMatchCount(String userName, String password) {
        String sqlString = "SELECT count(*) FROM t_user " + "WHERE user_name =? and password=?";
//        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[]{userName, password}, Integer.class);
        return jdbcTemplate.queryForObject(sqlString, new Object[]{userName, password}, Integer.class);
    }
}
