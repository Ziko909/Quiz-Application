package com.quizapplication.dao;

import com.quizapplication.modules.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionDto extends JpaRepository<Question, Integer> {

    public List<Question> findByCategory(String category);
    @Query(value = "SELECT * FROM question WHERE difficultyLevel = 'EASY' ORDER BY RAND() LIMIT 3", nativeQuery = true)
    public List<Question> findEasyQuestions();

    @Query(value = "SELECT * FROM question WHERE difficultyLevel = 'MEDIUM' ORDER BY RAND() LIMIT 3", nativeQuery = true)
    public List<Question> findMeduimQuestions();

    @Query(value = "SELECT * FROM question WHERE difficultyLevel = 'HARD' ORDER BY RAND() LIMIT 3", nativeQuery = true)
    public List<Question> findHardQuestions();
}
