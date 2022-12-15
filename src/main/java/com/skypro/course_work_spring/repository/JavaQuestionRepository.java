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
public class JavaQuestionRepository implements QuestionRepository{

    private Set<Question> questions = new HashSet<>();

    @Override
    @PostConstruct
    public void init() {
        add(new Question("Вопрос 1", "Ответ 1"));
        add(new Question("Вопрос 2", "Ответ 2"));
        add(new Question("Вопрос 3", "Ответ 3"));
        add(new Question("Вопрос 4", "Ответ 4"));
        add(new Question("Вопрос 5", "Ответ 5"));
        add(new Question("Вопрос 6", "Ответ 6"));
        add(new Question("Вопрос 7", "Ответ 7"));
        add(new Question("Вопрос 8", "Ответ 8"));
        add(new Question("Вопрос 9", "Ответ 9"));
        add(new Question("Вопрос 10", "Ответ 10"));
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
