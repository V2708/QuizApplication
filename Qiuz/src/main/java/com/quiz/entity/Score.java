package com.quiz.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long quizId;
    private int score;
    private LocalDateTime timestamp;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getQuizId() {
		return quizId;
	}
	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "Score [id=" + id + ", userId=" + userId + ", quizId=" + quizId + ", score=" + score + ", timestamp="
				+ timestamp + "]";
	}

    // Constructors, getters, and setters
    
}

