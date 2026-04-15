package com.example.gerenciamentoDeEstudantes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StudentUpdateDto extends StudentCreateDto {
    private Long id;
}
