package com.question.service;

import com.question.model.Question;

import java.util.List;

public interface QuestionService {

    Question add(Question question);

    List<Question> get();

    Question get(String id);
}
