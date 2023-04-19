package com.sion.bssm.hellospring.service;

import com.sion.bssm.hellospring.domain.Student;
import com.sion.bssm.hellospring.repository.MemoryStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final MemoryStudentRepository repository;
    @Autowired
    public StudentService(MemoryStudentRepository repository) {
        this.repository = repository;
    }
    public Long edit(Student student) {
        // 학번 중복 check
        validateDuplicateStudent(student);
        // 학생 등록
        Student ret = repository.save(student);
        System.out.println(ret.getId());
        return ret.getId();
    }

    private void validateDuplicateStudent(Student student) {
        // 중복 체크
        if (repository.findById(student.getId()) != null) {
            throw new IllegalStateException("이미 존재하는 학번입니다...");
        }


    }

    public List<Student> findStudents() {
        return repository.findAll();
    }
}
