package com.example.gerenciamentoDeEstudantes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "CURSO")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String nome;

    @Column(nullable = false)
    private Float duracaoCurso;

    @OneToMany
    @JoinColumn(nullable = true)
    private List<Estudante> estudante;
}
