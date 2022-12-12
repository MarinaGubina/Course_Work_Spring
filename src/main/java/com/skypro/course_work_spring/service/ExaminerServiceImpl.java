package com.skypro.course_work_spring.service;

import com.skypro.course_work_spring.exceptions.OverrunLimitOfQuestions;
import com.skypro.course_work_spring.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService{

    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if(amount > questionService.getAll().size() || amount < 0){
            throw  new OverrunLimitOfQuestions("Количество вопросов в коллекции меньше запрашиваемого");
        }
        Set<Question> randomQuestions = new HashSet<>();
        while(randomQuestions.size() < amount){
            randomQuestions.add(questionService.getRandomQuestion());
        }
        return randomQuestions;
    }
}
