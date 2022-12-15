package com.skypro.course_work_spring;

import com.skypro.course_work_spring.model.Question;
import com.skypro.course_work_spring.repository.JavaQuestionRepository;
import com.skypro.course_work_spring.service.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    private JavaQuestionRepository questionRepository;

    @InjectMocks
    private JavaQuestionService questionService;

    @Test
    public void shouldNewExceptionAddNewQuestionWithQAndA(){
        assertThrows(RuntimeException.class, () -> questionService.add("",""));
    }

    @Test
    public void shouldGetRandomQuestion(){
        Set<Question> questions = Set.of(
                new Question("Question 1 ", " answer 1"),
                new Question("Question 2 ", " answer 2"),
                new Question("Question 3 ", " answer 3")
        );

        when(questionRepository.getAll()).thenReturn(questions);


        Question random = questionService.getRandomQuestion();
        boolean result = false;
        for (Question q: questionRepository.getAll()) {
            if(random.equals(q)){
                result = true;
                return;
            }
        }
        assertTrue(result);
    }
}