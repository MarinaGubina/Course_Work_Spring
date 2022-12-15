package com.skypro.course_work_spring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class OverrunLimitOfQuestions extends RuntimeException{

    public OverrunLimitOfQuestions(String message) {
        super(message);
    }
}
