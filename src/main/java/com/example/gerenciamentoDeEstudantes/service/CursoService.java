package com.example.gerenciamentoDeEstudantes.service;

import com.example.gerenciamentoDeEstudantes.dto.CursoDto;
import com.example.gerenciamentoDeEstudantes.dto.CursoUpdateDto;
import com.example.gerenciamentoDeEstudantes.entity.Curso;
import com.example.gerenciamentoDeEstudantes.exception.CursoException;
import com.example.gerenciamentoDeEstudantes.mapper.CursoMapper;
import com.example.gerenciamentoDeEstudantes.repository.CursoRepository;

import java.util.List;
import java.util.Optional;

public class CursoService {

    private CursoRepository cursoRepository;

    public void criarCurso(CursoDto cursoDto) {
        try {
            Curso cursoToSave = CursoMapper.mapCursoToEntityCreate(cursoDto);
            cursoRepository.save(cursoToSave);
        } catch (Exception e) {
            throw new CursoException("Erro ao criar Curso" + e.getMessage());
        }
    }

    public void deletarCurso(Long id) {
        try {
            cursoRepository.deleteById(id);
        } catch (Exception e) {
            throw new CursoException("Erro ao deletar curso" + e.getMessage());
        }
    }

    public Curso atualizarCurso(CursoUpdateDto cursoUpdate) {
        try {
            Optional<Curso> curso = cursoRepository.findById(cursoUpdate.getId());
            if (curso.isPresent()) {
                Curso curso1 = curso.get();
                curso1.setNome(cursoUpdate.getNome());
                curso1.setDuracaoCurso(cursoUpdate.getDuracao());
                return cursoRepository.save(curso1);
            }
        } catch (Exception e) {
            throw new CursoException("Erro ao atualizar curso" + e.getMessage());
        }
        throw new CursoException("Curso não encontrado");
    }

    public List<Curso> cursoList() {
        try {
            return cursoRepository.findAll();
        } catch (Exception e) {
            throw new CursoException("Erro ao listar cursos" + e.getMessage());
        }
    }

}

