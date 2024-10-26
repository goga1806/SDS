package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student addStudent(Student student);

    Student updateStudent(String id, Student student);

    void deleteStudent(String id);
}
