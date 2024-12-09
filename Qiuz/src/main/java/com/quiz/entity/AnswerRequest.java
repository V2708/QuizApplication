package com.quiz.entity;

import java.util.List;

public class AnswerRequest {
    private Long questionId;
    private List<String> userAnswers;

    // Constructors, getters, and setters
    public AnswerRequest() {}

    public AnswerRequest(Long questionId, List<String> userAnswers) {
        this.questionId = questionId;
        this.userAnswers = userAnswers;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public List<String> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<String> userAnswers) {
        this.userAnswers = userAnswers;
    }
}
