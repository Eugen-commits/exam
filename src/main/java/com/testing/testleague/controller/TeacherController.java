package com.testing.testleague.controller;

import com.testing.testleague.persistance.entity.Student;
import com.testing.testleague.persistance.entity.Teacher;
import com.testing.testleague.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/all")
    public ResponseEntity<List<Teacher>> getAllStudent (){
        return new ResponseEntity<>(teacherService.getAllTeacher(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createTeacher(@RequestBody Teacher teacher){
        if (teacher == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        teacherService.createTeacher(teacher);
        return new ResponseEntity<>("Учитель создан", HttpStatus.CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity<String> updateTeacher(@RequestBody Teacher teacher){
        if (teacher == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        teacherService.updateTeacher(teacher);
        return new ResponseEntity<>("Учитель успешно обновлен", HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<Teacher> getTeacherById(@RequestBody Teacher teacher){
       return new ResponseEntity<>(teacherService.getTeacherById(teacher), HttpStatus.FOUND);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteTeacher(@RequestBody Teacher teacher){
        teacherService.deleteTeacher(teacher);
        return new ResponseEntity<>("Удаление прошло успешно", HttpStatus.OK);
    }
}
