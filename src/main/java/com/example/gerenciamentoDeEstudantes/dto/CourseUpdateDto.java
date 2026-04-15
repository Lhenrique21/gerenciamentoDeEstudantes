package com.example.gerenciamentoDeEstudantes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseUpdateDto extends CourseCreateDto {
    private Long id;
}
