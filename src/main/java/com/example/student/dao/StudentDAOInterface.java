package com.example.student.dao;

import com.example.student.entities.Student;

import java.util.List;

public interface StudentDAOInterface {
    List<Student> findAll();

    Student findById(Long id);

    Student findByName(String name);

    List<Student> findByMark(Integer mark);

    Student save(Student student);

    void deleteById(Long id);

    Integer countStudents();


}
