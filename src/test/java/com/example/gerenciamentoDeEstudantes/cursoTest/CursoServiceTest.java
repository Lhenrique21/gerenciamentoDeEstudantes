package com.example.gerenciamentoDeEstudantes.cursoTest;

import com.example.gerenciamentoDeEstudantes.dto.CursoDto;
import com.example.gerenciamentoDeEstudantes.entity.Curso;
import com.example.gerenciamentoDeEstudantes.repository.CursoRepository;
import com.example.gerenciamentoDeEstudantes.service.CursoService;
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
public class CursoServiceTest {

    @Mock
    CursoRepository cursoRepository;

    @InjectMocks
    CursoService cursoService;

    @Test
    public void deveCriarCurso() {
        CursoDto cursoDto = CursoTest.cursoDto();

        Mockito.when(cursoRepository.save(Mockito.any())).thenReturn(new Curso());

        cursoService.criarCurso(cursoDto);

        Mockito.verify(cursoRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    public void deveExcluirCurso() {
        Mockito.doNothing().when(cursoRepository).deleteById(1L);

        cursoService.deletarCurso(1L);

        Mockito.verify(cursoRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    public void deveListarCurso() {
        Mockito.when(cursoRepository.findAll()).thenReturn(List.of(CursoTest.curso()));

        List<Curso> list = cursoService.cursoList();

        Assertions.assertEquals("Teste1", list.get(0).getNome());
        Assertions.assertEquals(2F, list.get(0).getDuracaoCurso());

        Assertions.assertNotNull(list.get(0));
    }

    @Test
    public void deveAtualizarCurso() {
        Mockito.when(cursoRepository.findById(1L)).thenReturn(Optional.of((CursoTest.curso())));

        Mockito.when(cursoRepository.save(Mockito.any())).thenReturn(new Curso());

        cursoService.atualizarCurso(CursoTest.cursoUpdateDto());

        Mockito.verify(cursoRepository, Mockito.times(1)).findById(1L);
        Mockito.verify(cursoRepository, Mockito.times(1)).save(Mockito.any());
    }


}
