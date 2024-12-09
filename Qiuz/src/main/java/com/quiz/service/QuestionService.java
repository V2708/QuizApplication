package com.quiz.service;

import java.util.List;

import com.quiz.dto.QuestionDTO;
import com.quiz.entity.AnswerRequest;
import com.quiz.entity.Question;
import com.quiz.exception.QuestionException;

public interface QuestionService {
  
	Long addQuestion(QuestionDTO questionDTO) throws QuestionException;
	
    List<QuestionDTO> getAllQuestions() throws QuestionException;
    
    QuestionDTO getQuestionById(Long id) throws QuestionException;
    
    long deleteQuestion(long id) throws QuestionException;
    
    public QuestionDTO updateQuestion(Long id, QuestionDTO questionDTO) throws QuestionException;
    
    String checkAnswers(Long quizId, Long userId, List<AnswerRequest> answerRequests);	

	
    
   
}
 