package com.example.gerenciamentoDeEstudantes.courseTest;

import com.example.gerenciamentoDeEstudantes.dto.CourseCreateDto;
import com.example.gerenciamentoDeEstudantes.entity.Course;
import com.example.gerenciamentoDeEstudantes.repository.CourseRepository;
import com.example.gerenciamentoDeEstudantes.service.CourseService;
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
public class CourseServiceTest {

    @Mock
    CourseRepository courseRepository;

    @InjectMocks
    CourseService courseService;

    @Test
    public void mostCreateCourse() {
        CourseCreateDto courseCreateDto = CourseTest.courseCreateDto();

        Mockito.when(courseRepository.save(Mockito.any())).thenReturn(new Course());

        courseService.createCourse(courseCreateDto);

        Mockito.verify(courseRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    public void mostDeleteCourse() {
        Mockito.doNothing().when(courseRepository).deleteById(1L);

        courseService.deleteCourse(1L);

        Mockito.verify(courseRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    public void mostListCourse() {
        Mockito.when(courseRepository.findAll()).thenReturn(List.of(CourseTest.course()));

        List<Course> list = courseService.listCourse();

        Assertions.assertEquals("Teste1", list.get(0).getName());
        Assertions.assertEquals(2F, list.get(0).getDurationCourse());

        Assertions.assertNotNull(list.get(0));
    }

    @Test
    public void mostUpdateCourse() {
        Mockito.when(courseRepository.findById(1L)).thenReturn(Optional.of((CourseTest.course())));

        Mockito.when(courseRepository.save(Mockito.any())).thenReturn(new Course());

        courseService.updateCourse(CourseTest.courseUpdateDto());

        Mockito.verify(courseRepository, Mockito.times(1)).findById(1L);
        Mockito.verify(courseRepository, Mockito.times(1)).save(Mockito.any());
    }


}
