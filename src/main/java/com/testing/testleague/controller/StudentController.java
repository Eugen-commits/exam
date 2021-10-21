package com.testing.testleague.controller;

import com.testing.testleague.persistance.entity.Student;
import com.testing.testleague.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudent (){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody Student student){
        if (student == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        studentService.createStudent(student);
        return new ResponseEntity<>("Студент создан", HttpStatus.CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity<String> updateStudent(@RequestBody Student student){
        if (student == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        studentService.updateStudent(student);
        return new ResponseEntity<>("Студент успешно обновлен", HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<Student> getStudentById(@RequestBody Student student){
        return new ResponseEntity<>(studentService.getStudentById(student), HttpStatus.FOUND);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteStudent(@RequestBody Student student){
        studentService.deleteStudent(student);
        return new ResponseEntity<>("Удаление прошло успешно", HttpStatus.OK);
    }
}
