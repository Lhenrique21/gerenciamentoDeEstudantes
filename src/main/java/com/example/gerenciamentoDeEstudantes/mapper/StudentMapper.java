package com.example.gerenciamentoDeEstudantes.mapper;

import com.example.gerenciamentoDeEstudantes.dto.StudentCreateDto;
import com.example.gerenciamentoDeEstudantes.entity.Student;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StudentMapper {

    public Student mapEstudanteToEntityCreate(StudentCreateDto studentCreateDto){
        Student novoStudent = new Student();
        novoStudent.setName(studentCreateDto.getName());
        novoStudent.setAge(studentCreateDto.getAge());
        novoStudent.setEnrollment(studentCreateDto.getEnrollment());
        novoStudent.setCourse(novoStudent.getCourse());

        return novoStudent;
    }
}
