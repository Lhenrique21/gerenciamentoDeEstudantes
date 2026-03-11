package com.example.gerenciamentoDeEstudantes.controller;

import com.example.gerenciamentoDeEstudantes.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstudanteController {

    @Autowired
    EstudanteRepository estudanteRepository;
}
