package com.question.service;

import com.question.model.Answer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8082",value = "Answer-Client") //this is without load balancing
@FeignClient(name = "ANSWER-SERVICE")  //ANSWER-SERVICE	name taking from answer service name,or eureka server
public interface AnswerClient {

    @GetMapping("/answer/answerId/{id}")
    Answer getAnswerById(@PathVariable Long id);

}
