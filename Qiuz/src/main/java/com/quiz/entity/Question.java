package com.quiz.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Transient;

import java.util.List;
//
//
//
//
//
//import java.util.Arrays;
//
//
//
//
//@Entity
//public class Question {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String title;
//
//    @Lob
//    private String options;
//
//    @Lob
//    private String correctAnswers;
//
//    @Transient
//    private List<String> optionsList;
//
//    @Transient
//    private List<String> correctAnswersList;
//
//    // Getters and setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public List<String> getOptionsList() {
//        if (options == null) {
//            return null;
//        }
//        return Arrays.asList(options.split(","));
//    }
//
//    public void setOptionsList(List<String> optionsList) {
//        this.optionsList = optionsList;
//        this.options = String.join(",", optionsList);
//    }
//
//    public List<String> getCorrectAnswersList() {
//        if (correctAnswers == null) {
//            return null;
//        }
//        return Arrays.asList(correctAnswers.split(","));
//    }
//
//    public void setCorrectAnswersList(List<String> correctAnswersList) {
//        this.correctAnswersList = correctAnswersList;
//        this.correctAnswers = String.join(",", correctAnswersList);
//    }
//
//    @PrePersist
//    @PreUpdate
//    private void convertListsToString() {
//        options = optionsList != null ? String.join(",", optionsList) : null;
//        correctAnswers = correctAnswersList != null ? String.join(",", correctAnswersList) : null;
//    }
//
//    @PostLoad
//    private void convertStringToLists() {
//        optionsList = options != null ? Arrays.asList(options.split(",")) : null;
//        correctAnswersList = correctAnswers != null ? Arrays.asList(correctAnswers.split(",")) : null;
//    }
//
//    @Override
//    public String toString() {
//    	return "Question{" + "id=" + id + ", title='" + title + '\'' + ", options=" + optionsList + '}';
//    }
//}
//
//


import java.util.Arrays;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Lob
    private String options;

    @Lob
    private String correctAnswers;

    @Transient
    private List<String> optionsList;

    @Transient
    private List<String> correctAnswersList;

    // Getters and setters
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
        if (options == null) {
            return null;
        }
        return Arrays.asList(options.split(","));
    }

    public void setOptionsList(List<String> optionsList) {
        this.optionsList = optionsList;
        this.options = String.join(",", optionsList);
    }

    public List<String> getCorrectAnswersList() {
        if (correctAnswers == null) {
            return null;
        }
        return Arrays.asList(correctAnswers.split(","));
    }

    public void setCorrectAnswersList(List<String> correctAnswersList) {
        this.correctAnswersList = correctAnswersList;
        this.correctAnswers = String.join(",", correctAnswersList);
    }

    @PrePersist
    @PreUpdate
    private void convertListsToString() {
        options = optionsList != null ? String.join(",", optionsList) : null;
        correctAnswers = correctAnswersList != null ? String.join(",", correctAnswersList) : null;
    }

    @PostLoad
    private void convertStringToLists() {
        optionsList = options != null ? Arrays.asList(options.split(",")) : null;
        correctAnswersList = correctAnswers != null ? Arrays.asList(correctAnswers.split(",")) : null;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", title='" + title + '\'' + ", options=" + optionsList + '}';
    }
}

