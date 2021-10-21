package com.testing.testleague.service;

import com.testing.testleague.persistance.entity.Student;
import com.testing.testleague.persistance.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public void createStudent(Student student){
        if (student == null) throw new RuntimeException("Студент не передан");
        log.info(student.toString(), " Student to save");
        repository.save(student);
    }

    public Student getStudentById(Student student){
        Long studentId = student.getId();
        return repository.findById(studentId).orElseThrow(RuntimeException::new);
    }

    public List<Student> getAllStudents(){
        ArrayList<Student> allStudent = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(allStudent::add);
        log.info(allStudent.toString());
        return allStudent;
    }

    public void deleteStudent(Student student){
        Long studentId = student.getId();
        repository.deleteById(studentId);
    }

    public void updateStudent(Student student){
        repository.save(student);
    }
}
