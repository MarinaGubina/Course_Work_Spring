package com.skypro.course_work_spring;

import com.skypro.course_work_spring.model.Question;
import com.skypro.course_work_spring.service.ExaminerServiceImpl;
import com.skypro.course_work_spring.service.QuestionService;
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
    QuestionService questionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    Collection<Question> questions = new HashSet<>();

    @BeforeEach
    public void setUp(){
        Question question1 = new Question("Question 1 ", " answer 1");
        Question question2 = new Question("Question 2 ", " answer 2");
        Question question3 = new Question("Question 3 ", " answer 3");
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);

        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenReturn(question1,question2,question3);
    }

    @Test
    public void shouldGetRandomQuestions(){
        assertEquals(questions, examinerService.getQuestions(3));
    }
}
