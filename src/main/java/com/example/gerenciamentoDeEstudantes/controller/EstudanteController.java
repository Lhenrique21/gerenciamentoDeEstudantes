package com.example.gerenciamentoDeEstudantes.controller;

import com.example.gerenciamentoDeEstudantes.dto.EstudanteDto;
import com.example.gerenciamentoDeEstudantes.dto.EstudanteUpdateDto;
import com.example.gerenciamentoDeEstudantes.entity.Estudante;
import com.example.gerenciamentoDeEstudantes.service.EstudanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/estudante")
public class EstudanteController {

    private final EstudanteService estudanteService;

    @PostMapping("/criar")
    public void criarEstudantes(@RequestBody EstudanteDto estudanteDto) {
        estudanteService.criarEstudante(estudanteDto);
    }

    @DeleteMapping("/deletar/{id}")
    public void excluirEstudantes(@PathVariable Long id) {
        estudanteService.deletarEstudante(id);
    }

    @PutMapping("/atualizar")
    public void atualizarEstudantes(@RequestBody EstudanteUpdateDto estudanteUpdateDto) {
        estudanteService.atualizarEstudante(estudanteUpdateDto);
    }

    @GetMapping("/listar")
    public List<Estudante> listarEstudantes() {
        return estudanteService.estudanteList();
    }

}
