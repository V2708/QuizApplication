package com.quiz.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.quiz.dto.QuestionDTO;
import com.quiz.entity.AnswerRequest;
import com.quiz.entity.Question;
import com.quiz.exception.QuestionException;
import com.quiz.repository.QuestionRepository;

import jakarta.transaction.Transactional;

@Service

public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
	private Environment environment;
    
    @Autowired private ScoreService scoreService;

    @Override
    @Transactional
    public Long addQuestion(QuestionDTO questionDTO) throws QuestionException { 
    	Question question = new Question(); 
    	question.setTitle(questionDTO.getTitle()); 
    	question.setOptionsList(questionDTO.getOptionsList()); 
    	question.setCorrectAnswersList(questionDTO.getCorrectAnswersList()); 
    	question = questionRepository.save(question); 
    	QuestionDTO newQuestionDTO = new QuestionDTO(); 
    	newQuestionDTO.setId(question.getId()); 
    	newQuestionDTO.setTitle(question.getTitle()); 
    	newQuestionDTO.setOptionsList(question.getOptionsList()); 
    	newQuestionDTO.setCorrectAnswersList(question.getCorrectAnswersList()); 
    	return newQuestionDTO.getId(); 
    	}
    
    
    
    @Override
    public List<QuestionDTO> getAllQuestions() throws QuestionException { 
    	List<Question> questions = questionRepository.findAll(); 
    	if (questions.isEmpty()) { 
    		throw new QuestionException("The question list is empty."); 
    		} 
    	List<QuestionDTO> questionDTOs = new ArrayList<>();
    	
    	for (Question question : questions) {
    		QuestionDTO questionDTO = new QuestionDTO(); 
    		questionDTO.setId(question.getId()); 
    		questionDTO.setTitle(question.getTitle()); 
    		questionDTO.setOptionsList(question.getOptionsList()); 
    		questionDTOs.add(questionDTO); 
    		} 
    	return questionDTOs; 
    	}

    
    
    
    
    @Override
    public QuestionDTO getQuestionById(Long id) throws QuestionException { 
    	Optional<Question> questionOpt = questionRepository.findById(id); 
    	if (questionOpt.isEmpty()) { 
    		String message=environment.getProperty("API_QUESTION_NOT_FOUND");
    		throw new QuestionException(message+ id); 
    		} 
    	Question question = questionOpt.get();
    	QuestionDTO questionDTO = new QuestionDTO(); 
    	questionDTO.setId(question.getId()); 
    	questionDTO.setTitle(question.getTitle());
    	questionDTO.setOptionsList(question.getOptionsList()); 
    	return questionDTO; 
    	} 
    
    

	@Override
	public long deleteQuestion(long id) throws QuestionException {
		// TODO Auto-generated method stub
		

		Question q=questionRepository.findById(id).orElseThrow(()-> new QuestionException("API_QUESTION_NOT_FOUND"+ id));
		questionRepository.deleteById(id);
		
		return q.getId();
	}

	
	
	
	@Override
	public QuestionDTO updateQuestion(Long id, QuestionDTO questionDTO) throws QuestionException { 
		Optional<Question> questionOpt = questionRepository.findById(id); 
		if (questionOpt.isEmpty()) { 
			throw new QuestionException("Question not found with id: " + id);
			}
		     Question question = questionOpt.get(); question.setTitle(questionDTO.getTitle()); 
			question.setOptionsList(questionDTO.getOptionsList()); 
			question.setCorrectAnswersList(questionDTO.getCorrectAnswersList()); 
			question = questionRepository.save(question);
			QuestionDTO updatedQuestionDTO = new QuestionDTO(); 
			updatedQuestionDTO.setId(question.getId()); 
			updatedQuestionDTO.setTitle(question.getTitle()); 
			updatedQuestionDTO.setOptionsList(question.getOptionsList()); 
			updatedQuestionDTO.setCorrectAnswersList(question.getCorrectAnswersList()); 
			return updatedQuestionDTO; 
			}



	

	    
           @Override
	    public String checkAnswers(Long quizId, Long userId, List<AnswerRequest> answerRequests) {
	        int totalQuestions = answerRequests.size();
	        int correctAnswers = 0;

	        for (AnswerRequest answerRequest : answerRequests) {
	            if (isAnswerCorrect(answerRequest)) {
	                correctAnswers++;
	            }
	        }

	        int score = (correctAnswers * 100) / totalQuestions;
	        scoreService.saveScore(userId, quizId, score);

	        return "Your score is: " + score;
	    }

	    private boolean isAnswerCorrect(AnswerRequest answerRequest) {
	        Optional<Question> questionOptional = questionRepository.findById(answerRequest.getQuestionId());

	        if (questionOptional.isPresent()) {
	            Question question = questionOptional.get();
	            List<String> correctAnswers = question.getCorrectAnswersList();
	            List<String> userAnswers = answerRequest.getUserAnswers();

	            // Both lists must contain the same elements to be considered correct
	            return correctAnswers.containsAll(userAnswers) && userAnswers.containsAll(correctAnswers);
	        }

	        return false;
	    }
	 

	
}
