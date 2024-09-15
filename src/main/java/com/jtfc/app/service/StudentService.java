package com.jtfc.app.service;

import com.jtfc.app.model.Student;

import java.util.List;

public interface StudentService {
    boolean saveStudentInfoInDB(Student student);
    boolean updateStudentInfoInDB(Student student);
    boolean deleteStudentInfoInDB( Integer id);
    List<Student> getStudentInfoInDB();
}
