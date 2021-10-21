package com.testing.testleague.persistance.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty("Id студента")
    private Long id;

    @Column(nullable = false)
    @ApiModelProperty("Имя студента")
    private String name;

    @ApiModelProperty("Фамилия студента")
    @Column(nullable = false)
    private String middleName;

    @ApiModelProperty("Отчество студента")
    @Column(nullable = false)
    private String lastname;

    @ApiModelProperty("Спеуиальность студента")
    @Column(nullable = false)
    private String speciality;

    @ApiModelProperty("Курс")
    private Integer cours;

    @ApiModelProperty("Учитель студента")
    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_teacher",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn (name = "teacher_id")}
    )
    private List<Teacher> teacher;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", speciality='" + speciality + '\'' +
                ", cours=" + cours +
                ", teacher=" + teacher +
                '}';
    }
}
