package com.quiz.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quiz.dto.ScoreDTO;
import com.quiz.entity.Score;
import com.quiz.service.ScoreService;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoreAPI {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Score>> getUserScores(@PathVariable Long userId) {
        List<Score> scores = scoreService.getUserScores(userId);
        return ResponseEntity.ok(scores);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<Score>> getQuizScores(@PathVariable Long quizId) {
        List<Score> scores = scoreService.getQuizScores(quizId);
        return ResponseEntity.ok(scores);
    }
    
    @GetMapping("/average") public ResponseEntity<List<ScoreDTO>> getAverageScores() {
    	List<ScoreDTO> scores = scoreService.getAverageScores(); 
    	return ResponseEntity.ok(scores); 
    	}
}
