package com.testing.testleague.persistance.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty("ИД учителя")
    private Long id;
    @Column(nullable = false)
    @ApiModelProperty("Имя учителя")
    private String name;

    @ApiModelProperty("Фамилия учителя")
    @Column(nullable = false)
    private String middleName;

    @ApiModelProperty("Отчество учителя")
    @Column(nullable = false)
    private String lastname;

    @ApiModelProperty("Кафедра учителя")
    @Column(nullable = false)
    private String chair;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", chair='" + chair + '\'' +
                '}';
    }
}
