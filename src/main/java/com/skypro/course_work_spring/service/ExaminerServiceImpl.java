package com.skypro.course_work_spring.service;

import com.skypro.course_work_spring.exceptions.OverrunLimitOfQuestions;
import com.skypro.course_work_spring.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService{

    private final QuestionService mathQuestionService;
    private final QuestionService javaQuestionService;
    Random random = new Random();

    public ExaminerServiceImpl( @Qualifier("mathQuestionService") QuestionService mathQuestionService,
                                @Qualifier("javaQuestionService") QuestionService javaQuestionService) {
        this.mathQuestionService = mathQuestionService;
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        if(amount > (mathQuestionService.getAll().size() + javaQuestionService.getAll().size())
                || amount < 0){
            throw  new OverrunLimitOfQuestions("Количество вопросов в коллекции меньше запрашиваемого");
        }

        Collection<Question> randomQuestions = new HashSet<>();

        while(randomQuestions.size() < amount){
            switch (random.nextInt(2)) {
                case 0 -> randomQuestions.add(mathQuestionService.getRandomQuestion());
                case 1 -> randomQuestions.add(javaQuestionService.getRandomQuestion());
            }
        }
        return randomQuestions;
    }
}
