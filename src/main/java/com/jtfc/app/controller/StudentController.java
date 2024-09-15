package com.jtfc.app.controller;

import com.jtfc.app.model.Student;
import com.jtfc.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

   @Autowired
   StudentService service;

    @PostMapping(value = "/save-student")
    public String saveStudent(@Valid @RequestBody Student student){
        Boolean res = service.saveStudentInfoInDB(student);
        if(res){
            return "Data Successfully Saved";
        }else {
            return "Opps! Data not saved";
        }
    }

    @PostMapping(value = "/save-student-list")
    public String saveStudentList(@RequestBody List<Student> studentList){
        Boolean res = false;
        for (Student student: studentList){
             res = service.saveStudentInfoInDB(student);
        }

        if(res){
            return "Data Successfully Saved";
        }else {
            return "Opps! Data not saved";
        }
    }

    @PutMapping(value = "/update-student")
    public String updateStudent(@RequestBody Student student){
        Boolean res = service.updateStudentInfoInDB(student);
        if(res){
            return "Data Successfully Update";
        }else {
            return "Opps! Data not Update";
        }
    }

    @DeleteMapping(value = "delete-student/{id}")
    public String deleteStudent(@PathVariable("id") Integer id){
        Boolean res = service.deleteStudentInfoInDB(id);
        if(res){
            return "Data Successfully Delete";
        }else {
            return "Opps! Data not Delete";
        }
    }

    @GetMapping(value = "get-student")
    public List<Student> getStudent(){
      /* List<Student> list = new ArrayList<>();

        Student s1 = new Student();
        s1.setStudentId("101");
        s1.setStudentName("Kamal");
        list.add(s1);

        Student s2 = new Student();
        s2.setStudentId("102");
        s2.setStudentName("Jamal");
        list.add(s2);*/

        return service.getStudentInfoInDB();
    }

}

