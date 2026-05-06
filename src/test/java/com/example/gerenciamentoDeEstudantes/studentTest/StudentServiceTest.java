package com.example.gerenciamentoDeEstudantes.studentTest;

import com.example.gerenciamentoDeEstudantes.dto.StudentCreateDto;
import com.example.gerenciamentoDeEstudantes.dto.StudentUpdateDto;
import com.example.gerenciamentoDeEstudantes.entity.Student;
import com.example.gerenciamentoDeEstudantes.repository.StudentRepository;
import com.example.gerenciamentoDeEstudantes.service.StudentService;
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
public class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void mustCreateStudent() {
        StudentCreateDto studentCreateDto = StudentTest.studentDto();

        Mockito.when(studentRepository.save(Mockito.any())).thenReturn(new Student());

        studentService.createStudent(studentCreateDto);

        Mockito.verify(studentRepository, Mockito.times(1)).save(Mockito.any());

    }

    @Test
    public void mustDeleteStudent() {
        Mockito.doNothing().when(studentRepository).deleteById(1L);

        studentService.deleteStudent(1L);

        Mockito.verify(studentRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    public void mustListStudent() {
        Mockito.when(studentRepository.findAll()).thenReturn(List.of(StudentTest.student()));

        List<Student> students = studentService.listStudent();

        Assertions.assertEquals("Teste2", students.get(0).getName());
        Assertions.assertEquals(222, students.get(0).getEnrollment());
        Assertions.assertEquals(2, students.get(0).getAge());

        Assertions.assertNotNull(students.get(0));
    }

    @Test
    public void mustUpdateStudent() {
        StudentUpdateDto estudanteUpdateDto = StudentTest.studentUpdateDto();

        Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(StudentTest.student()));

        Mockito.when(studentRepository.save(Mockito.any())).thenReturn(new Student());

        studentService.updateStudent(estudanteUpdateDto);

        Mockito.verify(studentRepository, Mockito.times(1)).findById(1L);
        Mockito.verify(studentRepository, Mockito.times(1)).save(Mockito.any());
    }
}
