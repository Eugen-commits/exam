package com.testing.testleague.persistance.repository;

import com.testing.testleague.persistance.entity.Student;
import com.testing.testleague.persistance.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
