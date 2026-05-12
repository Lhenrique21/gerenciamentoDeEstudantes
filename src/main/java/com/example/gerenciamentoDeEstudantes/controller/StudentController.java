package com.example.gerenciamentoDeEstudantes.controller;

import com.example.gerenciamentoDeEstudantes.dto.StudentCreateDto;
import com.example.gerenciamentoDeEstudantes.dto.StudentUpdateDto;
import com.example.gerenciamentoDeEstudantes.entity.Student;
import com.example.gerenciamentoDeEstudantes.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
@Tag(name = "Estudantes", description = "Endpoints para gerenciar estudantes")
public class StudentController {

    private final StudentService studentService;

    @Operation(summary = "Cria estudante", description = "Recebe o DTO para salvar o  estudante")
    @PostMapping("/create")
    public void createStudent(@RequestBody StudentCreateDto studentCreateDto) {
        System.out.println("Criando o estudante" + studentCreateDto);
        studentService.createStudent(studentCreateDto);
    }

    @Operation(summary = "Deleta estudante", description = "Recebe um ID para deletar o estudante ")
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @Operation(summary = "Atualiza estudante", description = "Recebe um ID e um DTO para modificar estudante")
    @PutMapping("/update")
    public void updateStudent(@RequestBody StudentUpdateDto estudanteUpdateDto) {
        studentService.updateStudent(estudanteUpdateDto);
    }

    @Operation(summary = "Lista estudantes", description = "Retorna a lista dos cursos")
    @GetMapping("/list")
    public List<Student> listStudent() {
        return studentService.listStudent();
    }

}
