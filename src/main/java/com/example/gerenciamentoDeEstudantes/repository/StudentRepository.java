package com.example.gerenciamentoDeEstudantes.repository;

import com.example.gerenciamentoDeEstudantes.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
