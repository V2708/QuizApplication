package com.quiz.service;

import com.quiz.dto.ScoreDTO;
import com.quiz.entity.Score;

import java.util.List;

public interface ScoreService {
	
	public Score saveScore(Long userId, Long quizId, int score);
	
	public List<Score> getUserScores(Long userId);
	
	public List<Score> getQuizScores(Long quizId);
	
	public List<ScoreDTO> getAverageScores();
}
