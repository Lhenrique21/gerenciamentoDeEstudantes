package com.example.gerenciamentoDeEstudantes.service;

import com.example.gerenciamentoDeEstudantes.dto.CourseCreateDto;
import com.example.gerenciamentoDeEstudantes.dto.CourseUpdateDto;
import com.example.gerenciamentoDeEstudantes.entity.Course;
import com.example.gerenciamentoDeEstudantes.exception.CourseException;
import com.example.gerenciamentoDeEstudantes.mapper.CourseMapper;
import com.example.gerenciamentoDeEstudantes.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public void createCourse(CourseCreateDto courseCreateDto) {
        try {
            Course courseToSave = CourseMapper.mapCursoToEntityCreate(courseCreateDto);
            courseRepository.save(courseToSave);
        } catch (Exception e) {
            throw new CourseException("Erro ao criar Curso " + e.getMessage());
        }
    }

    public void deleteCourse(Long id) {
        try {
            courseRepository.deleteById(id);
        } catch (Exception e) {
            throw new CourseException("Erro ao deletar curso" + e.getMessage());
        }
    }

    public Course updateCourse(CourseUpdateDto cursoUpdate) {
        try {
            Optional<Course> curso = courseRepository.findById(cursoUpdate.getId());
            if (curso.isPresent()) {
                Course course1 = curso.get();
                course1.setName(cursoUpdate.getName());
                course1.setDurationCourse(cursoUpdate.getDurationCourse());
                return courseRepository.save(course1);
            }
        } catch (Exception e) {
            throw new CourseException("Erro ao atualizar curso" + e.getMessage());
        }
        throw new CourseException("Curso não encontrado");
    }

    public List<Course> listCourse() {
        try {
            return courseRepository.findAll();
        } catch (Exception e) {
            throw new CourseException("Erro ao listar cursos" + e.getMessage());
        }
    }

}

