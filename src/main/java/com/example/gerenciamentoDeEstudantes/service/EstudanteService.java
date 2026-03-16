package com.example.gerenciamentoDeEstudantes.service;

import com.example.gerenciamentoDeEstudantes.dto.EstudanteDto;
import com.example.gerenciamentoDeEstudantes.dto.EstudanteUpdateDto;
import com.example.gerenciamentoDeEstudantes.entity.Estudante;
import com.example.gerenciamentoDeEstudantes.exception.EstudanteException;
import com.example.gerenciamentoDeEstudantes.mapper.EstudanteMapper;
import com.example.gerenciamentoDeEstudantes.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    @Autowired
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

    public Estudante atualizarEstudante(EstudanteUpdateDto estudanteUpdateDto) {
        try {
            Optional<Estudante> estudante = estudanteRepository.findById(estudanteUpdateDto.getId());
            if (estudante.isPresent()) {
                Estudante estudante1 = estudante.get();
                estudante1.setNome(estudanteUpdateDto.getNome());
                estudante1.setMatricula(estudanteUpdateDto.getMatricula());
                estudante1.setCurso(estudanteUpdateDto.getCurso());
                estudante1.setIdade(estudanteUpdateDto.getIdade());
                return estudanteRepository.save(estudante1);
            }
        } catch (Exception e) {
            throw new EstudanteException("Erro ao atualizar estudante" + e.getMessage());
        }
        throw new EstudanteException(("Id do estudante não encontrado"));
    }

    public List<Estudante> estudanteList() {
        try {
            return estudanteRepository.findAll();
        } catch (Exception e) {
            throw new EstudanteException("Erro ao listar estudantes" + e.getMessage());
        }
    }
}
