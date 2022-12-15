package com.skypro.course_work_spring.service;

import com.skypro.course_work_spring.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
