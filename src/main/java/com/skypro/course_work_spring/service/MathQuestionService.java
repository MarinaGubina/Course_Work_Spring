package com.skypro.course_work_spring.service;

import com.skypro.course_work_spring.model.Question;
import com.skypro.course_work_spring.repository.MathQuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("mathQuestionService")
public class MathQuestionService  implements QuestionService{

    private final MathQuestionRepository mathQuestionRepository;

    private Random rand = new Random();

    public MathQuestionService(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        if(question == null || answer == null ||
                question.isEmpty() || answer.isEmpty() ){
            throw new RuntimeException("Вопрос не должен быть пустой");
        }
        return add(new Question(question,answer));
    }

    @Override
    public Question add(Question question) {
        return mathQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return mathQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(getAll());
        return  list.get(rand.nextInt(list.size()));
    }
}
