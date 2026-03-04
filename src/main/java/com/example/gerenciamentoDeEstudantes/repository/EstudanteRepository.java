package com.example.gerenciamentoDeEstudantes.repository;

import com.example.gerenciamentoDeEstudantes.entity.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
}
