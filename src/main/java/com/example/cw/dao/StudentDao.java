package com.example.cw.dao;

import com.example.cw.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDao {
    private final JdbcTemplate jdbcTemplate;
   @Autowired
    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private  final String Get_All_Student="select * from StudentTable";
    private  final String Insert_Student="insert into StudentTable (name,subject,gender,dob) values (?,?,?,?)";
    private  final String Find_All_Student="select * from StudentTable where id=?";
    private  final String Delete_Student="delete  from StudentTable where id=?";
    private  final String Update_Student="update StudentTable set name =?,subject=?, gender =? ,dob=? where id =?";


    public List<StudentModel>getAll(){
        return jdbcTemplate.query(Get_All_Student,new StudentMapper());
    }
    public StudentModel findById(Long id){
        return  jdbcTemplate.queryForObject(Find_All_Student, new Object[]{id},new StudentMapper());
    }
    public boolean saveStudent(StudentModel sm){
        if (sm.getId()== null) {
           return  jdbcTemplate.update(Insert_Student,sm.getName(),sm.getSubject(),sm.getGender(),sm.getDob()) >0;
        }else {
         return jdbcTemplate.update(Update_Student,sm.getName(),sm.getSubject(),sm.getGender(),sm.getDob(),sm.getId())>0;
        }
    }
    public  boolean deleteStudent(Long id){

        return  jdbcTemplate.update(Delete_Student,id)>0;
    }
}
