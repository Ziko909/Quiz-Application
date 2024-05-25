package com.quizapplication.services;

import com.quizapplication.modules.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuestionService questionService;

    public ResponseEntity<List<Question>> getRandomQuiz() {
        List<Question> quiz = questionService.getRandomQuestions();
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    public ResponseEntity<List<Question>> getQuizByCategory(String category) {
        List<Question> quiz = questionService.getQuestionsByCategory(category);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }
}
