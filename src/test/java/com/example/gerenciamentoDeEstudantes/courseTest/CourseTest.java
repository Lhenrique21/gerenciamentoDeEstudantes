package com.example.gerenciamentoDeEstudantes.courseTest;

import com.example.gerenciamentoDeEstudantes.dto.CourseCreateDto;
import com.example.gerenciamentoDeEstudantes.dto.CourseUpdateDto;
import com.example.gerenciamentoDeEstudantes.entity.Course;

public class CourseTest {

    public static CourseCreateDto courseCreateDto(){
        CourseCreateDto courseCreateDto = new CourseCreateDto();
        courseCreateDto.setName("Teste1");
        courseCreateDto.setDurationCourse(2);

        return courseCreateDto;
    }

    public static Course course(){
        Course course = new Course();
        course.setName("Teste1");
        course.setDurationCourse(2F);

        return course;
    }

    public static CourseUpdateDto courseUpdateDto(){
        CourseUpdateDto courseUpdateDto = new CourseUpdateDto();
        courseUpdateDto.setId(1L);
        courseUpdateDto.setName("Teste2");
        courseUpdateDto.setDurationCourse(3);

        return courseUpdateDto;
    }

}
