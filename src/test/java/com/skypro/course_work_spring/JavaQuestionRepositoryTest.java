package com.skypro.course_work_spring;

import com.skypro.course_work_spring.exceptions.QuestionExistInCollection;
import com.skypro.course_work_spring.exceptions.QuestionNotExistInCollection;
import com.skypro.course_work_spring.model.Question;
import com.skypro.course_work_spring.repository.JavaQuestionRepository;
import com.skypro.course_work_spring.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaQuestionRepositoryTest {

    private final QuestionRepository questionRepository = new JavaQuestionRepository();

    private final Question question1 = new Question("Question 1 ", " answer 1");
    private final Question question2 = new Question("Question 2 ", " answer 2");
    private final Question question3 = new Question("Question 3 ", " answer 3");
    private final Question question4 = new Question("Question 4 ", " answer 4");

    @BeforeEach
    public void setUp() {
        questionRepository.add(question2);
        questionRepository.add(question3);
        questionRepository.add(question4);
    }

    @Test
    public void shouldAddQuestions() {
        assertEquals(question1, questionRepository.add(question1));
        assertEquals(4, questionRepository.getAll().size());
    }

    @Test
    public void shouldGetExceptionAdd() {
        assertThrows(QuestionExistInCollection.class, () -> questionRepository.add(question2));
    }

    @Test
    public void shouldRemoveQuestions() {
        assertEquals(question2, questionRepository.remove(question2));
        assertEquals(2, questionRepository.getAll().size());
    }

    @Test
    public void shouldGetExceptionRemoveExistQuestions() {
        assertThrows(QuestionNotExistInCollection.class, () -> questionRepository.remove(question1));
    }

    @Test
    public void shouldGetAllQuestions() {
        assertEquals(3, questionRepository.getAll().size());
    }
}
