package com.skypro.course_work_spring.repository;

import com.skypro.course_work_spring.model.Question;

import java.util.Collection;

public interface QuestionRepository {

    void init();
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
}
