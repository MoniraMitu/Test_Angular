package com.example.cw.dao;

import com.example.cw.model.StudentModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<StudentModel> {
    @Override
    public StudentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
       StudentModel sm= new StudentModel();
       sm.setId(rs.getLong("id"));
       sm.setName(rs.getString("name"));
        sm.setSubject(rs.getString("subject"));
       sm.setGender(rs.getString("gender"));
       sm.setDob(rs.getDate("dob").toLocalDate());
       return sm;
    }
}
