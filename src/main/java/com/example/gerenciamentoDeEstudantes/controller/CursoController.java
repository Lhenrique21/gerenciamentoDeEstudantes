package com.example.gerenciamentoDeEstudantes.controller;

import com.example.gerenciamentoDeEstudantes.dto.CursoDto;
import com.example.gerenciamentoDeEstudantes.dto.CursoUpdateDto;
import com.example.gerenciamentoDeEstudantes.entity.Curso;
import com.example.gerenciamentoDeEstudantes.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/curso")
public class CursoController {

    private final CursoService cursoService;

    @PostMapping("/criar")
    public void criarCurso(@RequestBody CursoDto cursoDto) {
        cursoService.criarCurso(cursoDto);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarCurso(@PathVariable Long id) {
        cursoService.deletarCurso(id);
    }

    @PutMapping("/atualizar")
    public void atualizarCurso(@RequestBody CursoUpdateDto cursoUpdateDto) {
        cursoService.atualizarCurso(cursoUpdateDto);
    }

    @GetMapping("/listar")
    public List<Curso> listarCursos() {
        return cursoService.cursoList();
    }
}
