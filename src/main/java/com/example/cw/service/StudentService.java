package com.example.cw.service;

import com.example.cw.dao.StudentDao;
import com.example.cw.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDao sd;
    public  void saveStudent(StudentModel sm){
        sd.saveStudent(sm);
    }
    public List<StudentModel> getAllStudent(){
        return sd.getAll();
    }
    public void deleteStudent(Long id){
      sd.deleteStudent(id) ;
    }
    public StudentModel getById(Long id){
       return sd.findById(id);
    }
}
