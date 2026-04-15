package com.example.gerenciamentoDeEstudantes.controller;

import com.example.gerenciamentoDeEstudantes.dto.StudentCreateDto;
import com.example.gerenciamentoDeEstudantes.dto.StudentUpdateDto;
import com.example.gerenciamentoDeEstudantes.entity.Student;
import com.example.gerenciamentoDeEstudantes.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/create")
    public void createStudent(@RequestBody StudentCreateDto studentCreateDto) {
        studentService.createStudent(studentCreateDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/update")
    public void updateStudent(@RequestBody StudentUpdateDto estudanteUpdateDto) {
        studentService.updateStudent(estudanteUpdateDto);
    }

    @GetMapping("/list")
    public List<Student> listStudent() {
        return studentService.listStudent();
    }

}
