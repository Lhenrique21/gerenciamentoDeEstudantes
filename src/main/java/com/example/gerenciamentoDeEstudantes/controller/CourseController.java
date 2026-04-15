package com.example.gerenciamentoDeEstudantes.controller;

import com.example.gerenciamentoDeEstudantes.dto.CourseCreateDto;
import com.example.gerenciamentoDeEstudantes.dto.CourseUpdateDto;
import com.example.gerenciamentoDeEstudantes.entity.Course;
import com.example.gerenciamentoDeEstudantes.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/create")
    public void createCourse(@RequestBody CourseCreateDto courseCreateDto) {
        courseService.createCourse(courseCreateDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    @PutMapping("/update")
    public void updateCourse(@RequestBody CourseUpdateDto cursoUpdateDto) {
        courseService.updateCourse(cursoUpdateDto);
    }

    @GetMapping("/list")
    public List<Course> listCourse() {
        return courseService.listCourse();
    }
}
