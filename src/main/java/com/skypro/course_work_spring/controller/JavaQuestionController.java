package com.skypro.course_work_spring.controller;

import com.skypro.course_work_spring.model.Question;
import com.skypro.course_work_spring.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private QuestionService questionService;

    public JavaQuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer){
        return questionService.add(question,answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer){
        Question tmp = new Question(question,answer);
        return questionService.remove(tmp);
    }

    @GetMapping("")
    public Collection<Question> getQuestions(){
        return questionService.getAll();
    }
}
