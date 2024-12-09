package com.quiz.dto;

import java.util.List;

public class QuestionDTO {
    private Long id;
    private String title;
    private List<String> optionsList;
    private List<String> correctAnswersList;

    // Constructors, getters, and setters
    public QuestionDTO() {}

    public QuestionDTO(Long id, String title, List<String> optionsList, List<String> correctAnswersList) {
        this.id = id;
        this.title = title;
        this.optionsList = optionsList;
        this.correctAnswersList = correctAnswersList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(List<String> optionsList) {
        this.optionsList = optionsList;
    }

    public List<String> getCorrectAnswersList() {
        return correctAnswersList;
    }

    public void setCorrectAnswersList(List<String> correctAnswersList) {
        this.correctAnswersList = correctAnswersList;
    }
}
