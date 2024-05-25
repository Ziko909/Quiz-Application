package com.quizapplication.dao;

import com.quizapplication.modules.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    public List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM Question WHERE difficulty_level = 'Easy' ORDER BY random() LIMIT 3", nativeQuery = true)
    public List<Question> findEasyQuestions();

    @Query(value = "SELECT * FROM Question WHERE difficulty_level = 'Medium' ORDER BY random() LIMIT 3", nativeQuery = true)
    public List<Question> findMeduimQuestions();

    @Query(value = "SELECT * FROM Question WHERE difficulty_level = 'Hard' ORDER BY random() LIMIT 3", nativeQuery = true)
    public List<Question> findHardQuestions();
}
