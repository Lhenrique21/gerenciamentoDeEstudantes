package com.example.gerenciamentoDeEstudantes.dto;

import com.example.gerenciamentoDeEstudantes.entity.Course;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StudentCreateDto {

    private String name;
    private int enrollment;
    private Course course;
    private int age;
}
