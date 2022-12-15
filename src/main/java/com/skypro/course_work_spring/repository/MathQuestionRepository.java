package com.skypro.course_work_spring.repository;

import com.skypro.course_work_spring.exceptions.QuestionExistInCollection;
import com.skypro.course_work_spring.exceptions.QuestionNotExistInCollection;
import com.skypro.course_work_spring.model.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository{

    private Set<Question> questions = new HashSet<>();

    @Override
    @PostConstruct
    public void init() {
        add(new Question("2*2", "Ответ 4"));
        add(new Question("5*5", "Ответ 25"));
        add(new Question("24/6", "Ответ 4"));
        add(new Question("10+12", "Ответ 22"));
        add(new Question("3-8", "Ответ -5"));
        add(new Question("11-7", "Ответ 4"));
        add(new Question("8-1", "Ответ 7"));
        add(new Question("4*4", "Ответ 16"));
        add(new Question("7+6", "Ответ 13"));
        add(new Question("3*0", "Ответ 0"));
    }

    @Override
    public Question add(Question question) {
        if(questions.contains(question)){
            throw new QuestionExistInCollection("В списке уже есть этот вопрос!");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if(!questions.contains(question)){
            throw new QuestionNotExistInCollection("В списке не найден этот вопрос!");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
