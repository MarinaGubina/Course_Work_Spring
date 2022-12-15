package com.skypro.course_work_spring;

import com.skypro.course_work_spring.exceptions.OverrunLimitOfQuestions;
import com.skypro.course_work_spring.model.Question;
import com.skypro.course_work_spring.service.ExaminerServiceImpl;
import com.skypro.course_work_spring.service.JavaQuestionService;
import com.skypro.course_work_spring.service.MathQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    JavaQuestionService javaQuestionService;

    @Mock
    MathQuestionService mathQuestionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    Collection<Question> mathQuestions = new HashSet<>();
    Collection<Question> javaQuestions = new HashSet<>();

    Question mathTest1 = new Question("Test math 1 ", " answer math 1");
    Question mathTest2 = new Question("Test math 2 ", " answer math 2");
    Question javaTest1 = new Question("Test java 1 ", " answer java 1");
    Question javaTest2 = new Question("Test java 2 ", " answer java 2");

    @BeforeEach
    public void setUp(){
        mathQuestions.add(mathTest1);
        mathQuestions.add(mathTest2);
        javaQuestions.add(javaTest1);
        javaQuestions.add(javaTest2);
    }

    @Test
    public void shouldGetRandomQuestions(){

        when(mathQuestionService.getAll()).thenReturn(mathQuestions);
        when(javaQuestionService.getAll()).thenReturn(javaQuestions);
        when(mathQuestionService.getRandomQuestion()).thenReturn(mathTest2);
        when(javaQuestionService.getRandomQuestion()).thenReturn(javaTest1);

        Collection<Question> randomQuestions = new HashSet<>();
        randomQuestions.add(mathTest2);
        randomQuestions.add(javaTest1);

        boolean result = randomQuestions.equals(examinerService.getQuestions(2));

        assertTrue(result);
}

    @Test
    public void shouldGetExceptionWhenAmountNotValidRandomQuestions(){
        assertThrows(OverrunLimitOfQuestions.class, () -> examinerService.getQuestions(5));
        assertThrows(OverrunLimitOfQuestions.class, () -> examinerService.getQuestions(-5));
    }
}
