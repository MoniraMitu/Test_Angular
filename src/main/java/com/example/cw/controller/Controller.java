package com.example.cw.controller;

import com.example.cw.model.StudentModel;
import com.example.cw.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping
public class Controller {
    @Autowired
    private StudentService ss;


    @PostMapping("addStu")
    public  String  addStudent(@ModelAttribute StudentModel sm){
        ss.saveStudent(sm);
        return  "redirect:/";
    }

    @GetMapping
    public String getAllStudent(Model model){
        List<StudentModel> stu= ss.getAllStudent();
        model.addAttribute("allStudent",stu);
        return "index";
    }
    @GetMapping("addStudent")
    public  String addStudentForm(Model model) {
        model.addAttribute("sm", new StudentModel());
        return "addStudent";
    }

        @GetMapping("edit/{studentId}")
                public  String editStudent(@PathVariable("studentId") Long id,Model model){
            model.addAttribute("sm",ss.getById(id));
            return "addStudent";
        }

        @GetMapping("delete/{studentId}")
    public  String deleteStudent(@PathVariable("studentId") Long id){
        ss.deleteStudent(id);
        return "redirect:/";
        }
    }


