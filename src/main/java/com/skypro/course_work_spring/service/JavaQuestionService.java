package com.skypro.course_work_spring.service;

import com.skypro.course_work_spring.exceptions.QuestionExistInCollection;
import com.skypro.course_work_spring.exceptions.QuestionNotExistInCollection;
import com.skypro.course_work_spring.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{

    private final Set<Question> questions = new HashSet<>();

    private Random rand = new Random();

    @Override
    public Question add(String question, String answer) {
        if(question == null || answer == null){
            throw new RuntimeException("Вопрос не должен быть пустой");
        }
        return add(new Question(question,answer));
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

    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(questions);
        return  list.get(rand.nextInt(list.size()));
    }
}
