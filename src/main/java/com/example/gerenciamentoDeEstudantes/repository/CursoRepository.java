package com.example.gerenciamentoDeEstudantes.repository;

import com.example.gerenciamentoDeEstudantes.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
