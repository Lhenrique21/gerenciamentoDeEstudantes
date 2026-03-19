package com.example.gerenciamentoDeEstudantes.estudanteTest;

import com.example.gerenciamentoDeEstudantes.dto.EstudanteDto;
import com.example.gerenciamentoDeEstudantes.dto.EstudanteUpdateDto;
import com.example.gerenciamentoDeEstudantes.entity.Estudante;
import com.example.gerenciamentoDeEstudantes.repository.EstudanteRepository;
import com.example.gerenciamentoDeEstudantes.service.EstudanteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EstudanteServiceTest {

    @Mock
    EstudanteRepository estudanteRepository;

    @InjectMocks
    EstudanteService estudanteService;

    @Test
    public void deveCriarEstudante() {
        EstudanteDto estudanteDto = EstudanteTest.estudanteDto();

        Mockito.when(estudanteRepository.save(Mockito.any())).thenReturn(new Estudante());

        estudanteService.criarEstudante(estudanteDto);

        Mockito.verify(estudanteRepository, Mockito.times(1)).save(Mockito.any());

    }

    @Test
    public void deveExcluirEstudante() {
        Mockito.doNothing().when(estudanteRepository).deleteById(1L);

        estudanteService.deletarEstudante(1L);

        Mockito.verify(estudanteRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    public void deveListarEstudantes() {
        Mockito.when(estudanteRepository.findAll()).thenReturn(List.of(EstudanteTest.estudante()));

        List<Estudante> estudantes = estudanteService.estudanteList();

        Assertions.assertEquals("Teste2", estudantes.get(0).getNome());
        Assertions.assertEquals(222, estudantes.get(0).getMatricula());
        Assertions.assertEquals(2, estudantes.get(0).getIdade());

        Assertions.assertNotNull(estudantes.get(0));
    }

    @Test
    public void deveAtualizarEstudantes() {
        EstudanteUpdateDto estudanteUpdateDto = EstudanteTest.estudanteUpdateDto();

        Mockito.when(estudanteRepository.findById(1L)).thenReturn(Optional.of(EstudanteTest.estudante()));

        Mockito.when(estudanteRepository.save(Mockito.any())).thenReturn(new Estudante());

        estudanteService.atualizarEstudante(estudanteUpdateDto);

        Mockito.verify(estudanteRepository, Mockito.times(1)).findById(1L);
        Mockito.verify(estudanteRepository, Mockito.times(1)).save(Mockito.any());
    }
}
