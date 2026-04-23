package com.example.gerenciamentoDeEstudantes.controller;

import com.example.gerenciamentoDeEstudantes.dto.CourseCreateDto;
import com.example.gerenciamentoDeEstudantes.dto.CourseUpdateDto;
import com.example.gerenciamentoDeEstudantes.entity.Course;
import com.example.gerenciamentoDeEstudantes.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Cursos", description = "Endpoints para gerenciamento de cursos")
public class CourseController {

    private final CourseService courseService;

    @Operation(summary = "Cria um curso", description = "Recebo o DTO para salvar o curso")
    @PostMapping("/create")
    public void createCourse(@RequestBody CourseCreateDto courseCreateDto) {
        courseService.createCourse(courseCreateDto);
    }

    @Operation(summary = "Deleta curso", description = "Recebe um ID para deletar o curso")
    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    @Operation(summary = "Atualiza curso", description = "Recebe um ID e um DTO para modificar o curso")
    @PutMapping("/update")
    public void updateCourse(@RequestBody CourseUpdateDto cursoUpdateDto) {
        courseService.updateCourse(cursoUpdateDto);
    }

    @Operation(summary = "Lista cursos", description = "Retorna a lista dos cursos")
    @GetMapping("/list")
    public List<Course> listCourse() {
        return courseService.listCourse();
    }
}
