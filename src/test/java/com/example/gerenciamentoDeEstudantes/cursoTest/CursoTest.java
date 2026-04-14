package com.example.gerenciamentoDeEstudantes.cursoTest;

import com.example.gerenciamentoDeEstudantes.dto.CursoDto;
import com.example.gerenciamentoDeEstudantes.dto.CursoUpdateDto;
import com.example.gerenciamentoDeEstudantes.entity.Curso;

public class CursoTest {

    public static CursoDto cursoDto(){
        CursoDto cursoDto = new CursoDto();
        cursoDto.setNome("Teste1");
        cursoDto.setDuracao(2);

        return cursoDto;
    }

    public static Curso curso(){
        Curso curso = new Curso();
        curso.setNome("Teste1");
        curso.setDuracaoCurso(2F);

        return curso;
    }

    public static CursoUpdateDto cursoUpdateDto(){
        CursoUpdateDto cursoUpdateDto = new CursoUpdateDto();
        cursoUpdateDto.setId(1L);
        cursoUpdateDto.setNome("Teste2");
        cursoUpdateDto.setDuracao(3);

        return cursoUpdateDto;
    }

}
