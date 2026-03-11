package com.example.gerenciamentoDeEstudantes.service;

import com.example.gerenciamentoDeEstudantes.dto.EstudanteDto;
import com.example.gerenciamentoDeEstudantes.dto.EstudanteUpdateDto;
import com.example.gerenciamentoDeEstudantes.entity.Estudante;
import com.example.gerenciamentoDeEstudantes.exception.EstudanteException;
import com.example.gerenciamentoDeEstudantes.mapper.EstudanteMapper;
import com.example.gerenciamentoDeEstudantes.repository.EstudanteRepository;

import java.util.List;
import java.util.Optional;

public class EstudanteService {
    private EstudanteRepository estudanteRepository;

    public void criarEstudante(EstudanteDto estudanteDto) {
        try {
            Estudante estudanteToSave = EstudanteMapper.mapEstudanteToEntityCreate(estudanteDto);
            estudanteRepository.save(estudanteToSave);
        } catch (Exception e) {
            throw new EstudanteException("Erro ao criar estudante" + e.getMessage());
        }
    }

    public void deletarEstudante(Long id) {
        try {
            estudanteRepository.deleteById(id);
        } catch (Exception e) {
            throw new EstudanteException("Erro ao deletar estudante" + e.getMessage());
        }
    }

    public void atualizarEstudante(EstudanteUpdateDto estudanteUpdateDto) {
        try {
            Optional<Estudante> estudante = estudanteRepository.findById(estudanteUpdateDto.getId());
            if (estudante.isPresent()) {
                Estudante estudante1 = estudante.get();
                estudante1.setNome(estudanteUpdateDto.getNome());
                estudante1.setMatricula(estudanteUpdateDto.getMatricula());
                estudante1.setCurso(estudanteUpdateDto.getCurso());
                estudante1.setIdade(estudanteUpdateDto.getIdade());
            }
        } catch (Exception e) {
            throw new EstudanteException("Erro ao atualizar estudante" + e.getMessage());
        }
    }

    public List<Estudante> estudanteList() {
        try {
                return estudanteRepository.findAll();
        } catch (Exception e) {
            throw new EstudanteException("Erro ao listar estudantes" + e.getMessage());
        }
    }
}
