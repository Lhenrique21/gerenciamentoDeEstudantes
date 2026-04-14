package com.example.gerenciamentoDeEstudantes.dto;

import com.example.gerenciamentoDeEstudantes.entity.Curso;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EstudanteDto {

    private String nome;
    private int matricula;
    private Curso curso;
    private int idade;
}
