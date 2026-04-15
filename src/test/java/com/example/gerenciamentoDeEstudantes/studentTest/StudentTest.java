package com.example.gerenciamentoDeEstudantes.studentTest;

import com.example.gerenciamentoDeEstudantes.dto.StudentCreateDto;
import com.example.gerenciamentoDeEstudantes.dto.StudentUpdateDto;
import com.example.gerenciamentoDeEstudantes.entity.Course;
import com.example.gerenciamentoDeEstudantes.entity.Student;

public class StudentTest {

    public static StudentCreateDto studentDto() {
        StudentCreateDto studentCreateDto = new StudentCreateDto();
        Course course = new Course();
        studentCreateDto.setCourse(course);
        studentCreateDto.setName("Teste1");
        studentCreateDto.setAge(1);
        studentCreateDto.setEnrollment(111);

        return studentCreateDto;
    }

    public static Student student() {
        Student student = new Student();
        Course course = new Course();
        student.setCourse(course);
        student.setName("Teste2");
        student.setAge(2);
        student.setEnrollment(222);

        return student;
    }

    public static StudentUpdateDto studentUpdateDto() {
        StudentUpdateDto studentUpdateDto = new StudentUpdateDto();
        Course course = new Course();
        studentUpdateDto.setId(1L);
        studentUpdateDto.setName("Teste3");
        studentUpdateDto.setCourse(course);
        studentUpdateDto.setEnrollment(333);
        studentUpdateDto.setAge(3);

        return studentUpdateDto;
    }
}
