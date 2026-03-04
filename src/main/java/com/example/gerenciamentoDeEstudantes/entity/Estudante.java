package com.example.gerenciamentoDeEstudantes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Estudante")
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, unique = true)
    private int matricula;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Curso curso;

    @Column(nullable = false)
    private int idade;

}
