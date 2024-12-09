package com.quiz.entity;

import java.util.List;

public class CheckAnswerRequest {
    private Long quizId;
    private Long userId;
    private List<AnswerRequest> answerRequests;
	public Long getQuizId() {
		return quizId;
	}
	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<AnswerRequest> getAnswerRequests() {
		return answerRequests;
	}
	public void setAnswerRequests(List<AnswerRequest> answerRequests) {
		this.answerRequests = answerRequests;
	}

   
    
}
