package com.example.gerenciamentoDeEstudantes.service;

import com.example.gerenciamentoDeEstudantes.dto.StudentCreateDto;
import com.example.gerenciamentoDeEstudantes.dto.StudentUpdateDto;
import com.example.gerenciamentoDeEstudantes.entity.Course;
import com.example.gerenciamentoDeEstudantes.entity.Student;
import com.example.gerenciamentoDeEstudantes.exception.StudentException;
import com.example.gerenciamentoDeEstudantes.mapper.StudentMapper;
import com.example.gerenciamentoDeEstudantes.repository.CourseRepository;
import com.example.gerenciamentoDeEstudantes.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public void createStudent(StudentCreateDto studentCreateDto) {
        try {
            Course course = courseRepository.findById(studentCreateDto.getCourseId()).orElseThrow(() -> new RuntimeException("Curso não encontrado"));
            Student studentToSave = StudentMapper.mapEstudanteToEntityCreate(studentCreateDto);
            studentToSave.setCourse(course);
            studentRepository.save(studentToSave);
        } catch (Exception e) {
            throw new StudentException("Erro ao criar estudante " + e.getMessage());
        }
    }

    public void deleteStudent(Long id) {
        try {
            studentRepository.deleteById(id);
        } catch (Exception e) {
            throw new StudentException("Erro ao deletar estudante " + e.getMessage());
        }
    }

    public Student updateStudent(StudentUpdateDto estudanteUpdateDto) {
        try {
            Optional<Student> estudante = studentRepository.findById(estudanteUpdateDto.getId());
            if (estudante.isPresent()) {
                Course course = courseRepository.findById(estudanteUpdateDto.getCourseId()).orElseThrow(() -> new RuntimeException("Erro ao encontrar curso"));
                Student student1 = estudante.get();
                student1.setName(estudanteUpdateDto.getName());
                student1.setEnrollment(estudanteUpdateDto.getEnrollment());
                student1.setCourse(course);
                student1.setAge(estudanteUpdateDto.getAge());
                return studentRepository.save(student1);
            }
        } catch (Exception e) {
            throw new StudentException("Erro ao atualizar estudante " + e.getMessage());
        }
        throw new StudentException(("Id do estudante não encontrado"));
    }

    public List<Student> listStudent() {
        try {
            return studentRepository.findAll();
        } catch (Exception e) {
            throw new StudentException("Erro ao listar estudantes " + e.getMessage());
        }
    }
}
