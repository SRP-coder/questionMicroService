package com.question.controller;

import com.question.model.Question;
import com.question.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/save")
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question){
      return new ResponseEntity<>(questionService.add(question), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable String id){
        return new ResponseEntity<>(questionService.get(id),HttpStatus.OK);
    }

    @GetMapping("/allQuestion")
    public List<Question> getAllQuestion(){
        return questionService.get();
    }

}
