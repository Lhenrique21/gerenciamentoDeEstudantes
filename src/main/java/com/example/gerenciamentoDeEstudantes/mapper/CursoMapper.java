package com.example.gerenciamentoDeEstudantes.mapper;

import com.example.gerenciamentoDeEstudantes.dto.CursoDto;
import com.example.gerenciamentoDeEstudantes.entity.Curso;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CursoMapper {

    public Curso mapCursoToEntityCreate(CursoDto curso){
        Curso novoCurso = new Curso();
        novoCurso.setNome(curso.getNome());
        novoCurso.setDuracaoCurso(curso.getDuracao());

        return novoCurso;
    }
}
