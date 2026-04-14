package com.example.gerenciamentoDeEstudantes.estudanteTest;

import com.example.gerenciamentoDeEstudantes.dto.EstudanteDto;
import com.example.gerenciamentoDeEstudantes.dto.EstudanteUpdateDto;
import com.example.gerenciamentoDeEstudantes.entity.Curso;
import com.example.gerenciamentoDeEstudantes.entity.Estudante;

public class EstudanteTest {

    public static EstudanteDto estudanteDto() {
        EstudanteDto estudanteDto = new EstudanteDto();
        Curso curso = new Curso();
        estudanteDto.setCurso(curso);
        estudanteDto.setNome("Teste1");
        estudanteDto.setIdade(1);
        estudanteDto.setMatricula(111);

        return estudanteDto;
    }

    public static Estudante estudante() {
        Estudante estudante = new Estudante();
        Curso curso = new Curso();
        estudante.setCurso(curso);
        estudante.setNome("Teste2");
        estudante.setIdade(2);
        estudante.setMatricula(222);

        return estudante;
    }

    public static EstudanteUpdateDto estudanteUpdateDto() {
        EstudanteUpdateDto estudanteUpdateDto = new EstudanteUpdateDto();
        Curso curso = new Curso();
        estudanteUpdateDto.setId(1L);
        estudanteUpdateDto.setNome("Teste3");
        estudanteUpdateDto.setCurso(curso);
        estudanteUpdateDto.setMatricula(333);
        estudanteUpdateDto.setIdade(3);

        return estudanteUpdateDto;
    }
}
