package com.skypro.course_work_spring.service;

import com.skypro.course_work_spring.exceptions.QuestionExistInCollection;
import com.skypro.course_work_spring.exceptions.QuestionNotExistInCollection;
import com.skypro.course_work_spring.model.Question;
import com.skypro.course_work_spring.repository.JavaQuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("javaQuestionService")
public class JavaQuestionService implements QuestionService{

    private final JavaQuestionRepository javaQuestionRepository;

    private Random rand = new Random();

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        if(question == null || answer == null ||
        question.isEmpty() || answer.isEmpty()){
            throw new RuntimeException("Вопрос не должен быть пустой");
        }
        return add(new Question(question,answer));
    }

    @Override
    public Question add(Question question) {
        return javaQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return javaQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(getAll());
        return  list.get(rand.nextInt(list.size()));
    }
}
