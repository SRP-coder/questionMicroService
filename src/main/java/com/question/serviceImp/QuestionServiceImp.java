package com.question.serviceImp;

import com.question.model.Question;
import com.question.repository.QuestionRepository;
import com.question.service.AnswerClient;
import com.question.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImp implements QuestionService {

    private QuestionRepository questionRepository;
    private AnswerClient answerClient;

    public QuestionServiceImp(QuestionRepository questionRepository, AnswerClient answerClient) {
        this.questionRepository = questionRepository;
        this.answerClient = answerClient;
    }

    @Override
    public Question add(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> get() {
        List<Question> questions = questionRepository.findAll();
        return questions.stream().map(question -> {
            question.setAnswer(answerClient.getAnswerById(question.getQuestionId()));
            return question;
        }).toList();
    }

    @Override
    public Question get(String id) {
        Question question = questionRepository.findById(id).orElseThrow(()->new RuntimeException("No question"));
        question.setAnswer(answerClient.getAnswerById(question.getQuestionId()));
        return question;
    }
}
