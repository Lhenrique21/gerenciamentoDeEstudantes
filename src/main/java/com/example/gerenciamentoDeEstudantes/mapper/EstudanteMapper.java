package com.example.gerenciamentoDeEstudantes.mapper;

import com.example.gerenciamentoDeEstudantes.dto.EstudanteDto;
import com.example.gerenciamentoDeEstudantes.entity.Estudante;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EstudanteMapper {

    public Estudante mapEstudanteToEntityCreate(EstudanteDto estudanteDto){
        Estudante novoEstudante = new Estudante();
        novoEstudante.setNome(estudanteDto.getNome());
        novoEstudante.setIdade(estudanteDto.getIdade());
        novoEstudante.setMatricula(estudanteDto.getMatricula());
        novoEstudante.setCurso(estudanteDto.getCurso());

        return novoEstudante;
    }
}
