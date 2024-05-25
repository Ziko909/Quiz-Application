package com.quizapplication.services;

import com.quizapplication.dao.QuestionDao;
import com.quizapplication.modules.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getRandomQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.addAll(this.questionDao.findEasyQuestions());
        questions.addAll(this.questionDao.findMeduimQuestions());
        questions.addAll(this.questionDao.findHardQuestions());
        return questions;
    }

    public  List<Question> getQuestionsByCategory(String category) {
        return this.questionDao.findByCategory(category);
    }
}
