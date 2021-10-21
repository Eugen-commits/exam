package com.testing.testleague.service;

import com.testing.testleague.persistance.entity.Teacher;
import com.testing.testleague.persistance.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
public class TeacherService {
    @Autowired
    private TeacherRepository repository;

    public void createTeacher (Teacher teacher){
        if (teacher == null) throw new RuntimeException("Преподаватель не передан");
        log.info(teacher.toString());
        repository.save(teacher);
    }

    public List<Teacher> getAllTeacher(){
        ArrayList<Teacher> allTeacher = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(allTeacher::add);
        return allTeacher;
    }

    public Teacher getTeacherById(Teacher teacher){
        Long teacherId = teacher.getId();
        return repository.findById(teacherId).orElseThrow(RuntimeException::new);
    }

    public void deleteTeacher(Teacher teacher){
        Long teacherId = teacher.getId();
        repository.deleteById(teacherId);
    }
    public void updateTeacher(Teacher teacher){
        repository.save(teacher);
    }
}
