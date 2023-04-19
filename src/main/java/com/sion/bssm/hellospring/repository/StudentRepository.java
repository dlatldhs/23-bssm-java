package com.sion.bssm.hellospring.repository;

import com.sion.bssm.hellospring.domain.Student;

import java.util.List;

public interface StudentRepository {
    Student save(Student student);
    Student findById(Long id);

    List<Student> findAll();
//    findAll
}
