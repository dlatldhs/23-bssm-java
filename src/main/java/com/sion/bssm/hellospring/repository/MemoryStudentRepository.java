package com.sion.bssm.hellospring.repository;

import com.sion.bssm.hellospring.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryStudentRepository implements StudentRepository{
    private static Map<Long, Student> store = new HashMap<>();

    @Override
    public Student save(Student student) {
        store.put(student.getId(),student); // db save
//        return student;
        return store.get(student.getId());
    }

    @Override
    public Student findById(Long id) {
        Student ret = store.get(id);
        return ret;
    }

    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>(store.values());
        return list;
    }
}
