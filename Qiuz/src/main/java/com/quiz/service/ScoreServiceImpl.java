package com.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dto.ScoreDTO;
import com.quiz.entity.Score;
import com.quiz.repository.ScoreRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public Score saveScore(Long userId, Long quizId, int score) {
        Score scoreEntity = new Score();
        scoreEntity.setUserId(userId);
        scoreEntity.setQuizId(quizId);
        scoreEntity.setScore(score);
        scoreEntity.setTimestamp(LocalDateTime.now());
        return scoreRepository.save(scoreEntity);
    }

    public List<Score> getUserScores(Long userId) {
        return scoreRepository.findByUserId(userId);
    }

    public List<Score> getQuizScores(Long quizId) {
        return scoreRepository.findByQuizId(quizId);
    }
   
    public List<ScoreDTO> getAverageScores() { 
    	return scoreRepository.findAverageScores().stream() .map(record -> new ScoreDTO((Long) record[0], ((Double) record[1]).intValue())) .collect(Collectors.toList()); 
    	}
}

