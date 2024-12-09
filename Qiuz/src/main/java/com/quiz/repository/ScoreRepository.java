package com.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quiz.entity.Score;

import java.util.Collection;
import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findByUserId(Long userId);
    List<Score> findByQuizId(Long quizId);
    
    @Query("SELECT s.userId, AVG(s.score) as averageScore FROM Score s GROUP BY s.userId ORDER BY averageScore DESC") 
    List<Object[]> findAverageScores();
}

