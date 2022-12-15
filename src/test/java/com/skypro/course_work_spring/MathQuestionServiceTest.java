package com.skypro.course_work_spring;

import com.skypro.course_work_spring.model.Question;
import com.skypro.course_work_spring.repository.MathQuestionRepository;
import com.skypro.course_work_spring.service.MathQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {

    @Mock
    private MathQuestionRepository questionRepository;

    @InjectMocks
    private MathQuestionService questionService;

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
