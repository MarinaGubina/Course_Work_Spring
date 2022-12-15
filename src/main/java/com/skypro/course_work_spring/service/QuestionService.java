package com.skypro.course_work_spring.service;

import com.skypro.course_work_spring.model.Question;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface QuestionService {

    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();
}
