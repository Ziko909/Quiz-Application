package com.quizapplication.controllers;

import com.quizapplication.modules.Question;
import com.quizapplication.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping("/Quiz")
    public ResponseEntity<List<Question>> getRandomQuiz() {
        return quizService.getRandomQuiz();
    }

    @GetMapping("/Quiz/{category}")
    public ResponseEntity<List<Question>> getQuizByCategory(@PathVariable String category) {
        return quizService.getQuizByCategory(category);
    }
}
