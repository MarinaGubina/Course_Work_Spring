package com.skypro.course_work_spring.controller;

import com.skypro.course_work_spring.model.Question;
import com.skypro.course_work_spring.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {

    private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount){
        return examinerService.getQuestions(amount);
    }
}
