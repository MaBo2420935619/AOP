package com.mabo.transaction;

import org.springframework.jdbc.core.JdbcTemplate;

public class UsersDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(String name, Integer age) {
        String sql="INSERT INTO users(name, age) VALUES(?, ?);";
        jdbcTemplate.update(sql, name,age);
        System.out.println("添加数据"+name+"成功!.......");
    }
}
