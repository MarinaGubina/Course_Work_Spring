package com.skypro.course_work_spring.exceptions;

public class QuestionExistInCollection extends RuntimeException{

    public QuestionExistInCollection(String message) {
        super(message);
    }
}
