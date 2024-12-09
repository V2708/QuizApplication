package com.quiz.dto;

public class ScoreDTO {
    private Long userId;
    private int score;

    public ScoreDTO(Long userId, int score) {
        this.userId = userId;
        this.score = score;
    }

   
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

