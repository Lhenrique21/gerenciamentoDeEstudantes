package com.example.gerenciamentoDeEstudantes.mapper;

import com.example.gerenciamentoDeEstudantes.dto.CourseCreateDto;
import com.example.gerenciamentoDeEstudantes.entity.Course;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CourseMapper {

    public Course mapCursoToEntityCreate(CourseCreateDto course){
        Course novoCourse = new Course();
        novoCourse.setName(course.getName());
        novoCourse.setDurationCourse(course.getDurationCourse());

        return novoCourse;
    }
}
