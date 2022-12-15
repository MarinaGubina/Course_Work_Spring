package com.skypro.course_work_spring.exceptions;

public class QuestionNotExistInCollection extends RuntimeException{

    public QuestionNotExistInCollection(String message) {
        super(message);
    }
}
