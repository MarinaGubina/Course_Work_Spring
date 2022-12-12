package com.skypro.course_work_spring;

import com.skypro.course_work_spring.exceptions.QuestionExistInCollection;
import com.skypro.course_work_spring.exceptions.QuestionNotExistInCollection;
import com.skypro.course_work_spring.model.Question;
import com.skypro.course_work_spring.service.JavaQuestionService;
import com.skypro.course_work_spring.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {

    private final QuestionService questionService = new JavaQuestionService();
    private final Question question1 = new Question("Question 1 ", " answer 1");
    private final Question question2 = new Question("Question 2 ", " answer 2");
    private final Question question3 = new Question("Question 3 ", " answer 3");
    private final Question question4 = new Question("Question 4 ", " answer 4");

    @Nested
    class allTestWithoutOne {

        @BeforeEach
        public void setUp() {
            questionService.add(question2);
            questionService.add(question3);
            questionService.add(question4);
        }

        @Test
        public void shouldAddQuestions() {
            assertEquals(question1, questionService.add(question1));
            assertEquals(4, questionService.getAll().size());
        }

        @Test
        public void shouldAddQuestionAndAnswer() {
            Question question = new Question("Test", "Test answer");
            assertEquals(question, questionService.add("Test", "Test answer"));
            assertEquals(4, questionService.getAll().size());
        }

        @Test
        public void shouldGetExceptionAdd() {
            assertThrows(QuestionExistInCollection.class, () -> questionService.add(question2));
        }

        @Test
        public void shouldRemoveQuestions() {
            assertEquals(question2, questionService.remove(question2));
            assertEquals(2, questionService.getAll().size());
        }

        @Test
        public void shouldGetExceptionRemoveExistQuestions() {
            assertThrows(QuestionNotExistInCollection.class, () -> questionService.remove(question1));
        }

        @Test
        public void shouldGetAllQuestions() {
            assertEquals(3, questionService.getAll().size());
        }
    }

    @Test
    public void shouldGetRandomQuestion(){
        questionService.add(question1);
        Question random = questionService.getRandomQuestion();
        assertEquals(question1,random);
    }
}
