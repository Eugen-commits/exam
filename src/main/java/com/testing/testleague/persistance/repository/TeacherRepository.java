package com.testing.testleague.persistance.repository;

import com.testing.testleague.persistance.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
